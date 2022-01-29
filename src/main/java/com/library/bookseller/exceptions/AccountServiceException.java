
package com.library.bookseller.exceptions;

import com.library.bookseller.exceptions.generic.BookSellerException;
import org.springframework.http.HttpStatus;

public class AccountServiceException extends BookSellerException {


    public enum Exception{

        USER_NOT_FOUND(  "User Not Found", HttpStatus.NOT_FOUND),
        USER_ALREADY_EXIST("Username is already taken", HttpStatus.CONFLICT),
        EMAIL__ALREADY_EXIST("Email is already taken",HttpStatus.CONFLICT);

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

    public AccountServiceException(String message, HttpStatus httpStatus) {
        super(message,httpStatus);
    }
}
