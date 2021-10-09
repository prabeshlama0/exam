package com.exam.examserver.controller;

import com.exam.examserver.Service.QuizService;
import com.exam.examserver.entity.exam.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.Set;

@RestController
@RequestMapping("/quiz")
@CrossOrigin("*")
public class QuizController {
    @Autowired
    private QuizService quizService;


    // add quiz
    @PostMapping("/")
    public ResponseEntity<?> add(@RequestBody Quiz quiz){
        System.out.println("Data Saved in database");
        return ResponseEntity.ok(this.quizService.addQuiz(quiz));

    }
   // update Quiz

    @PutMapping("/")
    public ResponseEntity<Quiz> update(@RequestBody Quiz quiz){
        return ResponseEntity.ok(this.quizService.updateQuiz(quiz));
    }
    // get all quizes
    @GetMapping("/")
    public ResponseEntity<?>getAllQuizes(){
        return ResponseEntity.ok(this.quizService.getQuizes());
    }

    //get specific quiz
    @GetMapping("/{qId}")
    public Quiz quiz(@PathVariable("qId") Long qId){
        return quizService.getQuiz(qId);

    }
    // delete the quiz
    @DeleteMapping("/{qId}")
    public void delete(@PathVariable("qId") Long qId){
        this.quizService.deleteQuiz(qId);
    }
}
