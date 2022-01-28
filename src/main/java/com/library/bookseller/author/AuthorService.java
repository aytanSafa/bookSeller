package com.library.bookseller.author;

import com.library.bookseller.author.dto.AuthorSaveReqDto;
import com.library.bookseller.author.dto.AuthorResDto;
import com.library.bookseller.author.dto.AuthorUpdReqDto;
import com.library.bookseller.service.Services;


public interface AuthorService extends Services {

    AuthorResDto save(AuthorSaveReqDto author);
    AuthorResDto update(AuthorUpdReqDto author);
    AuthorResDto getAuthorDtoByName(String name);
    AuthorResDto getAuthorDtoById(long id);
    Author getAuthorByName(String name);
    Author getAuthorById(long id);
    boolean existsAuthor(String name);
}
