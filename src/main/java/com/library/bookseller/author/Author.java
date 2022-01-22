package com.library.bookseller.author;

import com.library.bookseller.book.BookDAO;
import com.library.bookseller.entity.BaseEntity;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Author")
@Data
@NoArgsConstructor
@ToString
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "author_name")
    private String authorName;


    @OneToMany(mappedBy = "author")
    private List<BookDAO> books = new ArrayList<>();


}
