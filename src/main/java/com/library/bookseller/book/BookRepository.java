package com.library.bookseller.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<BookDAO,Long> {
/*
    List<BookDAO> findAllByUsers_Id(long id);

    @Query("select b from BookDAO b where b.users.id <> : userId")
    List<BookDAO> findAllByUsersNot(@Param("userId")long id);
*/
    boolean existsByBookName(String name);

    List<BookDAO> findByBookName(String name);

    Optional<BookDAO> findByBookNameAndUsers_Id(String bookName, long usersId);

    List<BookDAO> findAllByUsers_Id(long users_id);
}
