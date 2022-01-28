package com.library.bookseller.author;

import com.library.bookseller.author.dto.AuthorSaveReqDto;
import com.library.bookseller.author.dto.AuthorResDto;
import com.library.bookseller.author.dto.AuthorUpdReqDto;
import com.library.bookseller.exceptions.AuthorServiceException;
import com.library.bookseller.exceptions.generic.BookSellerException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public AuthorResDto getAuthorDtoByName(String name) {
        Author author = repository.findAuthorByAuthorName(name);
        if(author == null){
            throw buildException(AuthorServiceException.Exception.AUTHOR_NOT_FOUND);
        }
        return mapper.map(author, AuthorResDto.class);
    }


    @Override
    public AuthorResDto getAuthorDtoById(long id) {
        Author author = repository.findById(id).orElseThrow(
                () -> buildException(AuthorServiceException.Exception.AUTHOR_NOT_FOUND)
        );
        return mapper.map(author, AuthorResDto.class);
    }

    @Override
    public Author getAuthorByName(String name) {
        Author author = repository.findAuthorByAuthorName(name);
        if(author == null){
            throw buildException(AuthorServiceException.Exception.AUTHOR_NOT_FOUND);
        }
        return author;
    }

    @Override
    public Author getAuthorById(long id) {
        return repository.findById(id).orElseThrow(
                () -> buildException(AuthorServiceException.Exception.AUTHOR_NOT_FOUND));
    }

    @Override
    public boolean existsAuthor(String name) {
        return repository.existsAuthorByAuthorName(name);
    }

    @Override
    public AuthorResDto save(AuthorSaveReqDto author) {
       if(repository.findAuthorByAuthorName(author.getAuthorName()) != null) {
           throw buildException(AuthorServiceException.Exception.AUTHOR_ALREADY_EXIST);
       }
       return mapper.map(mapper.map(author,Author.class),AuthorResDto.class);
    }

    @Override
    public AuthorResDto update(AuthorUpdReqDto author) {
        if(!repository.existsById(author.getId())){
           throw  buildException(AuthorServiceException.Exception.AUTHOR_NOT_FOUND);
        }
        Author oldAuthor = repository.getById(author.getId());
        oldAuthor.setAuthorName(author.getAuthorName());
        Author newAuthor =repository.save(oldAuthor);
        return mapper.map(newAuthor,AuthorResDto.class);
    }

    @Override
    public boolean deleteById(long id) {
        if(!repository.existsById(id)){
            throw buildException(AuthorServiceException.Exception.AUTHOR_NOT_FOUND);
        }
        repository.deleteById(id);
        return true ;
    }

    @Override
    public boolean deleteByName(String name) {
       if(repository.findAuthorByAuthorName(name) == null) {
          throw  buildException(AuthorServiceException.Exception.AUTHOR_NOT_FOUND);
       }
        repository.deleteAuthorByAuthorName(name);
        return true;
    }
    private BookSellerException buildException(AuthorServiceException.Exception exception) {
        return new AuthorServiceException(exception.getMessage(), exception.getHttpStatus());
    }
}
