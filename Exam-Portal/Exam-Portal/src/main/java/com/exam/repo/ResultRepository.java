package com.exam.repo;

import com.exam.model.result.StudentResult;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResultRepository extends JpaRepository<StudentResult, Long> {
    public List<StudentResult> findStudentResultByDepartmentAndYearsOfStudy(String department,String year);
    public StudentResult findStudentResultByStudentUsername(String studentUsername);
    public StudentResult findAllByStudentUsername(String studentUsername);
}
