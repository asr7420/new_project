package com.example.demo.service;

import com.example.demo.dto.CategoryDTO;
import com.example.demo.entity.Category;
import com.example.demo.mapper.CategoryMapper;
import com.example.demo.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryService {
    private CategoryRepository categoryRepository;

    //here mapper was used to convert dto to entity
    public CategoryDTO createCategory(CategoryDTO categoryDTO){
      Category category= CategoryMapper.toCategoryEntity(categoryDTO);
     category= categoryRepository.save(category);
     //ab use hoga to convert entity to dto iska bhe method category mapper mai hoga
return CategoryMapper.toCategoryDTO(category);
    }

    public List<CategoryDTO> getAllCategories(){
      return   categoryRepository.findAll().stream().map(CategoryMapper::toCategoryDTO).toList();
    }
    //get category by id
    public CategoryDTO getCategoryByid(Long id){
        Category category = categoryRepository.findById(id).orElseThrow(()->new RuntimeException("categorty not found"));
        return CategoryMapper.toCategoryDTO(category);
    }
    public String deleteCategoryByid(Long id){
        categoryRepository.deleteById(id);
        return ("ho gya delete");
    }
}
