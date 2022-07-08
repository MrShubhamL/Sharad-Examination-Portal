package com.exam.service;

import com.exam.model.exam.Question;
import com.exam.model.exam.Quiz;

import java.util.*;
public interface QuestionService {
    public Question addQuestion(Question question);
    public Question updateQuestion(Question question);
    public Set<Question> getAllQuestions();
    public Question getSingleQuestion(Long queId);
    public void deleteQuestion(Long queId);
    public Set<Question> getQuestionsOfQuiz(Quiz quiz);

    public Question get(Long questionId);
}
