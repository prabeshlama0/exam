package com.exam.examserver.Service.Impl;

import com.exam.examserver.Service.QuizService;
import com.exam.examserver.entity.exam.Quiz;
import com.exam.examserver.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;
@Service
public class QuizServiceImpl implements QuizService {
     @Autowired
    private QuizRepository quizRepository;

     // to add the quiz
    @Override
    public Quiz addQuiz(Quiz quiz) {
        return this.quizRepository.save(quiz);
    }
// to update the quiz
    @Override
    public Quiz updateQuiz(Quiz quiz) {
        return this.quizRepository.save(quiz);
    }
// to get all the quiz
    @Override
    public Set<Quiz> getQuizes() {
        return new LinkedHashSet<>(this.quizRepository.findAll());
    }
// to get specific quiz
    @Override
    public Quiz getQuiz(Long qId) {
        return this.quizRepository.findById(qId).get();
    }
// delete quiz by id
    @Override
    public void deleteQuiz(Long qId) {
       this.quizRepository.deleteById(qId);
    }
}
