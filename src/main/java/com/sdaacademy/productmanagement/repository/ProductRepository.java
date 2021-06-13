package com.sdaacademy.productmanagement.repository;

import com.sdaacademy.productmanagement.entities.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel, Long> {

    //1 native query SQL
    //2 HQL

    @Query("Select product from ProductModel product order by product.name")
    public List<ProductModel> getProductsOrderedByName();

    //3 Method refence ?!


}
