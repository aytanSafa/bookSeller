package com.library.bookseller.exceptions;

import com.library.bookseller.exceptions.generic.BookSellerException;
import org.springframework.http.HttpStatus;

public class AuthorServiceException extends BookSellerException {


    public enum Exception{

        AUTHOR_NOT_FOUND(  "Author Not Found", HttpStatus.NOT_FOUND),
        AUTHOR_ALREADY_EXIST("Author aldready exist", HttpStatus.CONFLICT);

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

    public AuthorServiceException(String message,HttpStatus httpStatus) {
        super(message,httpStatus);
    }
}
