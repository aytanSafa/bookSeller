package com.library.bookseller.book;


import com.library.bookseller.book.request.BookReqDto;
import com.library.bookseller.book.request.BookUpdDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "book")
public class BookController {

    private final BookService service;

    @Autowired
    public BookController(BookService service) {
        this.service = service;
    }

    @PostMapping(value = "/addbook")
    public ResponseEntity<?> add(@RequestBody BookReqDto request){
       return ResponseEntity.ok(service.save(request,"Safa"));
    }

    @PutMapping(value = "/updateBook")
    public ResponseEntity<?> update(@RequestBody BookUpdDto upReq){
        return ResponseEntity.ok(service.update(upReq,"safa"));
    }

}
