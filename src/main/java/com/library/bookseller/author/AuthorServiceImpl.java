package com.library.bookseller.author;

import com.library.bookseller.exceptions.AuthorServiceException;
import com.library.bookseller.exceptions.generic.BookSellerException;
import com.library.bookseller.model.Models;
import com.library.bookseller.model.ResponseType;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService{

    private final AuthorRepository repository;
    private final ModelMapper mapper;

    @Autowired
    public AuthorServiceImpl(AuthorRepository repository, ModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public AuthorDto getAuthor(String name) {
        Author author = repository.findAuthorByAuthorName(name);
        if(author == null){
            throw buildException(AuthorServiceException.Exception.AUTHOR_NOT_FOUND);
        }
        return mapper.map(author,AuthorDto.class);
    }

    @Override
    public AuthorDto getAuthor(long id) {
        Author author = repository.findById(id).orElseThrow(
                () -> buildException(AuthorServiceException.Exception.AUTHOR_NOT_FOUND)
        );
        return mapper.map(author,AuthorDto.class);
    }

    @Override
    public ResponseType save(Models<?> request) {
       Author author = (Author) request.getObj();

       if(repository.findAuthorByAuthorName(author.getAuthorName()) == null){
           repository.save(author);
       }
       return new ResponseType("Saved");
    }

    @Override
    public ResponseType update(Models<?> request) {
        return null;
    }

    @Override
    public ResponseType delete(long id) {
        return null;
    }

    @Override
    public ResponseType delete(String name) {

       if(repository.findAuthorByAuthorName(name) == null) {
           buildException(AuthorServiceException.Exception.AUTHOR_NOT_FOUND);
       }
        repository.deleteAuthorByAuthorName(name);
        return new ResponseType("deleted") ;
    }

    private BookSellerException buildException(AuthorServiceException.Exception exception, Object... params) {
        return new AuthorServiceException(exception.getMessage(), exception.getHttpStatus());
    }

}
