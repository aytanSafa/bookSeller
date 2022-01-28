package com.library.bookseller.account;

import com.library.bookseller.account.dto.AccountDto;
import com.library.bookseller.account.dto.AccountRegisterDto;
import com.library.bookseller.security.jwt.JwtUtils;
import com.library.bookseller.security.role.RoleRepository;
import com.library.bookseller.users.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;


    @PostMapping(value = "/login")
    public ResponseEntity<?> login(AccountDto accountDto){


        return null;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody AccountRegisterDto accountRegisterDto){

    }

}
