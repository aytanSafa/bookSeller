package com.library.bookseller.users.dto;

import lombok.Data;

@Data
public class UserUpdateResDto {

    private String name;
    private String surname;
    private String address;
    private int age;
    private String email;
}
