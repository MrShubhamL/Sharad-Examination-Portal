package com.exam.service.impl;

import com.exam.model.result.StudentResult;
import com.exam.repo.ResultRepository;
import com.exam.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class ResultServiceImpl implements ResultService {
    @Autowired
    public ResultRepository resultRepository;

    @Override
    public StudentResult addStudentResult(StudentResult studentResult) {
        return this.resultRepository.save(studentResult);
    }

    @Override
    public List<StudentResult> getAllStudent() {
        return this.resultRepository.findAll();
    }

    @Override
    public List<StudentResult> getResultByDepartment(String department,String year) {
        return this.resultRepository.findStudentResultByDepartmentAndYearsOfStudy(department,year);
    }

    @Override
    public StudentResult getStudentResultByUsername(String studentUsername) {
        return this.resultRepository.findStudentResultByStudentUsername(studentUsername);
    }


}
