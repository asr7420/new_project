package com.example.demo.mapper;

import com.example.demo.dto.ProductDTO;
import com.example.demo.entity.Category;
import com.example.demo.entity.Product;

public class ProductMapper {
    //entity se dto
    public static ProductDTO toProductDTO(Product product){
        return new ProductDTO(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getCategory().getId()
        );
    }
    //dto se entity
    public static Product toProductEntity(ProductDTO productDTO, Category category){
Product product = new Product();
product.setName(productDTO.getName());
product.setDescription(productDTO.getDescription());
product.setPrice(productDTO.getPrice());
product.setCategory(category);
return product;
    }
}
