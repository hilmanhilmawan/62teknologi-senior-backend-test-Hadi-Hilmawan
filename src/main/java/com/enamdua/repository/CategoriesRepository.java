package com.enamdua.repository;

import com.enamdua.model.Categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CategoriesRepository extends CrudRepository<Categories, Long>, JpaRepository<Categories, Long> {
    Optional<Categories> findByReftId(String reftId);
}
