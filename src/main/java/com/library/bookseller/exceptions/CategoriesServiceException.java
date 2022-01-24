package com.library.bookseller.exceptions;

import com.library.bookseller.exceptions.generic.BookSellerException;
import org.springframework.http.HttpStatus;

public class CategoriesServiceException extends BookSellerException {


    public enum Exception{

        CATEGORY_NOT_FOUND(  "Category Not Found", HttpStatus.NOT_FOUND),
        CATEGORY_ALREADY_EXIST("Category already exist", HttpStatus.CONFLICT);

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
    public CategoriesServiceException(String message, HttpStatus httpStatus) {
        super(message,httpStatus);
    }
}
