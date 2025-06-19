package com.bitsbytes.Product.Service;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.bitsbytes.Product.Dto.CategoryDTO;
import com.bitsbytes.Product.entity.Category;
import com.bitsbytes.Product.exception.CategoryAlreadyExistsException;
import com.bitsbytes.Product.Mapper.CategoryMapper;
import com.bitsbytes.Product.Repository.CategoryRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CategoryService {

    private CategoryRepository categoryRepository;
    //Create category
    public CategoryDTO createCategory(CategoryDTO categoryDTO){
        
        Optional<Category> optionalCategory = categoryRepository.findByName(categoryDTO.getName());
        if(optionalCategory.isPresent()){
            throw new CategoryAlreadyExistsException("Category already exists");
        }
        Category category = CategoryMapper.toCategoryEntity(categoryDTO);
        category = categoryRepository.save(category);
        return CategoryMapper.toCategoryDTO(category);
    }
    
    //Get all categories
    public List<CategoryDTO> getAllCategories(){
        return categoryRepository.findAll().stream().map(CategoryMapper::toCategoryDTO).toList();
    } 

    //Get category by id
    public CategoryDTO getCategorybyId(Long id){
        Category category = categoryRepository.findById(id).orElseThrow(()-> new RuntimeException("Category not found"));
        return CategoryMapper.toCategoryDTO(category);
    }
    //Delete category
    public String deletecategory(Long id){
        categoryRepository.deleteById(id);
        return "Category "+ id +" has been successfully deleted";
    }
}