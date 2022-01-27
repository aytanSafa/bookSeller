package com.library.bookseller.book.request;

import com.library.bookseller.author.Author;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class BookReqDto {

    private String bookName;
    private String description;
    private int quantity;
    private double price;
    private String authorName;
    private String categoryName;

}
