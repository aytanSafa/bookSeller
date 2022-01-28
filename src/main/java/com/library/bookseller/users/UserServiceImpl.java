package com.library.bookseller.users;

import com.library.bookseller.balance.BalanceDAO;
import com.library.bookseller.exceptions.UserServiceException;
import com.library.bookseller.exceptions.generic.BookSellerException;
import com.library.bookseller.users.dto.UserRegisterReqDto;
import com.library.bookseller.users.dto.UserRegisterResDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService{

    private final UsersRepository usersRepository;
    private final ModelMapper mapper;

    @Autowired
    public UserServiceImpl(UsersRepository usersRepository, ModelMapper mapper) {
        this.usersRepository = usersRepository;
        this.mapper = mapper;
    }

    @Transactional
    @Override
    public UserRegisterResDto saveUser(UserRegisterReqDto userRegisterReqDto) {
            if(usersRepository.existsByUsername(userRegisterReqDto.getUsername())){
               throw  buildException(UserServiceException.Exception.USER_ALREADY_EXIST);
            }
            UsersDAO newUser = mapper.map(userRegisterReqDto,UsersDAO.class);
            BalanceDAO balanceDAO = new BalanceDAO();
            balanceDAO.setAmount(0);
            newUser.setBalance(balanceDAO);
            balanceDAO.setUsers(newUser);
            UsersDAO user = usersRepository.save(newUser);
            return mapper.map(user,UserRegisterResDto.class);
    }

    private BookSellerException buildException(UserServiceException.Exception exception) {
        return new UserServiceException(exception.getMessage(), exception.getHttpStatus());
    }

}
