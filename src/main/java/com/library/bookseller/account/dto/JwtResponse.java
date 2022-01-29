package com.library.bookseller.account.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JwtResponse {

    String jwt;
    long id;
    String username;
    String email;
    List<String> roles;

}
