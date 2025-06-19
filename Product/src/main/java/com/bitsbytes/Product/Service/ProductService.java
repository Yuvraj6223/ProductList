package com.bitsbytes.Product.Service;
import com.bitsbytes.Product.entity.Category;
import java.util.List;
import org.springframework.stereotype.Service;
import com.bitsbytes.Product.Dto.ProductDTO;
import com.bitsbytes.Product.entity.Product;
import com.bitsbytes.Product.exception.CategoryNotFoundException;
import com.bitsbytes.Product.Mapper.ProductMapper;
import com.bitsbytes.Product.Repository.CategoryRepository;
import com.bitsbytes.Product.Repository.ProductRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductService {
        private ProductRepository productRepository;
        private CategoryRepository categoryRepository;

        public ProductDTO createProduct(ProductDTO productDTO){

            Category category = categoryRepository.findById(productDTO.getCategoryId())
                .orElseThrow(() -> new CategoryNotFoundException("Category id "+ productDTO.getCategoryId()+" not found"));

            //DTO to Entity
            Product product = ProductMapper.toProductEntity(productDTO, category);
            product = productRepository.save(product);

            //Entity to DTO
            return ProductMapper.toProductDTO(product);
        }
          //Get all products
        public List<ProductDTO> getAllProducts(){
                return productRepository.findAll().stream().map(ProductMapper::toProductDTO).toList();
        }
        //Get product by id
        public ProductDTO getProductbyId(Long id){
               Product product = productRepository.findById(id).orElseThrow(()-> new RuntimeException("Product not found"));
               return ProductMapper.toProductDTO(product);
        }
        //Update product
        public ProductDTO updateProduct(Long id, ProductDTO productDTO){
                Product product = productRepository.findById(id).orElseThrow(()-> new RuntimeException("Product not found"));
                Category category = categoryRepository.findById(productDTO.getCategoryId())
                .orElseThrow(()-> new RuntimeException("Category not found"));

                product.setName(productDTO.getName());
                product.setDescription(productDTO.getDescription());
                product.setPrice(productDTO.getPrice());
                product.setCategory(category);
                productRepository.save(product);
                return ProductMapper.toProductDTO(product);
        }
        //Delete product
        public String deleteproduct(Long id){
                productRepository.deleteById(id);
                return "Product "+ id +"deleted successfully";
        }
}