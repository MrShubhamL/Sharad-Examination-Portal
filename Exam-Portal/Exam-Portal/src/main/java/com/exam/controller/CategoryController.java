package com.exam.controller;

import com.exam.model.exam.Category;
import com.exam.model.exam.Quiz;
import com.exam.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
@CrossOrigin("*")
public class CategoryController{
    @Autowired
    private CategoryService categoryService;


    // add Category
    @PostMapping("/")
    public ResponseEntity<Category> addCategory(@RequestBody Category category){
        Category category1 = this.categoryService.addCategory(category);
        return ResponseEntity.ok(category1);
    }

    // Get Single Category
    @GetMapping("/{categoryId}")
    public Category getCategory(@PathVariable("categoryId") Long categoryId){
        return this.categoryService.getSingleCategory(categoryId);
    }

    // Get All Category
    @GetMapping("/")
    public ResponseEntity<?> getAllCategories(){
        return ResponseEntity.ok(this.categoryService.getAllCategory());
    }

    //Update Category
    @PutMapping("/")
    public Category updateCategory(@RequestBody Category category){
        return this.categoryService.updateCategory(category);
    }

    // Delete Category
    @DeleteMapping("/{categoryId}")
    public void deleteCategory(@PathVariable("categoryId") Long categoryId){
        this.categoryService.deleteCategory(categoryId);
    }

    @GetMapping("/cateDepart/{department}")
    public List<Category> getCategoryByDepartment(@PathVariable("department") String department){
        return this.categoryService.getCategoryByDepartment(department);
    }


}
