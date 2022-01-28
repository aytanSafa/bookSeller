package com.library.bookseller.author;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.library.bookseller.book.BookDAO;
import com.library.bookseller.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Author")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "author_name")
    private String authorName;

    @OneToMany(mappedBy = "author",cascade = CascadeType.ALL)
    private List<BookDAO> books = new ArrayList<>();


}
