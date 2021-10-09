package com.exam.examserver.Service;

import com.exam.examserver.entity.exam.Question;
import com.exam.examserver.entity.exam.Quiz;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public interface QuestionService {
    // add
    public Question addQuestion(Question question);

    // update
    public Question updateQuestion(Question question);

    // get all question
    public Set<Question> getQuestions();

    // get Specific Question
    public Question getQuestion(Long qId);

    //get specific questions of the quiz
    public Set<Question> getQuestionOdQuiz(Quiz quiz);

    // delete question
    public void deleteQuestion(Long quesId);
}