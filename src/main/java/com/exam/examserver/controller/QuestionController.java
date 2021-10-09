package com.exam.examserver.controller;

import com.exam.examserver.Service.QuestionService;
import com.exam.examserver.Service.QuizService;
import com.exam.examserver.entity.exam.Question;
import com.exam.examserver.entity.exam.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin("*")
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;
    @Autowired
    private QuizService quizService;
    // add question
    @PostMapping("/")
    public ResponseEntity<?> add(@RequestBody Question question){
        return ResponseEntity.ok(this.questionService.addQuestion(question));
    }

    // update question
    @PutMapping("/")
    public ResponseEntity<?> update(@RequestBody Question question){
        return ResponseEntity.ok(this.questionService.addQuestion(question));
    }

    // getAll questions
    @GetMapping("/")
    public ResponseEntity<?> getQuestions(){
        return ResponseEntity.ok(this.questionService.getQuestions());
    }

    // get a specific question
    @GetMapping("/{queId}")
    public Question getQuestion(@PathVariable("queId") Long queId){
        return this.questionService.getQuestion(queId);
    }
   // get all question of the quiz
    @GetMapping("/quiz/{qid}")
    public ResponseEntity<?> getQuestionOfQuiz(@PathVariable("qid") Long qid){

       Quiz quiz= this.quizService.getQuiz(qid);
       Set<Question> questions=quiz.getQuestions();
       List list= new ArrayList<>(questions);
       if(list.size()>Integer.parseInt(quiz.getNoOfQuestion())){
           list=list.subList(0,Integer.parseInt(quiz.getNoOfQuestion()+1));
       }
        Collections.shuffle(list);
       return ResponseEntity.ok(list);

   }
   // get all questions of the quiz
    @GetMapping("/quiz/all/{qid}")
    public ResponseEntity<?> getallQuestions(@PathVariable("qid") Long qid){
        Quiz quiz= new Quiz();
        quiz.setqId(qid);
        Set<Question>  questionsOfQuiz=this.questionService.getQuestionOdQuiz(quiz);
        return ResponseEntity.ok(questionsOfQuiz);
    }

  // delete question
    @DeleteMapping("/{queId}")
    public void delete(@PathVariable("queId") Long queId){
        this.questionService.deleteQuestion(queId);
    }
}
