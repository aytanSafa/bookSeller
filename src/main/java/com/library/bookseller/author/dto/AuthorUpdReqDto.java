package com.library.bookseller.author.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class AuthorUpdReqDto {

    private long id;
    private String authorName;

}
