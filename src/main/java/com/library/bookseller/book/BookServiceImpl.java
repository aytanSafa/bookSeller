package com.library.bookseller.book;

import com.library.bookseller.author.Author;
import com.library.bookseller.author.AuthorService;
import com.library.bookseller.book.request.BookReqDto;
import com.library.bookseller.book.request.BookResDto;
import com.library.bookseller.book.request.BookUpdDto;
import com.library.bookseller.categories.CategoriesService;
import com.library.bookseller.exceptions.BookServiceException;
import com.library.bookseller.exceptions.generic.BookSellerException;
import com.library.bookseller.users.UserService;
import com.library.bookseller.users.UsersDAO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository repository;
    private final AuthorService authorService;
    private final CategoriesService categoriesService;
    private final UserService userService;
    private final ModelMapper mapper;

    public BookServiceImpl(BookRepository repository, AuthorService authorService, CategoriesService categoriesService, UserService userService, ModelMapper mapper) {
        this.repository = repository;
        this.authorService = authorService;
        this.categoriesService = categoriesService;
        this.userService = userService;
        this.mapper = mapper;
    }


    @Transactional
    @Override
    public BookResDto save(BookReqDto bookDto) {

        BookDAO bookDAO = new BookDAO();

        if(!authorService.existsAuthor(bookDto.getAuthorName())){
            Author newAuthor = new Author();
            newAuthor.setAuthorName(bookDto .getAuthorName());
            bookDAO.setAuthor(newAuthor);
        }else {
            bookDAO.setAuthor(authorService.getAuthorByName(bookDto.getAuthorName()));
        }

        if(!categoriesService.existCategory(bookDto.getCategoryName())){
            throw buildException(BookServiceException.Exception.WRONG_CATEGORY);
        }

        UsersDAO usersDAO = userService.findById(bookDto.getUserId());
        bookDAO.setUsers(usersDAO);

        bookDAO.setBookName(bookDto.getBookName());
        bookDAO.setPrice(bookDto.getPrice());
        bookDAO.setQuantity(bookDto.getQuantity());
        bookDAO.setCategory(categoriesService.getCategoryByName(bookDto.getCategoryName()));
        bookDAO.setCreatedAt(new Date());
        bookDAO.setCreatedBy(usersDAO.getUsername());

        return mapper.map(repository.save(bookDAO),BookResDto.class);
    }

    @Override
    public BookResDto update(BookUpdDto bookUpdDto) {

        if(!repository.existsById(bookUpdDto.getId())) {
            throw buildException(BookServiceException.Exception.BOOK_NOT_FOUND);
        }

        BookDAO book = repository.findByBookNameAndUsers_Id(bookUpdDto.getBookName(),
                bookUpdDto.getUserId()).orElseThrow(() ->
                buildException(BookServiceException.Exception.BOOK_NOT_FOUND));

        UsersDAO usersDAO = userService.findById(bookUpdDto.getUserId());

        book.setUsers(usersDAO);
        book.setBookName(bookUpdDto.getBookName());
        book.setQuantity(bookUpdDto.getQuantity());
        book.setPrice(bookUpdDto.getPrice());
        book.setDescription(book.getDescription());
        book.setUpdatedAt(new Date());
        book.setUpdatedBy(usersDAO.getUsername());

        return mapper.map(repository.save(book),BookResDto.class);

    }

    @Override
    public BookResDto getBookById(long id) {
        if(!repository.existsById(id)){
            throw  buildException(BookServiceException.Exception.BOOK_NOT_FOUND);
        }
        return mapper.map(repository.getById(id),BookResDto.class);
    }

    @Override
    public List<BookResDto> getAllBookByUserId(long userId) {
        return repository.findAllByUsers_Id(userId).stream()
                .map(book -> mapper.map(book,BookResDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public boolean deleteById(long id) {
        if(!repository.existsById(id)){
            throw buildException(BookServiceException.Exception.BOOK_NOT_FOUND);
        }
        repository.deleteById(id);
        return true;
    }

    @Override
    public boolean deleteByName(String name) {
        return true;
    }

    private BookSellerException buildException(BookServiceException.Exception exception) {
        return new BookServiceException(exception.getMessage(), exception.getHttpStatus());
    }

}
