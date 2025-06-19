package com.bitsbytes.Product.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bitsbytes.Product.entity.Product; 

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}