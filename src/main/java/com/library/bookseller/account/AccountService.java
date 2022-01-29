package com.library.bookseller.account;


import com.library.bookseller.account.dto.AccountLoginDto;
import com.library.bookseller.account.dto.JwtResponse;
import com.library.bookseller.users.dto.UserRegisterReqDto;
import com.library.bookseller.users.dto.UserRegisterResDto;
import org.springframework.stereotype.Service;

@Service
public interface AccountService {

    UserRegisterResDto registerUser(UserRegisterReqDto userRegisterReqDto);
    JwtResponse login(AccountLoginDto accountDto);
}
