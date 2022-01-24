package com.library.bookseller.exceptions.generic;

import org.springframework.http.HttpStatus;

public class BalanceServiceException  extends BookSellerException{

    public enum Exception{

        BALANCE_NOT_FOUND(  "Category Not Found", HttpStatus.NOT_FOUND),
        BALANCE_INSUFFICIENT("Balance is Insufficient", HttpStatus.CONFLICT);

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
    public BalanceServiceException(String message, HttpStatus httpStatus) {
        super(message,httpStatus);
    }
}
