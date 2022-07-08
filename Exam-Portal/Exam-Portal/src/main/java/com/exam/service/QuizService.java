package com.exam.service;

import com.exam.model.exam.Category;
import com.exam.model.exam.Question;
import com.exam.model.exam.Quiz;
import java.util.*;
public interface QuizService {
    public Quiz addQuiz(Quiz quiz);
    public Quiz updateQuiz(Quiz quiz);
    public Set<Quiz> getAllQuizzes();
    public Quiz getQuiz(Long quizId);
    public void deleteQuizById(Long quizId);

   public List<Quiz> getCategoryByDepartment(Category category);

   public List<Quiz> getQuizzesByDepartment(String department);

   public List<Quiz> getAllActiveQuizzes();

   public List<Quiz> getActiveQuizzesOfCategory(String department);

}
