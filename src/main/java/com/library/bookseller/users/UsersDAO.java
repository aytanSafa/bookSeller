package com.library.bookseller.users;

import com.library.bookseller.balance.BalanceDAO;
import com.library.bookseller.entity.BaseEntity;
import com.library.bookseller.security.role.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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

    @Column(name = "address")
    private String address;

    @Column(name = "age")
    private int age;

    @Column(name = "email")
    private String email;

    //
    @OneToOne(mappedBy = "users",cascade = CascadeType.ALL)
    private BalanceDAO balance;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(	name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();



/*
    @OneToMany(mappedBy = "users")
    private List<BookDAO> books = new ArrayList<>();

 */

}
