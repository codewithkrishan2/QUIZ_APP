package com.kksg.question.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kksg.question.entities.Question;

public interface QuestionRepo extends JpaRepository<Question, Long> {

	List<Question> findByQuizId(Long quizId);
}
