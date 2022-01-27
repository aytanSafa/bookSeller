package com.library.bookseller.categories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriesRepository extends JpaRepository<Categories,Long> {
        Categories findCategoriesByCategoryName(String name);
        void deleteCategoriesByCategoryName(String name);
        List<Categories> findAllByCategoryName(String name);
        boolean existsCategoriesByCategoryName(String name);

}
