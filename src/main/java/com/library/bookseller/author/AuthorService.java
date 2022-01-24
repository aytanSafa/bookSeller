package com.library.bookseller.author;

import com.library.bookseller.model.ResponseType;
import com.library.bookseller.service.Services;


public interface AuthorService extends Services {

    ResponseType save(Author author);
    ResponseType update(Author author);
    AuthorDto getAuthorDto (String name);
    Author getAuthor(String name);
    AuthorDto getAuthorDto(long id);
    Author getAuthor(long id);

}
