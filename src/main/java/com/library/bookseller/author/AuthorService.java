package com.library.bookseller.author;

import com.library.bookseller.model.ResponseType;
import com.library.bookseller.service.Services;


public interface AuthorService extends Services {

    ResponseType save(Author author);
    ResponseType update(Author author);
    AuthorDto getAuthor (String name);
    AuthorDto getAuthor(long id);

}
