package com.exam.repo;

import com.exam.model.exam.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category,Long> {

    List<Category> findCategoryByDepartment(String department);
}
