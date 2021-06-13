package com.sdaacademy.productmanagement.controller;

import com.sdaacademy.productmanagement.entities.ProductModel;
import com.sdaacademy.productmanagement.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("getProducts")
    public List<ProductModel> getAllProducts() {
        List<ProductModel> productModelList = productService.getAll();
        return productModelList;
    }

    @PostMapping("addProduct")
    public ResponseEntity addProduct(@RequestBody ProductModel productToBeAdded) {
        try {
            productService.add(productToBeAdded);
            return ResponseEntity.ok("Product added");
        } catch (RuntimeException exception) {
            return new ResponseEntity<Object>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("edit")
    public void editProduct(@RequestBody ProductModel productToBeEdited) {
        productService.edit(productToBeEdited);
    }

    @GetMapping("getProductById/{id}")
    public ProductModel getProductById(@PathVariable long id) {
        ProductModel productFound = productService.getProductById(id);
        return productFound;
    }

    @DeleteMapping("deleteById/{id}")
    public void deleteProductById(@PathVariable long id) {
        productService.removeById(id);
    }

    @GetMapping("getOrderedProducts")
    public List<ProductModel> getProductsOrdered() {
        List<ProductModel> orderedProducts = productService.getOrderedProducts();
        return orderedProducts;
    }
}
