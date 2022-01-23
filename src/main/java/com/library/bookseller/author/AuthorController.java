package com.library.bookseller.author;

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
}
