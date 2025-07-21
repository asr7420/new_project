package com.example.demo.service;

import com.example.demo.dto.ProductDTO;
import com.example.demo.entity.Category;
import com.example.demo.entity.Product;
import com.example.demo.exception.CategoryNotFoundException;
import com.example.demo.mapper.ProductMapper;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductService {
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;
    //we made this category repository because by this repository we can see if the category in which product is to be added is available or not
    public ProductDTO createProduct(ProductDTO productDTO) {

      Category category= categoryRepository.findById(productDTO.getCategoryId()).orElseThrow(()->new RuntimeException("category not found"));


    //save krne ke liye dto se entity mai change krna padega mapper mai method hai
        Product product =ProductMapper.toProductEntity(productDTO,category);
        productRepository.save(product);
        //entity to dto krna padega to return after the method
        return ProductMapper.toProductDTO(product);
}
    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll().stream().map(ProductMapper::toProductDTO).toList();
    }
    public ProductDTO getProductById(Long id) {

        Product product = productRepository.findById(id).orElseThrow(()->new CategoryNotFoundException("Product with id " + id + " not found"));
    return ProductMapper.toProductDTO(product);
    }
    public ProductDTO updateProduct(Long id,ProductDTO productDTO) {
        Product product = productRepository.findById(productDTO.getId()).orElseThrow(()->new RuntimeException("product not found"));
Category category=categoryRepository.findById(productDTO.getCategoryId()).orElseThrow(()->new RuntimeException("category not found"));
product.setName(productDTO.getName());
product.setDescription(productDTO.getDescription());
product.setPrice(productDTO.getPrice());
product.setCategory(category);
productRepository.save(product);
return ProductMapper.toProductDTO(product);
    }
public String deleteProduct(Long id) {
        productRepository.deleteById(id);
        return "delete ho gya laadle";
}
}
