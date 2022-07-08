package com.exam.repo;

import com.exam.model.exam.Category;
import com.exam.model.exam.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuizRepository extends JpaRepository<Quiz,Long> {

    List<Quiz> findByCategory(Category category);

    List<Quiz> findByDepartment(String department);

    List<Quiz> findByActive(Boolean b);

    List<Quiz> findByDepartmentAndActive(String department, boolean b);
}
