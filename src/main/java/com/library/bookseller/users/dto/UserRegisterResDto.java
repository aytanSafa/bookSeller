package com.library.bookseller.users.dto;

import lombok.Data;

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


}
