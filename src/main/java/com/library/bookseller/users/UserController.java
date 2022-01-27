package com.library.bookseller.users;

import com.library.bookseller.users.dto.UserRegisterReqDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }


    @PostMapping(value = "/register")
    public ResponseEntity<?> saveNewUser(@RequestBody UserRegisterReqDto registerReqDto){
        return ResponseEntity.ok(service.saveUser(registerReqDto));
    }


}
