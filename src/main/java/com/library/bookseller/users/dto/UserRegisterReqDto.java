package com.library.bookseller.users.dto;


import lombok.Data;

import java.util.Set;

@Data
public class UserRegisterReqDto {

    private String username;
    private String password;
    private String name;
    private String surname;
    private String address;
    private int age;
    private String email;
    private Set<String> roles;

}
