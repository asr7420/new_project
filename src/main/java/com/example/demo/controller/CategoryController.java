package com.example.demo.controller;

import com.example.demo.dto.CategoryDTO;
import com.example.demo.entity.Category;
import com.example.demo.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/api/cat")
@AllArgsConstructor
public class CategoryController {
    //get all categories

    //create categories
    private CategoryService categoryService;
    @GetMapping
    public List<CategoryDTO>getAllCategories(){
       return categoryService.getAllCategories();
    }
@PostMapping
public CategoryDTO createCategory(@RequestBody CategoryDTO categoryDTO) {

    return categoryService.createCategory(categoryDTO);
}

    //get category by id
    @GetMapping("/{id}")

    public CategoryDTO getCategoryById(@PathVariable Long id){
return categoryService.getCategoryByid(id);
    }
    @DeleteMapping("/{id}")
    public String deleteCategory(@PathVariable Long id) {
        return categoryService.deleteCategoryByid(id);

    }

    //delete category
}
