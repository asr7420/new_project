package com.example.demo.mapper;

import com.example.demo.dto.CategoryDTO;
import com.example.demo.entity.Category;

import java.util.stream.Collectors;

public class CategoryMapper {
    //logic to convert dto se entity dega
    public static Category toCategoryEntity(CategoryDTO categoryDTO){
        Category category = new Category();
        category.setName(categoryDTO.getName());
return category;

    }
    //logic to convert entity to dto
    public static CategoryDTO toCategoryDTO(Category category){
        if (category == null){
            return null;
        }
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(category.getId());
        categoryDTO.setName(category.getName());
        categoryDTO.setProducts(category.getProducts().stream().map(ProductMapper::toProductDTO).toList());
    return categoryDTO;
    }
}
