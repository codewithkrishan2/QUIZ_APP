package com.kksg.question.service;

import java.util.List;

import com.kksg.question.entities.Question;

public interface QuestionService {

	Question addQuestion(Question question);
	
	List<Question> getAllQuestions();
	
	Question getQuestion(Long questionId);
	
	
	List<Question> getQuestionByQuizId(Long quizId);
}
