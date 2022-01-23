package com.library.bookseller.service;

import com.library.bookseller.model.Models;
import com.library.bookseller.model.ResponseType;

public interface Services {

    ResponseType save(Models<?> request);

    ResponseType update(Models<?> request);

    ResponseType delete(long id);


}