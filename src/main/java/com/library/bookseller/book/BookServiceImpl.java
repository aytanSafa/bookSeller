package com.library.bookseller.book;

import com.library.bookseller.author.Author;
import com.library.bookseller.author.AuthorService;
import com.library.bookseller.book.request.BookSaveRequest;
import com.library.bookseller.categories.CategoriesService;
import com.library.bookseller.exceptions.BookServiceException;
import com.library.bookseller.exceptions.generic.BookSellerException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository repository;
    private final AuthorService authorService;
    private final CategoriesService categoriesService;
    private final ModelMapper mapper;

    public BookServiceImpl(BookRepository repository, AuthorService authorService, CategoriesService categoriesService, ModelMapper mapper) {
        this.repository = repository;
        this.authorService = authorService;
        this.categoriesService = categoriesService;
        this.mapper = mapper;
    }


    @Override
    public BookDAO save(BookSaveRequest bookDto,String userName) {

        BookDAO bookDAO = new BookDAO();

        if(!authorService.existsAuthor(bookDto.getAuthorName())){
            Author newAuthor = new Author();
            newAuthor.setAuthorName(bookDto .getAuthorName());
            bookDAO.setAuthor(newAuthor);
        }else {
            bookDAO.setAuthor(authorService.getAuthorByName(bookDto.getAuthorName()));
        }
        //----------------------------------------------------------//

        if(!categoriesService.existCategory(bookDto.getCategoryName())){
            throw buildException(BookServiceException.Exception.WRONG_CATEGORY);
        }

        bookDAO.setBookName(bookDto.getBookName());
        bookDAO.setPrice(bookDto.getPrice());
        bookDAO.setQuantity(bookDto.getQuantity());
        bookDAO.setCategory(categoriesService.getCategoryByName(bookDto.getCategoryName()));
        bookDAO.setCreatedAt(new Date());
        bookDAO.setCreatedBy(userName);


        return repository.save(bookDAO);
    }


    private BookSellerException buildException(BookServiceException.Exception exception) {
        return new BookServiceException(exception.getMessage(), exception.getHttpStatus());
    }
}
