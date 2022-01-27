package com.library.bookseller.book;

import com.library.bookseller.book.request.BookReqDto;
import com.library.bookseller.book.request.BookResDto;
import com.library.bookseller.book.request.BookUpdDto;
import com.library.bookseller.service.Services;

public interface BookService extends Services {
    BookResDto save (BookReqDto bookDto, String userName);
    BookResDto update (BookUpdDto bookUpdDto,String userName);
    BookResDto getBookById(long id);
}
