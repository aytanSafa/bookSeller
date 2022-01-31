package com.library.bookseller.exceptions.generic;

import com.library.bookseller.exceptions.*;
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

    @ExceptionHandler(value = UserServiceException.class)
    public ResponseEntity<ErrorResponseModel> genericUsersServiceException(UserServiceException userServiceException){
        return new ResponseEntity<>(toExceptionModel(userServiceException),userServiceException.getHttpStatus());
    }

    @ExceptionHandler(value = AccountServiceException.class)
    public ResponseEntity<ErrorResponseModel> genericAccountServiceException(AccountServiceException accountServiceException){
        return new ResponseEntity<>(toExceptionModel(accountServiceException),accountServiceException.getHttpStatus());
    }

    @ExceptionHandler(value = CategoriesServiceException.class)
    public ResponseEntity<ErrorResponseModel> genericCategoriesServiceException(CategoriesServiceException categoriesServiceException){
        return new ResponseEntity<>(toExceptionModel(categoriesServiceException),categoriesServiceException.getHttpStatus());
    }
    @ExceptionHandler(value = BookServiceException.class)
    public ResponseEntity<ErrorResponseModel> genericBookServiceException(BookServiceException bookServiceException){
        return new ResponseEntity<>(toExceptionModel(bookServiceException),bookServiceException.getHttpStatus());
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
