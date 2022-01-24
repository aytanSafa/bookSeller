package com.library.bookseller.categories;

import com.library.bookseller.model.ResponseType;
import com.library.bookseller.service.Services;
import org.springframework.stereotype.Service;


public interface CategoriesService extends Services {

    ResponseType save(Categories category);
    ResponseType update(Categories category);
    CategoriesDto getCategoryDto(String name);
    CategoriesDto getCategoryDto(long id);
    Categories getCategory(String name);
    Categories getCategory(long id);



}
