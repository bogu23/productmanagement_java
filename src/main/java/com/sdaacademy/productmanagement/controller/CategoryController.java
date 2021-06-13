package com.sdaacademy.productmanagement.controller;

import com.sdaacademy.productmanagement.entities.CategoryModel;
import com.sdaacademy.productmanagement.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Access;
import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("addCategory")
    public void addCategory(@RequestBody CategoryModel categoryModel) {
        categoryService.addCategory(categoryModel);
    }

    @GetMapping("getCategories")
    public List<CategoryModel> getAll() {
        return categoryService.getAll();
    }

    // id-> Category ->  id produs.
    //  /addProductToCategory/12/2
    @PutMapping("addProductToCategory/{idProduct}/{idCategory}")
    public void addProductToCategory(@PathVariable long idProduct,
                                     @PathVariable long idCategory) {

        categoryService.addProduct(idProduct, idCategory);

    }
}
