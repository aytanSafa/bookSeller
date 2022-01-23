package com.library.bookseller.author;

import com.library.bookseller.service.Services;

public interface AuthorService extends Services {

    Author getAuthor (String name);
    Author getAuthor(long id);

}
