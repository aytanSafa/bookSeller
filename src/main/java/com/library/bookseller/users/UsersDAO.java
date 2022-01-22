package com.library.bookseller.users;

import com.library.bookseller.balance.BalanceDAO;
import com.library.bookseller.book.BookDAO;
import com.library.bookseller.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class UsersDAO  extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "username",unique = true,length = 10)
    private String username;

    @Column(name = "password",length = 8)
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "adress")
    private String adress;

    @Column(name = "age")
    private int age;

    @Column(name = "email")
    private String email;

    @OneToOne(mappedBy = "users")
    private BalanceDAO balance;

    @OneToMany(mappedBy = "users")
    private List<BookDAO> books = new ArrayList<>();
}
