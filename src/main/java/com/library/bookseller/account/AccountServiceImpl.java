package com.library.bookseller.account;

import com.library.bookseller.account.dto.AccountLoginDto;
import com.library.bookseller.account.dto.JwtResponse;
import com.library.bookseller.security.jwt.JwtUtils;
import com.library.bookseller.security.role.RoleRepository;
import com.library.bookseller.users.UserService;
import com.library.bookseller.users.dto.UserRegisterReqDto;
import com.library.bookseller.users.dto.UserRegisterResDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;

public class AccountServiceImpl implements AccountService {

    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final PasswordEncoder encoder;
    private final JwtUtils jwtUtils;
    private final ModelMapper mapper;

    @Autowired
    public AccountServiceImpl(AuthenticationManager authenticationManager, UserService userService, PasswordEncoder encoder, JwtUtils jwtUtils, ModelMapper mapper) {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
        this.encoder = encoder;
        this.jwtUtils = jwtUtils;
        this.mapper = mapper;
    }

    @Override
    public UserRegisterResDto registerUser(UserRegisterReqDto userRegisterReqDto) {
        return userService.saveUser(userRegisterReqDto);
    }


    @Override
    public JwtResponse login(AccountLoginDto accountDto) {
        return null;
    }

}
