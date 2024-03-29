package com.kksg.quiz.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kksg.quiz.entities.Quiz;
import com.kksg.quiz.repos.QuizRepo;
import com.kksg.quiz.services.QuestionClient;
import com.kksg.quiz.services.QuizService;

@Service
public class QuizServiceImpl implements QuizService {

	@Autowired
	private QuizRepo quizRepo;
	
	@Autowired
	private QuestionClient questionClient;
	
	
	public QuizServiceImpl() {
		
	}
	
	
	public QuizServiceImpl(QuizRepo quizRepo, QuestionClient questionClient) {
		this.quizRepo = quizRepo;
		this.questionClient = questionClient;
	}


	@Override
	public Quiz addQuiz(Quiz quiz) {
		return this.quizRepo.save(quiz);
		
	}

	@Override
	public List<Quiz> getAllQuizzes() {
		List<Quiz> quizzes = this.quizRepo.findAll();
		List<Quiz> quizList = quizzes.stream().map(quiz -> {
			quiz.setQuestions(questionClient.getQuestionsOfQuiz(quiz.getId())); 
			return quiz;
			}).collect(Collectors.toList());
		return quizList;
	}

	@Override
	public Quiz getQuiz(Long quizId) {
		
		Quiz quiz = this.quizRepo.findById(quizId).orElseThrow(()-> new RuntimeException("Quiz not found"));
		
		quiz.setQuestions(questionClient.getQuestionsOfQuiz(quiz.getId()));
		
		return quiz;
	}

}
