package com.library.bookseller.exceptions.generic;

import org.springframework.http.HttpStatus;

public abstract class BookSellerException extends RuntimeException{

    private final HttpStatus httpStatus;

    public BookSellerException(String message,HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus(){
        return this.httpStatus;
    }

}
