package com.bitsbytes.Product.Mapper;

import com.bitsbytes.Product.Dto.ProductDTO;
import com.bitsbytes.Product.entity.Category;
import com.bitsbytes.Product.entity.Product;

public class ProductMapper {
    //Entity to dto
    public static ProductDTO toProductDTO(Product product){
        return new ProductDTO(
            product.getId(),
            product.getName(),
            product.getDescription(),
            product.getPrice(),
            product.getCategory().getId()
        );
    }
    //Dto to entity
    public static Product toProductEntity(ProductDTO productDTO, Category category){
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setCategory(category);

        return product;

    }
}