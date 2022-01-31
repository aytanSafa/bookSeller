package com.library.bookseller.author;

import com.library.bookseller.author.dto.AuthorSaveReqDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize(value = "hasRole('ADMIN')")
    public ResponseEntity<?> getAuthor(@PathVariable(value = "name") String name) {
        return ResponseEntity.ok(service.getAuthorByName(name));

    }

    @GetMapping(value = "/getAuthorId/{id}")
    @PreAuthorize(value = "hasRole('ADMIN')")
    public ResponseEntity<?> getAuthor(@PathVariable(value = "id") long id){
        return ResponseEntity.ok(service.getAuthorDtoById(id));
    }

    @PostMapping(value = "/saveAuthor")
    @PreAuthorize(value = "hasRole('ADMIN')")
    public ResponseEntity<?> saveAuthor(
            @RequestBody AuthorSaveReqDto author){
        return ResponseEntity.ok(service.save(author));
    }

    @DeleteMapping(value = "/deleteAuthor/{authorName}")
    @PreAuthorize(value = "hasRole('ADMIN')")
    public ResponseEntity<?> deleteAuthor(@PathVariable String authorName){
        return ResponseEntity.ok(service.getAuthorDtoByName(authorName));
    }

}
