package com.library.bookseller.users;

import com.library.bookseller.users.dto.UserUpdateReqDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }


    @PutMapping(value = "/update")
    public ResponseEntity<?> updateUser(@RequestBody UserUpdateReqDto updateReqDto){
       return ResponseEntity.ok(service.updateUser(updateReqDto));
    }

    @DeleteMapping(value = "/deleteUser")
    public ResponseEntity<?> deleteUser(@RequestParam(name = "id") long id){
       return ResponseEntity.ok(service.deleteById(id));

    }

    @GetMapping(value = "/getById")
    public ResponseEntity<?> getById(@RequestParam(name = "id") long id){
        return ResponseEntity.ok(service.getById(id));
    }
}
