package com.kksg.quiz.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kksg.quiz.entities.Quiz;

public interface QuizRepo extends JpaRepository<Quiz, Long> {

}
