package com.library.bookseller.balance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BalanceRepository extends JpaRepository<BalanceDAO,Long> {
    BalanceDAO findBalanceDAOById(long id);
}
