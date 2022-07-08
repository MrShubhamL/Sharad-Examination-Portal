package com.exam.controller;


import com.exam.model.exam.Category;
import com.exam.model.exam.Quiz;
import com.exam.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.crypto.spec.PSource;
import java.util.List;

@RestController
@RequestMapping("/quiz")
@CrossOrigin("*")
public class Quiz_Controller{

    @Autowired
    private QuizService quizService;

    // Add New Quiz
    @PostMapping("/")
    public ResponseEntity<Quiz> addQuiz(@RequestBody Quiz quiz){
        return ResponseEntity.ok(this.quizService.addQuiz(quiz));
    }

    // Get Single Quiz
    @GetMapping("/{quizId}")
    public Quiz getSingleQuiz(@PathVariable("quizId") Long quizId){
        return this.quizService.getQuiz(quizId);
    }

    //Get All Quizzes
    @GetMapping("/")
    public ResponseEntity<?> getAllQuiz(){
        return ResponseEntity.ok(this.quizService.getAllQuizzes());
    }

    // Update quiz
    @PutMapping("/")
    public Quiz updateQuiz(Quiz quiz){
       return this.quizService.updateQuiz(quiz);
    }

    //Delete Quiz
//    @DeleteMapping("/{quizId}")
//    public void deleteQuiz(@PathVariable("{quizId}") Long quizId){
//        this.quizService.deleteQuizById(quizId);
//    }

    @DeleteMapping("/{quizId}")
    public void deleteQuizById(@PathVariable("quizId") Long quizId){
        this.quizService.deleteQuizById(quizId);
    }

    @GetMapping("/category/{cid}")
    public List<Quiz> getQuizzesOfCategory(@PathVariable("cid") Long cid){
        Category category = new Category();
        category.setCid(cid);
        System.out.println("xxxxxxxxxxxxxxxxx" + category);
        return this.quizService.getCategoryByDepartment(category);
    }

    @GetMapping("/depart/{department}")
    public List<Quiz> getQuizzesOfDepartment(@PathVariable("department") String department){
        return this.quizService.getQuizzesByDepartment(department);
    }

    @GetMapping("/active")
    public List<Quiz> getActiveQuizzes(){
        return this.quizService.getAllActiveQuizzes();
    }

    @GetMapping("/category/active/{department}")
    public List<Quiz> getActiveQuizzesOfDepartment(@PathVariable("department") String department){
        return this.quizService.getActiveQuizzesOfCategory(department);
    }

}
