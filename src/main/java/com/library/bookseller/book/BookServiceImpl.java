package com.library.bookseller.book;

import com.library.bookseller.author.Author;
import com.library.bookseller.author.AuthorService;
import com.library.bookseller.book.request.BookSaveRequest;
import com.library.bookseller.categories.Categories;
import com.library.bookseller.categories.CategoriesService;
import org.springframework.stereotype.Service;

import java.awt.print.Book;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository repository;
    private final AuthorService authorService;
    private final CategoriesService categoriesService;

    public BookServiceImpl(BookRepository repository, AuthorService authorService, CategoriesService categoriesService) {
        this.repository = repository;
        this.authorService = authorService;
        this.categoriesService = categoriesService;
    }


    @Override
    public BookDAO save(BookSaveRequest bookDto) {
        BookDAO bookDAO = new BookDAO();
        Author oldAuthor = authorService.getAuthor(bookDto.getAuthorName());
        Categories categories = categoriesService.getCategory(bookDto.getCategoryName());
        bookDAO.setBookName(bookDto.getBookName());
        //----------------------------------------------------------//
        if(oldAuthor != null){
            bookDAO.setAuthor(oldAuthor);
        }else {
            Author newAuthor = new Author();
            newAuthor.setAuthorName(bookDto.getAuthorName());
            bookDAO.setAuthor(newAuthor);
        }
        //---------------------------------------------------------//
        if(categories == null){
            throw new RuntimeException("Invalid Category");
        }else{
            bookDAO.setCategory(categories);
        }
        return repository.save(bookDAO);
    }
}
