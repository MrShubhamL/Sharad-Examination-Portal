package com.exam.service.impl;

import com.exam.model.exam.Category;
import com.exam.repo.CategoryRepository;
import com.exam.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category addCategory(Category category) {
        return this.categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Category category) {
        return this.categoryRepository.save(category);
    }

    @Override
    public Set<Category> getAllCategory() {
        return new LinkedHashSet<>(this.categoryRepository.findAll());
    }

    @Override
    public Category getSingleCategory(Long cateId) {
        return this.categoryRepository.findById(cateId).get();
    }

    @Override
    public void deleteCategory(Long cateId) {
        this.categoryRepository.deleteById(cateId);
    }

    @Override
    public List<Category> getCategoryByDepartment(String department) {
        return this.categoryRepository.findCategoryByDepartment(department);
    }
}
