package com.exam.service;
import com.exam.model.exam.Category;

import java.util.*;
public interface CategoryService {
    public Category addCategory(Category category);
    public Category updateCategory(Category category);
    public Set<Category> getAllCategory();
    public Category getSingleCategory(Long cateId);
    public void deleteCategory(Long cateId);

    List<Category> getCategoryByDepartment(String department);
}
