package com.example.demo.controller;

import com.example.demo.dto.ProductDTO;
import com.example.demo.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pro")
@AllArgsConstructor
public class ProductController {
    private ProductService productService;

//get all product
    @GetMapping
    public List<ProductDTO>getAllProducts(){
        return productService.getAllProducts();
    }
    //productby id
    @GetMapping("/{id}")
    public ProductDTO getProductById(@PathVariable Long id){
        return productService.getProductById(id);
    }
    //create product
    @PostMapping
    public ProductDTO createproduct(@RequestBody ProductDTO productDTO) {
return productService.createProduct(productDTO);
    }

    //update product
    @PutMapping("/{id}")
    public ProductDTO updateProduct(@PathVariable Long id, @RequestBody ProductDTO productDTO) {
       return productService.updateProduct(id,productDTO);

    }

    //delete product
    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id) {
        return productService.deleteProduct(id);
    }
}
