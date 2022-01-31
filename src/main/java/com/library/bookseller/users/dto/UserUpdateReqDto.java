package com.library.bookseller.users.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UserUpdateReqDto {

    private long id;
    private String name;
    private String surname;
    private String address;
    private int age;
    private String email;
}
