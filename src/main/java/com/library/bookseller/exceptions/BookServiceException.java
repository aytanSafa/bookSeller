package com.library.bookseller.exceptions;


import com.library.bookseller.exceptions.generic.BookSellerException;
import org.springframework.http.HttpStatus;

public class BookServiceException extends BookSellerException {

    public BookServiceException(String message, HttpStatus httpStatus) {
        super(message, httpStatus);
    }

    public enum Exception{

        BOOK_NOT_FOUND(  "Book Not Found", HttpStatus.NOT_FOUND),
        BOOK_ALREADY_EXIST("Book already exist", HttpStatus.CONFLICT),
        WRONG_CATEGORY("Wrong category chosen",HttpStatus.NOT_FOUND);

        private final String message;
        private final HttpStatus httpStatus;

        Exception(String message, HttpStatus httpStatus) {
            this.message = message;
            this.httpStatus = httpStatus;
        }

        public String getMessage() {
            return message;
        }

        public HttpStatus getHttpStatus() {
            return httpStatus;
        }
    }


}
