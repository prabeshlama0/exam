package com.exam.examserver.repository;

import com.exam.examserver.entity.exam.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
}
