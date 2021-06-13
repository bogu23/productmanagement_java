package com.sdaacademy.productmanagement.repository;


import com.sdaacademy.productmanagement.entities.CategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryModel, Long> {
}
