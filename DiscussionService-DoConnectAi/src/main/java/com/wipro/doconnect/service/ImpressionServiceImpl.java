package com.wipro.doconnect.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.doconnect.dto.ImpressionDto;
import com.wipro.doconnect.entity.Answer;
import com.wipro.doconnect.entity.Impression;
import com.wipro.doconnect.entity.User;
import com.wipro.doconnect.exceptions.AnswerNotFoundException;
import com.wipro.doconnect.exceptions.UserNotFoundException;
import com.wipro.doconnect.repository.AnswerRepository;
import com.wipro.doconnect.repository.ImpressionRepository;
import com.wipro.doconnect.repository.UserRepository;

@Service
public class ImpressionServiceImpl implements ImpressionService {

	@Autowired
	private ImpressionRepository impressionRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AnswerRepository answerRepository;

	@Override
	public ImpressionDto saveImpression(ImpressionDto dto) {

		Impression impression = new Impression();
		impression.setType(dto.getType());

		User user = userRepository.findById(dto.getUserId())
				.orElseThrow(() -> new UserNotFoundException("User not found"));

		Answer answer = answerRepository.findById(dto.getAnswerId())
				.orElseThrow(() -> new AnswerNotFoundException("Answer not found"));

		impression.setUser(user);
		impression.setAnswer(answer);

		Impression saved = impressionRepository.save(impression);

		dto.setImpressionId(saved.getImpressionId());
		return dto;
	}
}