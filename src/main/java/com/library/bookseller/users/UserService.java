package com.library.bookseller.users;

import com.library.bookseller.service.Services;
import com.library.bookseller.users.dto.UserRegisterReqDto;
import com.library.bookseller.users.dto.UserRegisterResDto;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    UserRegisterResDto saveUser (UserRegisterReqDto userRegisterReqDto);

}
