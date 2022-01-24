package com.library.bookseller.categories;

import com.library.bookseller.model.ResponseType;
import com.library.bookseller.service.Services;
import org.springframework.stereotype.Service;


public interface CategoriesService extends Services {

    ResponseType save(Categories category);
    ResponseType update(Categories category);
    CategoriesDto getCategory(String name);
    CategoriesDto getCategory(long id);



}
