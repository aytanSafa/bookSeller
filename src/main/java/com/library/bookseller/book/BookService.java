package com.library.bookseller.book;

import com.library.bookseller.book.request.BookReqDto;
import com.library.bookseller.book.request.BookResDto;
import com.library.bookseller.book.request.BookUpdDto;
import com.library.bookseller.service.Services;

import java.util.List;

public interface BookService extends Services {
    BookResDto save (BookReqDto bookDto);
    BookResDto update (BookUpdDto bookUpdDto);
    BookResDto getBookById(long id);
    List<BookResDto> getAllBookByUserId(long userId);
}
