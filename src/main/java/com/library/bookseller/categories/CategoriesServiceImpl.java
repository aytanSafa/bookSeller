package com.library.bookseller.categories;

import com.library.bookseller.categories.dto.CategoriesSaveReqDto;
import com.library.bookseller.categories.dto.CategoriesResDto;
import com.library.bookseller.categories.dto.CategoriesUpdReqDto;
import com.library.bookseller.exceptions.CategoriesServiceException;
import com.library.bookseller.exceptions.generic.BookSellerException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoriesServiceImpl implements CategoriesService{

    private final CategoriesRepository repository;
    private final ModelMapper mapper;

    @Autowired
    public CategoriesServiceImpl(CategoriesRepository repository, ModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    @Override
    public CategoriesResDto save(CategoriesSaveReqDto category) {

        if(repository.findCategoriesByCategoryName(category.getCategoryName()) != null){
           throw buildException(CategoriesServiceException.Exception.CATEGORY_ALREADY_EXIST);
        }
        return mapper.map(repository.save(mapper.map(category,Categories.class)),CategoriesResDto.class);
    }

    @Override
    public CategoriesResDto update(CategoriesUpdReqDto category) {

        if(!repository.existsById(category.getId())){
            throw buildException(CategoriesServiceException.Exception.CATEGORY_NOT_FOUND);
        }
         Categories oldCategories  =repository.getById(category.getId());
         oldCategories.setCategoryName(category.getCategoryName());
        return mapper.map(oldCategories,CategoriesResDto.class);
    }


    @Override
    public CategoriesResDto getCategoryDtoByName(String name) {
        Categories categories = repository.findCategoriesByCategoryName(name);

        if(categories == null){
            throw buildException(CategoriesServiceException.Exception.CATEGORY_NOT_FOUND);
        }
        return mapper.map(categories, CategoriesResDto.class);
    }

    @Override
    public CategoriesResDto getCategoryDtoById(long id) {
        Categories categories = repository.findById(id).orElseThrow(
                () -> buildException(CategoriesServiceException.Exception.CATEGORY_NOT_FOUND)
        );

        return mapper.map(categories, CategoriesResDto.class);

    }

    @Override
    public Categories getCategoryByName(String name) {
        Categories categories = repository.findCategoriesByCategoryName(name);
        if(categories == null){
            throw buildException(CategoriesServiceException.Exception.CATEGORY_NOT_FOUND);
        }
        return categories;
    }

    @Override
    public Categories getCategoryById(long id) {
        return  repository.findById(id).orElseThrow(
                () -> buildException(CategoriesServiceException.Exception.CATEGORY_NOT_FOUND)
        );
    }

    @Override
    public List<Categories> findBooksByCategories(String name) {
        return repository.findAllByCategoryName(name);
    }

    @Override
    public boolean existCategory(String name) {
        return repository.existsCategoriesByCategoryName(name);
    }

    @Override
    public boolean deleteById(long id) {
        if(!repository.existsById(id)){
            throw buildException(CategoriesServiceException.Exception.CATEGORY_NOT_FOUND);
        }
        repository.deleteById(id);
        return true;
    }

    @Override
    public boolean deleteByName(String name) {
        if(repository.findCategoriesByCategoryName(name) == null){
            throw buildException(CategoriesServiceException.Exception.CATEGORY_NOT_FOUND);
        }
        repository.deleteCategoriesByCategoryName(name);
        return true;
    }

    private BookSellerException buildException(CategoriesServiceException.Exception exception) {
        return new CategoriesServiceException(exception.getMessage(), exception.getHttpStatus());
    }
}
