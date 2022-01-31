package com.library.bookseller.book.request;

import lombok.Data;

@Data
public class BookUpdDto {

    private long id;
    private String bookName;
    private String description;
    private int quantity;
    private double price;
    private String authorName;
    private String categoryName;
    private long userId;
}
