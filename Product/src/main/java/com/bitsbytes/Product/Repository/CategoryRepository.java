package com.bitsbytes.Product.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bitsbytes.Product.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
        Optional<Category> findByName(String categoryName);
}