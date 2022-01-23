package com.library.bookseller.author;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Long> {
    Author findAuthorByAuthorName(String name);
    void deleteAuthorByAuthorName(String name);
}
