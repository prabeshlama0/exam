package com.exam.examserver.Service.Impl;

import com.exam.examserver.Service.CategoryService;
import com.exam.examserver.entity.exam.Category;
import com.exam.examserver.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;
@Service
public class CategoryImpl implements CategoryService {



    @Autowired
    private CategoryRepository categoryRepository;

    // To add the category
    @Override
    public Category addCategory(Category category) {
        return this.categoryRepository.save(category);
    }
 //to update category
    @Override
    public Category updateCategory(Category category) {
        return this.categoryRepository.save(category);
    }
 // to get all the category
    @Override
    public Set<Category> getCategories() {
        return new LinkedHashSet<>(this.categoryRepository.findAll());
    }
// To get specific category
    @Override
    public Category getCategory(Long categoryId) {
        return this.categoryRepository.findById(categoryId).get();
    }
// delete the category
    @Override
    public void deleteCategory(Long categoryId) {
      Category category = new Category();
      category.setCid(categoryId);
      this.categoryRepository.delete(category);
    }
}
