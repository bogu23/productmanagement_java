package com.sdaacademy.productmanagement.repository;

import com.sdaacademy.productmanagement.entities.CartModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<CartModel, Long> {
}
