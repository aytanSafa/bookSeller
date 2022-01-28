package com.library.bookseller.categories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/category")
public class CategoriesController {


    private final CategoriesService service;

    @Autowired
    public CategoriesController(CategoriesService service) {
        this.service = service;
    }

    @GetMapping(value = "/getByName/{name}")
    public ResponseEntity<?> getCategoryByName (@PathVariable(value = "name") String name){
        return ResponseEntity.ok(service.getCategoryDtoByName(name));
    }
    @GetMapping(value = "/findAll/{name}")
    public ResponseEntity<?> findAllByCategoryName(@PathVariable(value = "name")String name){
        return ResponseEntity.ok(service.findBooksByCategories(name));
    }
}
