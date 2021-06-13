package com.sdaacademy.productmanagement.service;

import com.sdaacademy.productmanagement.entities.ProductModel;
import com.sdaacademy.productmanagement.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<ProductModel> getAll() {
        return productRepository.findAll();
    }

    public void add(ProductModel productModel) {

        if (productModel.getPrice() < 1) {
            throw new RuntimeException("Price should not be less then 1!");
        }
        if (productModel.getName() == null || productModel.getName().equals("")) {
            throw new RuntimeException("Name is empty.Please fill out the name!");
        }
        productRepository.save(productModel);
    }


    public void edit(ProductModel productModel) {
        if (productModel.getPrice() > 0 &&
                productModel.getName() != null) {
            productRepository.save(productModel);
        }
    }

    public ProductModel getProductById(long id) {
        Optional<ProductModel> productModelOptional = productRepository.findById(id);
        ProductModel productModel = productModelOptional.get();
        return productModel;
    }

    public void removeById(long id) {
        productRepository.deleteById(id);
    }

    public List<ProductModel> getOrderedProducts() {
        List<ProductModel> orderedProducts = productRepository.getProductsOrderedByName();
        return orderedProducts;
    }
}
