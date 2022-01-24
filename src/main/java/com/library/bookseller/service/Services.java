package com.library.bookseller.service;

import com.library.bookseller.model.ResponseType;

public interface Services {

    ResponseType delete(long id);

    ResponseType delete(String name);


}