package com.library.bookseller.categories;

import com.library.bookseller.exceptions.AuthorServiceException;
import com.library.bookseller.exceptions.CategoriesServiceException;
import com.library.bookseller.exceptions.generic.BookSellerException;
import com.library.bookseller.model.ResponseType;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class CategoriesServiceImpl implements CategoriesService{

    private final CategoriesRepository repository;
    private final ModelMapper mapper;

    public CategoriesServiceImpl(CategoriesRepository repository, ModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    @Override
    public ResponseType save(Categories category) {
        if(repository.findCategoriesByCategoryName(category.getCategoryName()) == null){
            repository.save(category);
        }
        return new ResponseType("Saved");
    }

    @Override
    public ResponseType update(Categories category) {
        return null;
    }

    @Override
    public CategoriesDto getCategory(String name) {
        Categories categories = repository.findCategoriesByCategoryName(name);
        if(categories == null){
            throw buildException(CategoriesServiceException.Exception.CATEGORY_NOT_FOUND);
        }
        return mapper.map(categories,CategoriesDto.class);
    }

    @Override
    public CategoriesDto getCategory(long id) {
        Categories categories = repository.findById(id).orElseThrow(
                () -> buildException(CategoriesServiceException.Exception.CATEGORY_NOT_FOUND)
        );
        return mapper.map(categories,CategoriesDto.class);
    }

    @Override
    public ResponseType delete(long id) {
        return null;
    }

    @Override
    public ResponseType delete(String name) {
        if(repository.findCategoriesByCategoryName(name) == null){
            buildException(CategoriesServiceException.Exception.CATEGORY_NOT_FOUND);
        }
        repository.deleteCategoriesByCategoryName(name);
        return new ResponseType("deleted");
    }

    private BookSellerException buildException(CategoriesServiceException.Exception exception) {
        return new CategoriesServiceException(exception.getMessage(), exception.getHttpStatus());
    }
}
