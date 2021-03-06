package com.library.bookseller.exceptions;

import com.library.bookseller.exceptions.generic.BookSellerException;
import org.springframework.http.HttpStatus;

public class UserServiceException extends BookSellerException {


    public enum Exception{

        USER_NOT_FOUND(  "User Not Found", HttpStatus.NOT_FOUND),
        USER_ALREADY_EXIST("Username already exist", HttpStatus.CONFLICT),
        EMAIL_ALREADY_EXIST("Email is already taken",HttpStatus.CONFLICT),
        ROLE_NOT_FOUND("Role is not found",HttpStatus.NOT_FOUND);

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

    public UserServiceException(String message, HttpStatus httpStatus) {
        super(message,httpStatus);
    }
}
