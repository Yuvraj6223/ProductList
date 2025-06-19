package com.bitsbytes.Product.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductController {

    private ProductService productService;
        //Get all product
        @GetMapping
        public List<ProductDTO> getAllProducts(){
            return productService.getAllProducts();
        }
        //Get product by id
        @GetMapping("/{id}")
        public ProductDTO getProductbyId(@PathVariable Long id){
            return productService.getProductbyId(id);
        }
        //Create product
        @PostMapping 
        public ResponseEntity<ProductDTO> createProductDTO(@RequestBody ProductDTO productDTO){
            ProductDTO createdProduct =  productService.createProduct(productDTO);
            return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
        }
        //Update product
        @PutMapping("/{id}")
        public ProductDTO updateProduct(@PathVariable Long id, @RequestBody ProductDTO productDTO){
            return productService.updateProduct(id, productDTO);
        }
        //Delete product
        @DeleteMapping("/{id}")
        public String deleteproduct(@PathVariable Long id){
            return productService.deleteproduct(id);
        }
}