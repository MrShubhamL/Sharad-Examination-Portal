package com.exam.controller;

import com.exam.model.result.StudentResult;
import com.exam.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/result")
@CrossOrigin("*")
public class ResultController {
    @Autowired
    private ResultService resultService;

    @PostMapping("/")
    public ResponseEntity<StudentResult>  addResult(@RequestBody StudentResult studentResult){
        return ResponseEntity.ok(this.resultService.addStudentResult(studentResult));
    }

    @GetMapping("/student-result")
    public List<StudentResult> getAllResult(){
        return this.resultService.getAllStudent();
    }

    @GetMapping("/student-result/{department}/{year}")
    public List<StudentResult> getResultByDepartment(@PathVariable("department") String department,
                                                     @PathVariable("year") String year){
        return this.resultService.getResultByDepartment(department,year);
    }

    @GetMapping("/student-result/{studentUsername}")
    public  StudentResult getResultByUsername(@PathVariable("studentUsername") String studentUsername){
        return this.resultService.getStudentResultByUsername(studentUsername);
    }


}
