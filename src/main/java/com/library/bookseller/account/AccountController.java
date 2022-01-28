package com.library.bookseller.account;

import com.library.bookseller.account.dto.AccountDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {

    @PostMapping(value = "/login")
    public ResponseEntity<?> login(AccountDto accountDto){
        return null;
    }

}
