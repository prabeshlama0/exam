package com.exam.examserver.Service;

import com.exam.examserver.entity.exam.Quiz;

import java.util.Set;

public interface QuizService {
    public Quiz addQuiz(Quiz quiz);
    public Quiz updateQuiz(Quiz quiz);
    public Set<Quiz> getQuizes();
    public Quiz getQuiz(Long qId);
    public void deleteQuiz(Long qId);

}
