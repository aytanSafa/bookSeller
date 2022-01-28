package com.library.bookseller.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<UsersDAO,Long> {
    boolean existsByUsername(String username);

}
