package com.exam.service;

import com.exam.model.result.StudentResult;
import java.util.*;
public interface ResultService {

    public StudentResult addStudentResult(StudentResult studentResult);

    public List<StudentResult> getAllStudent();

    public List<StudentResult> getResultByDepartment(String department,String year);

    public StudentResult getStudentResultByUsername(String studentUsername);
}
