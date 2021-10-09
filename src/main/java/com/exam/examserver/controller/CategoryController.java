package com.exam.examserver.controller;

import com.exam.examserver.Service.CategoryService;
import com.exam.examserver.entity.exam.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
@CrossOrigin("*")
public class CategoryController {


    @Autowired
    private CategoryService categoryService;

    // add category
    @PostMapping("/")
    public ResponseEntity<Category> addCategory(@RequestBody Category category){
       Category category1= this.categoryService.addCategory(category);
       return ResponseEntity.ok(category1);
    }
    // get specific category
    @GetMapping("/{categoryId")
    public Category getCategory(@PathVariable Long categoryId){
        return this.categoryService.getCategory(categoryId);

    }
    // get All category
    @GetMapping("/")
    public ResponseEntity<?> getCategories(){
        return ResponseEntity.ok(this.categoryService.getCategories());
    }
    //update Category
    @PutMapping("/")
    public Category updateCategory (@RequestBody Category category){
        return this.categoryService.updateCategory(category);
    }
    // delete the category
    public void deleteCategory(@PathVariable("categoryId") Long categoryId){
        this.categoryService.deleteCategory(categoryId);
    }
}
