package com.library.bookseller.author;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/author")
public class AuthorController {

    private final AuthorService service;
    private final ModelMapper mapper;

    @Autowired
    public AuthorController(AuthorService service, ModelMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping(value = "/getAuthorName/{name}")
    public ResponseEntity<?> getAuthor(@PathVariable(value = "name") String name) {
        return ResponseEntity.ok(service.getAuthor(name));

    }

    @GetMapping(value = "/getAuthorId/{id}")
    public ResponseEntity<?> getAuthor(@PathVariable(value = "id") long id){
        return ResponseEntity.ok(service.getAuthor(id));
    }

    @PostMapping(value = "/saveAuthor")
    public ResponseEntity<?> saveAuthor(
            @RequestBody AuthorDto author){
        return ResponseEntity.ok(service.save(mapper.map(author,Author.class)));
    }

    @DeleteMapping(value = "/deleteAuthor/{authorName}")
    public ResponseEntity<?> deleteAuthor(@PathVariable String authorName){
        return ResponseEntity.ok(service.delete(authorName));
    }




}
