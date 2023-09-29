package com.example.resturent.controller;


import com.example.resturent.expection.ResourceNotFoundException;

import com.example.resturent.modal.Category;
import com.example.resturent.repo.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")

public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/category")
    public List<Category> getAllCategory(){ return categoryRepository.findAll();}

    // create burger rest api
    @PostMapping("/category")
    public Category createCategory(@RequestBody Category category){
        return categoryRepository.save(category);
    }

    //get burger by id rest api
    @GetMapping("/category/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Long id){

        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not exist with id:" + id));
        return ResponseEntity.ok(category);
    }

    //update burger rest api
    @PutMapping("/category/{id}")
    public ResponseEntity<Category> CategoryUpdate(@PathVariable Long id, @RequestBody Category categoryDetails){
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not exist with id:" + id));

        category.setName(categoryDetails.getItem());
        category.setName(categoryDetails.getName());
        category.setPrice(categoryDetails.getPrice());
        category.setSize(categoryDetails.getSize());
        category.setImageURL(categoryDetails.getImageURL());
        category.setDetails(categoryDetails.getDetails());

        Category CategoryUpdated = categoryRepository.save(category);
        return ResponseEntity.ok(CategoryUpdated);
    }

    //delete burger rest api
    @DeleteMapping("/category/{id}")
    public ResponseEntity<Object> deleteCategory(@PathVariable Long id){
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not exist with id:" + id));


        categoryRepository.delete(category);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return  ResponseEntity.ok(response);
    }

}
