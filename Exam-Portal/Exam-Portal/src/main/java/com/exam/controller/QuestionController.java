package com.exam.controller;

import com.exam.model.exam.Question;
import com.exam.model.exam.Quiz;
import com.exam.service.QuestionService;
import com.exam.service.QuizService;
import org.apache.coyote.Response;
import org.hibernate.mapping.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/question")
@CrossOrigin("*")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @Autowired
    private QuizService quizService;

    @PostMapping("/")
    public ResponseEntity<Question> addQuestion(@RequestBody Question question){
        return  ResponseEntity.ok(this.questionService.addQuestion(question));
    }

    @GetMapping("/{quesId}")
    public Question getQuestion(@PathVariable("quesId") Long queId){
        return this.questionService.getSingleQuestion(queId);
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllQuestions(){
        return ResponseEntity.ok(this.questionService.getAllQuestions());
    }

    @PutMapping("/")
    public ResponseEntity<Question> updateQuestion(@RequestBody Question question){
        return ResponseEntity.ok(this.questionService.updateQuestion(question));
    }

    @DeleteMapping("/{queId}")
    public void deleteQuestion(@PathVariable("queId") Long queId){
        this.questionService.deleteQuestion(queId);
    }

    @GetMapping("/quiz/{qid}")
    public ResponseEntity<?> getQuestionsOfQuiz(@PathVariable("qid") Long qId){
//        Quiz quiz = new Quiz();
//        quiz.setQuizeId(qId);
//        Set<Question> questions = this.questionService.getQuestionsOfQuiz(quiz);
//        return ResponseEntity.ok(questions);

        // it will give us only
        Quiz quiz = this.quizService.getQuiz(qId);
        Set<Question> questions = quiz.getQuestions();
        List list = new ArrayList(questions);
        if(list.size()>Integer.parseInt(quiz.getNumberOfQuestions())){
           list = list.subList(0,Integer.parseInt(quiz.getNumberOfQuestions()+1));
        }
        Collections.shuffle(list);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/quiz/all/{qid}")
    public ResponseEntity<?> getQuestionsOfQuizAdmin(@PathVariable("qid") Long qId){
        Quiz quiz = new Quiz();
        quiz.setQuizId(qId);
        Set<Question> questions = this.questionService.getQuestionsOfQuiz(quiz);
        return ResponseEntity.ok(questions);
    }

    @PostMapping("/eval-quiz")
    public ResponseEntity<?> evaluateQuiz(@RequestBody List<Question> questions){
        double marksGot = 0;
        Integer correctAnswers = 0;
        Integer attemted = 0;
        for(Question q : questions){
            Question question = this.questionService.get(q.getQuesId());
            if(question.getAnswer().equals(q.getGivenAnswer())){
                // correct
                correctAnswers++;
                double markSingle = Double.parseDouble(questions.get(0).getQuiz().getMaxMark())/questions.size();
                marksGot += markSingle;
            }
            if(q.getGivenAnswer() != null){
                attemted++;
            }
        };
        Map<Object,Object> map = Map.of(
                "marksGot",marksGot,
                "correctAnswers",correctAnswers,
                    "attemted",attemted
        );
        return ResponseEntity.ok(map);
    }
}
