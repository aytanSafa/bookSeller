package com.library.bookseller.book;

import com.library.bookseller.book.request.BookSaveRequest;

public interface BookService {
    BookDAO save (BookSaveRequest bookDto);
}
