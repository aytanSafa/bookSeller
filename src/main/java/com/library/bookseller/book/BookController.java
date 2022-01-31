package com.library.bookseller.book;


import com.library.bookseller.book.request.BookReqDto;
import com.library.bookseller.book.request.BookUpdDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/book")
public class BookController {

    private final BookService service;

    @Autowired
    public BookController(BookService service) {
        this.service = service;
    }

    @PostMapping(value = "/addbook")
    @PreAuthorize("hasRole('SELLER')")
    public ResponseEntity<?> add(@RequestBody BookReqDto request){
       return ResponseEntity.ok(service.save(request));
    }

    @PutMapping(value = "/updateBook")
    @PreAuthorize("hasRole('SELLER')")
    public ResponseEntity<?> update(@RequestBody BookUpdDto upReq){
        return ResponseEntity.ok(service.update(upReq));
    }

    @GetMapping(value = "/getAllBooksByUserId")
    @PreAuthorize("hasRole('SELLER')")
    public ResponseEntity<?> getAllByUserId(@RequestParam(name = "userId") long userId){
       return ResponseEntity.ok(service.getAllBookByUserId(userId));
    }
}
