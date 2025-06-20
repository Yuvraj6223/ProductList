package com.bitsbytes.Product.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bitsbytes.Product.Service.CategoryService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import com.bitsbytes.Product.Dto.CategoryDTO;
import lombok.AllArgsConstructor;

@Tag(
    name = "Category REST API CRUD operation",
    description = "CREATE, READ, UPDATE, DELETE operations for Category REST API"
)
@RestController
@RequestMapping("/api/categories")
@AllArgsConstructor
public class CategoryController {

    private CategoryService categoryService;
    //Get all categories
    @Operation(
            summary = "Fetch all Categories",
            description = "REST API to fetch all categories"
        )
    @GetMapping
    public List<CategoryDTO> getAllCategories(){
        return categoryService.getAllCategories();
    }
    //Create categories
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @Operation(
            summary = "Create Category",
            description = "REST API to Create a Category"
        )
    @ApiResponse(
        responseCode = "201",
        description = "CREATED"
    )
    @PostMapping
    public ResponseEntity<?> createCategory(@RequestBody CategoryDTO categoryDTO){
        CategoryDTO savedCategory = categoryService.createCategory(categoryDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCategory);
        // return new ResponseEntity<>(categoryService.createCategory(categoryDTO), HttpStatus.CREATED);
    }
    //Get category by ID
    @Operation(
            summary = "Fetch Category by ID",
            description = "REST API to fetch category by ID"
        )
    @GetMapping("/{id}")
    public CategoryDTO getCategorybyId(@PathVariable Long id){
        return categoryService.getCategorybyId(id);
    }
    //Delete category
    @Operation(
            summary = "Delete a category",
            description = "REST API to delete Category"
        )
        @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public String deletecategory(@PathVariable Long id){
        return categoryService.deletecategory(id);
    }
}