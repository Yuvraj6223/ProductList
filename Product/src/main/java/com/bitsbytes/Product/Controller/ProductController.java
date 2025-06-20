package com.bitsbytes.Product.Controller;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bitsbytes.Product.Dto.ProductDTO;
import com.bitsbytes.Product.Service.ProductService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@Tag(
    name = "Product REST API CRUD operation",
    description = "CREATE, READ, UPDATE, DELETE operations for Product REST API"
)
@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductController {

    private ProductService productService;
        //Get all product
        @Operation(
            summary = "Fetch all Products",
            description = "REST API to fetch all products"
        )
        @GetMapping
        public List<ProductDTO> getAllProducts(){
            return productService.getAllProducts();
        }
        //Get product by id
        @Operation(
            summary = "Fetch Product by ID",
            description = "REST API to fetch product by ID"
        )
        @GetMapping("/{id}")
        public ProductDTO getProductbyId(@PathVariable Long id){
            return productService.getProductbyId(id);
        }
        //Create product
        @Operation(
            summary = "Create Product",
            description = "REST API to Create a Product"
        )
        @ApiResponse(
            responseCode = "201",
            description = "CREATED"
        )
        @PreAuthorize("hasAuthority('ROLE_SELLER')")
        @PostMapping 
        public ResponseEntity<ProductDTO> createProductDTO(@RequestBody ProductDTO productDTO){
            ProductDTO createdProduct =  productService.createProduct(productDTO);
            return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
        }
        //Update product
        @Operation(
            summary = "Update Product",
            description = "REST API to update product"
        )
        @PreAuthorize("hasAuthority('ROLE_SELLER')")
        @PutMapping("/{id}")
        public ProductDTO updateProduct(@PathVariable Long id, @RequestBody ProductDTO productDTO){
            return productService.updateProduct(id, productDTO);
        }
        //Delete product
        @Operation(
            summary = "Delete a Product",
            description = "REST API to delete a product"
        )
        @PreAuthorize("hasAuthority('ROLE_SELLER')")
        @DeleteMapping("/{id}")
        public String deleteproduct(@PathVariable Long id){
            return productService.deleteproduct(id);
        }
}