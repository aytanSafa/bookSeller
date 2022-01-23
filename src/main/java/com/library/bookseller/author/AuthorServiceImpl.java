package com.library.bookseller.author;

import com.library.bookseller.model.Models;
import com.library.bookseller.model.ResponseType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService{

    private final AuthorRepository repository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository repository) {
        this.repository = repository;
    }

    @Override
    public Author getAuthor(String name) {
        return repository.findByAuthorName(name);
    }

    @Override
    public Author getAuthor(long id) {
        return repository.getById(id);
    }

    @Override
    public ResponseType save(Models<?> request) {
       Author a = (Author) request.getObj();
       Author a1 = repository.save(a);
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

}
