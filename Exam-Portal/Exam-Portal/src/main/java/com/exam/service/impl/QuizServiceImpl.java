package com.exam.service.impl;

import com.exam.model.exam.Category;
import com.exam.model.exam.Quiz;
import com.exam.repo.QuizRepository;
import com.exam.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Service
public class QuizServiceImpl implements QuizService {

    @Autowired
    private QuizRepository quizRepository;

    @Override
    public Quiz addQuiz(Quiz quiz) {
        return this.quizRepository.save(quiz);
    }

    @Override
    public Quiz updateQuiz(Quiz quiz) {
        return this.quizRepository.save(quiz);
    }

    @Override
    public Set<Quiz> getAllQuizzes() {
        return new LinkedHashSet<>(this.quizRepository.findAll());
    }

    @Override
    public Quiz getQuiz(Long quizId) {
        return this.quizRepository.findById(quizId).get();
//    return null;
    }

    @Override
    public void deleteQuizById(Long quizId) {
        this.quizRepository.deleteById(quizId);
//        return null;
    }

    @Override
    public List<Quiz> getCategoryByDepartment(Category category) {
        return this.quizRepository.findByCategory(category);
    }

    @Override
    public List<Quiz> getQuizzesByDepartment(String department) {
        return this.quizRepository.findByDepartment(department);
    }

    @Override
    public List<Quiz> getAllActiveQuizzes() {
        return this.quizRepository.findByActive(true);
    }

    @Override
    public List<Quiz> getActiveQuizzesOfCategory(String department) {
        return this.quizRepository.findByDepartmentAndActive(department,true);
    }


}
