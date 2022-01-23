package com.library.bookseller.author;

import com.library.bookseller.model.Models;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/author")
public class AuthorController {

    private final AuthorService service;


    @Autowired
    public AuthorController(AuthorService service) {
        this.service = service;
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
    public ResponseEntity<?> saveAuthor(@RequestBody Author author){
        Models<Author> authorModels = new Models<>(author);
        return ResponseEntity.ok(service.save(authorModels));
    }

    @DeleteMapping(value = "/deleteAuthor/{authorName}")
    public ResponseEntity<?> deleteAuthor(@PathVariable String authorName){
        return ResponseEntity.ok(service.delete(authorName));
    }




}
