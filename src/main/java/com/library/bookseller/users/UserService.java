package com.library.bookseller.users;

import com.library.bookseller.service.Services;
import com.library.bookseller.users.dto.UserRegisterReqDto;
import com.library.bookseller.users.dto.UserRegisterResDto;
import com.library.bookseller.users.dto.UserUpdateReqDto;
import com.library.bookseller.users.dto.UserUpdateResDto;
import org.springframework.stereotype.Service;

import java.util.Optional;


public interface UserService {

    UserRegisterResDto saveUser (UserRegisterReqDto userRegisterReqDto);
    UsersDAO findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
    UserUpdateResDto updateUser(UserUpdateReqDto updateReqDto);
    boolean deleteById(long id);
    UserUpdateResDto getById(long id);


}
