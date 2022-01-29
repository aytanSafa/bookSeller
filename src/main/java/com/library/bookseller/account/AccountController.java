package com.library.bookseller.account;

import com.library.bookseller.account.dto.AccountLoginDto;
import com.library.bookseller.users.dto.UserRegisterReqDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/account")
public class AccountController {


    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }


    @PostMapping(value = "/login")
    public ResponseEntity<?> login(@RequestBody AccountLoginDto accountDto){
        return ResponseEntity.ok(accountService.login(accountDto));
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserRegisterReqDto userRegisterReqDto){
        return  ResponseEntity.ok(accountService.registerUser(userRegisterReqDto));
    }

}
