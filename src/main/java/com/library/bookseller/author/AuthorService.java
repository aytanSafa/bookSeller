package com.library.bookseller.author;

import com.library.bookseller.service.Services;

public interface AuthorService extends Services {

    AuthorDto getAuthor (String name);
    AuthorDto getAuthor(long id);

}
