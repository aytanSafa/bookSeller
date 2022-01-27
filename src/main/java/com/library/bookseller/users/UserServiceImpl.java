package com.library.bookseller.users;

import com.library.bookseller.exceptions.UserServiceException;
import com.library.bookseller.exceptions.generic.BookSellerException;
import com.library.bookseller.users.dto.UserRegisterReqDto;
import com.library.bookseller.users.dto.UserRegisterResDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService{

    private final UsersRepository usersRepository;
    private final ModelMapper mapper;

    @Autowired
    public UserServiceImpl(UsersRepository usersRepository, ModelMapper mapper) {
        this.usersRepository = usersRepository;
        this.mapper = mapper;
    }


    @Override
    public UserRegisterResDto saveUser(UserRegisterReqDto userRegisterReqDto) {
            if(usersRepository.existsByUsername(userRegisterReqDto.getUsername())){
                buildException(UserServiceException.Exception.USER_ALREADY_EXIST);
            }
            UsersDAO newUser = mapper.map(userRegisterReqDto,UsersDAO.class);
            newUser.getBalance().setAmount(0);
            UsersDAO user = usersRepository.save(newUser);
            return mapper.map(user,UserRegisterResDto.class);
    }

    private BookSellerException buildException(UserServiceException.Exception exception) {
        return new UserServiceException(exception.getMessage(), exception.getHttpStatus());
    }

}
