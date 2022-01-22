package com.library.bookseller.balance;

import com.library.bookseller.entity.BaseEntity;
import com.library.bookseller.users.UsersDAO;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "balance")
@Data
@NoArgsConstructor
@ToString
public class BalanceDAO extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "amount")
    private String amount;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "users_id",nullable = false)
    private UsersDAO users;


}
