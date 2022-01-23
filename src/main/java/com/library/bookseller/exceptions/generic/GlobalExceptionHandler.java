package com.library.bookseller.exceptions.generic;

import com.library.bookseller.exceptions.AuthorServiceException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {



    @ExceptionHandler(value = AuthorServiceException.class)
    public ResponseEntity<ErrorResponseModel> genericAuthorServiceException(AuthorServiceException authorServiceException){
        return new ResponseEntity<>(toExceptionModel(authorServiceException),authorServiceException.getHttpStatus());
    }



    private ErrorResponseModel toExceptionModel(BookSellerException exception) {
        ErrorResponseModel.ErrorResponseModelBuilder builder = ErrorResponseModel.builder()
                .error(exception.getHttpStatus().name())
                .message(exception.getMessage())
                .status(exception.getHttpStatus().toString())
                .timestamp(LocalDateTime.now().toString());

        return builder.build();

    }
}
