package com.exam.examserver.Service.Impl;

import com.exam.examserver.Service.QuestionService;
import com.exam.examserver.entity.exam.Question;
import com.exam.examserver.entity.exam.Quiz;
import com.exam.examserver.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;
@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public Question addQuestion(Question question) {
        return this.questionRepository.save(question);
    }

    @Override
    public Question updateQuestion(Question question) {
        return this.questionRepository.save(question);
    }

    @Override
    public Set<Question> getQuestions() {
        return new LinkedHashSet<>(this.questionRepository.findAll());
    }

    @Override
    public Question getQuestion(Long qId) {
        return this.questionRepository.findById(qId).get();
    }

    @Override
    public Set<Question> getQuestionOdQuiz(Quiz quiz) {
        return this.questionRepository.findByQuiz(quiz);
    }

    @Override
    public void deleteQuestion(Long quesId) {
        Question question = new Question();
        question.setQuesId(quesId);
        this.questionRepository.delete(question);
    }
}
