package com.wipro.doconnect.service;

import java.time.LocalDateTime;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.doconnect.dto.QuestionDto;
import com.wipro.doconnect.entity.Question;
import com.wipro.doconnect.entity.User;
import com.wipro.doconnect.exceptions.QuestionNotFoundException;
import com.wipro.doconnect.exceptions.UserNotFoundException;
import com.wipro.doconnect.repository.QuestionRepository;
import com.wipro.doconnect.repository.UserRepository;

@Service
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	private QuestionRepository questionRepository;

	@Autowired
	private UserRepository userRepository;

	@Override
	public Question saveQuestion(QuestionDto questionDto) {

		Question question = new Question();

		question.setTitle(questionDto.getTitle());
		question.setDescription(questionDto.getDescription());
		question.setCreatedAt(LocalDateTime.now());

		User user = userRepository.findById(questionDto.getUserId())
				.orElseThrow(() -> new UserNotFoundException("User not found with id: " + questionDto.getUserId()));

		question.setUser(user);

		return questionRepository.save(question);
	}

	@Override
	public List<Question> getAllQuestions() {
		return questionRepository.findAll();
	}

	@Override
	public Question getQuestionById(Long questionId) {
		return questionRepository.findById(questionId)
				.orElseThrow(() -> new QuestionNotFoundException("Question not found with id: " + questionId));
	}

	@Override
	public Question updateQuestion(Long questionId, QuestionDto questionDto) {

		Question question = questionRepository.findById(questionId)
				.orElseThrow(() -> new QuestionNotFoundException("Question not found with id: " + questionId));

		question.setTitle(questionDto.getTitle());
		question.setDescription(questionDto.getDescription());

		// update user also (important improvement)
		if (questionDto.getUserId() != null) {
			User user = userRepository.findById(questionDto.getUserId())
					.orElseThrow(() -> new UserNotFoundException("User not found with id: " + questionDto.getUserId()));

			question.setUser(user);
		}

		return questionRepository.save(question);
	}

	@Override
	public void deleteQuestion(Long questionId) {

		Question question = questionRepository.findById(questionId)
				.orElseThrow(() -> new QuestionNotFoundException("Question not found with id: " + questionId));

		questionRepository.delete(question);
	}
}