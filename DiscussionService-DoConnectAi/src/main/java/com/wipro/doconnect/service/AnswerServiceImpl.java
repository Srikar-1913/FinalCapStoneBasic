package com.wipro.doconnect.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.doconnect.dto.AnswerDto;
import com.wipro.doconnect.entity.Answer;
import com.wipro.doconnect.entity.Question;
import com.wipro.doconnect.entity.User;
import com.wipro.doconnect.exceptions.AnswerNotFoundException;
import com.wipro.doconnect.exceptions.QuestionNotFoundException;
import com.wipro.doconnect.exceptions.UserNotFoundException;
import com.wipro.doconnect.repository.AnswerRepository;
import com.wipro.doconnect.repository.QuestionRepository;
import com.wipro.doconnect.repository.UserRepository;

@Service
public class AnswerServiceImpl implements AnswerService {

	@Autowired
	private AnswerRepository answerRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private QuestionRepository questionRepository;

	@Override
	public Answer saveAnswer(AnswerDto answerDto) {

		Answer answer = new Answer();

		answer.setContent(answerDto.getContent());
		answer.setCreatedAt(LocalDateTime.now());

		User user = userRepository.findById(answerDto.getUserId())
				.orElseThrow(() -> new UserNotFoundException("User not found"));

		Question question = questionRepository.findById(answerDto.getQuestionId())
				.orElseThrow(() -> new QuestionNotFoundException("Question not found"));

		answer.setUser(user);
		answer.setQuestion(question);

		return answerRepository.save(answer);
	}

	@Override
	public List<Answer> getAllAnswers() {
		return answerRepository.findAll();
	}

	@Override
	public Answer getAnswerById(Long answerId) {
		return answerRepository.findById(answerId)
				.orElseThrow(() -> new AnswerNotFoundException("Answer not found with id : " + answerId));
	}

	@Override
	public Answer updateAnswer(Long answerId, AnswerDto answerDto) {

		Answer answer = answerRepository.findById(answerId)
				.orElseThrow(() -> new AnswerNotFoundException("Answer not found with id : " + answerId));

		answer.setContent(answerDto.getContent());

		return answerRepository.save(answer);
	}

	@Override
	public void deleteAnswer(Long answerId) {

		Answer answer = answerRepository.findById(answerId)
				.orElseThrow(() -> new AnswerNotFoundException("Answer not found with id : " + answerId));

		answerRepository.delete(answer);
	}
}