package com.bitsbytes.Product.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bitsbytes.Product.Service.CategoryService;
import com.bitsbytes.Product.Dto.CategoryDTO;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/categories")
@AllArgsConstructor
public class CategoryController {

    private CategoryService categoryService;
    //Get all categories
    @GetMapping
    public List<CategoryDTO> getAllCategories(){
        return categoryService.getAllCategories();
    }
    //Create categories
    @PostMapping
    public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO categoryDTO){
        return new ResponseEntity<>(categoryService.createCategory(categoryDTO), HttpStatus.CREATED);
    }
    //Get category by ID
    @GetMapping("/{id}")
    public CategoryDTO getCategorybyId(@PathVariable Long id){
        return categoryService.getCategorybyId(id);
    }
    //Delete category
    @DeleteMapping("/{id}")
    public String deletecategory(@PathVariable Long id){
        return categoryService.deletecategory(id);
    }
}