package com.library.bookseller.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<BookDAO,Long> {
/*
    List<BookDAO> findAllByUsers_Id(long id);

    @Query("select b from BookDAO b where b.users.id <> : userId")
    List<BookDAO> findAllByUsersNot(@Param("userId")long id);
*/
    List<BookDAO> findByBookName(String name);




}
