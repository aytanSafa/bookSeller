package com.library.bookseller.users.dto;

import com.library.bookseller.security.role.Role;
import lombok.Data;

import java.util.Set;

@Data
public class UserRegisterResDto {

    private long id;
    private String username;
    private String password;
    private String name;
    private String surname;
    private String address;
    private int age;
    private String email;
    private double amount;
    private Set<Role> roles;


}
