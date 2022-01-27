package com.library.bookseller.book;


import com.library.bookseller.book.request.BookSaveRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "book")
public class BookController {

    private final BookService service;

    @Autowired
    public BookController(BookService service) {
        this.service = service;
    }

    @PostMapping(value = "/addbook")
    public ResponseEntity<?> add(@RequestBody BookSaveRequest request){
       return ResponseEntity.ok(service.save(request,"Safa"));
    }

}
