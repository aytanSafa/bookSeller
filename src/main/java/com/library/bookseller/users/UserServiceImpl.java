package com.library.bookseller.users;

import com.library.bookseller.balance.BalanceDAO;
import com.library.bookseller.exceptions.UserServiceException;
import com.library.bookseller.exceptions.generic.BookSellerException;
import com.library.bookseller.security.role.ERole;
import com.library.bookseller.security.role.Role;
import com.library.bookseller.security.role.RoleRepository;
import com.library.bookseller.users.dto.UserRegisterReqDto;
import com.library.bookseller.users.dto.UserRegisterResDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService{

    private final UsersRepository usersRepository;
    private final RoleRepository roleRepository;
    private final ModelMapper mapper;
    private final PasswordEncoder encoder;


    @Autowired
    public UserServiceImpl(UsersRepository usersRepository, RoleRepository roleRepository, ModelMapper mapper, PasswordEncoder encoder) {
        this.usersRepository = usersRepository;
        this.roleRepository = roleRepository;
        this.mapper = mapper;
        this.encoder = encoder;
    }

    @Transactional
    @Override
    public UserRegisterResDto saveUser(UserRegisterReqDto userRegisterReqDto) {
            if(usersRepository.existsByUsername(userRegisterReqDto.getUsername())){
               throw  buildException(UserServiceException.Exception.USER_ALREADY_EXIST);
            }
            if(existsByEmail(userRegisterReqDto.getEmail())){
                throw   buildException(UserServiceException.Exception.USER_ALREADY_EXIST);
            }

            UsersDAO newUser = new UsersDAO();
            newUser.setUsername(userRegisterReqDto.getUsername());
            newUser.setPassword(encoder.encode(userRegisterReqDto.getPassword()));
            newUser.setEmail(userRegisterReqDto.getEmail());
            newUser.setAddress(userRegisterReqDto.getAddress());
            newUser.setSurname(userRegisterReqDto.getSurname());
            newUser.setName(userRegisterReqDto.getName());
            newUser.setAge(userRegisterReqDto.getAge());
            newUser.setName(userRegisterReqDto.getName());

            BalanceDAO balanceDAO = new BalanceDAO();
            balanceDAO.setAmount(0);
            newUser.setBalance(balanceDAO);
            balanceDAO.setUsers(newUser);

            Set<String> strRoles = userRegisterReqDto.getRoles();
            Set<Role> roles = new HashSet<>();

            strRoles.forEach(role -> {
                switch (role){
                    case "admin":
                        Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                                .orElseThrow(()-> buildException(UserServiceException.Exception.ROLE_NOT_FOUND));
                        roles.add(adminRole);
                        break;
                    case "seller":
                        Role sellerRole = roleRepository.findByName(ERole.ROLE_SELLER)
                                .orElseThrow(()-> buildException(UserServiceException.Exception.ROLE_NOT_FOUND));
                        roles.add(sellerRole);
                        break;
                    default:
                        Role userRole = roleRepository.findByName(ERole.ROLE_CUSTOMER)
                                .orElseThrow(()-> buildException(UserServiceException.Exception.ROLE_NOT_FOUND));
                        roles.add(userRole);
                }
            });
            newUser.setRoles(roles);
            UsersDAO user = usersRepository.save(newUser);
            return mapper.map(user,UserRegisterResDto.class);
    }

    @Override
    public UsersDAO findByUsername(String username) {
        return usersRepository.findByUsername(username).orElseThrow(() -> buildException(UserServiceException.Exception.USER_NOT_FOUND));
    }

    @Override
    public Boolean existsByUsername(String username) {
        return usersRepository.existsByUsername(username);
    }

    @Override
    public Boolean existsByEmail(String email) {
        return usersRepository.existsByEmail(email);
    }

    private BookSellerException buildException(UserServiceException.Exception exception) {
        return new UserServiceException(exception.getMessage(), exception.getHttpStatus());
    }

}
