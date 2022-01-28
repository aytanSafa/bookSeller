package com.library.bookseller.account.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AccountRegisterDto {

    private String username;
    private String password;
    private String name;
    private String surname;
    private String address;
    private int age;
    private String email;
}
