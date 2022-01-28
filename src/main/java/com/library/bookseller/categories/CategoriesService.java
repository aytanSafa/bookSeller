package com.library.bookseller.categories;

import com.library.bookseller.categories.dto.CategoriesSaveReqDto;
import com.library.bookseller.categories.dto.CategoriesResDto;
import com.library.bookseller.categories.dto.CategoriesUpdReqDto;
import com.library.bookseller.service.Services;

import java.util.List;


public interface CategoriesService extends Services {

    CategoriesResDto save(CategoriesSaveReqDto category);
    CategoriesResDto update(CategoriesUpdReqDto category);
    CategoriesResDto getCategoryDtoByName(String name);
    CategoriesResDto getCategoryDtoById(long id);
    Categories getCategoryByName(String name);
    Categories getCategoryById(long id);
    List<Categories> findBooksByCategories(String name);
    boolean existCategory(String name);


}
