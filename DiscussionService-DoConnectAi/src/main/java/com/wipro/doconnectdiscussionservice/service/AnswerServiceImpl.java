package com.wipro.doconnectdiscussionservice.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.doconnectdiscussionservice.dto.AnswerDto;
import com.wipro.doconnectdiscussionservice.entity.Answer;
import com.wipro.doconnectdiscussionservice.exceptions.AnswerNotFoundException;
import com.wipro.doconnectdiscussionservice.repository.AnswerRepository;

@Service
public class AnswerServiceImpl implements AnswerService {

    @Autowired
    private AnswerRepository answerRepository;

    @Override
    public Answer saveAnswer(AnswerDto answerDto) {

        Answer answer = new Answer();

        answer.setContent(answerDto.getContent());
        answer.setCreatedAt(LocalDateTime.now());

        return answerRepository.save(answer);
    }

    @Override
    public List<Answer> getAllAnswers() {

        return answerRepository.findAll();
    }

    @Override
    public Answer getAnswerById(Long answerId) {

        return answerRepository.findById(answerId)
                .orElseThrow(() ->
                        new AnswerNotFoundException(
                                "Answer not found with id : "
                                        + answerId));
    }

    @Override
    public Answer updateAnswer(Long answerId,
                               AnswerDto answerDto) {

        Answer answer = answerRepository.findById(answerId)
                .orElseThrow(() ->
                        new AnswerNotFoundException(
                                "Answer not found with id : "
                                        + answerId));

        answer.setContent(answerDto.getContent());

        return answerRepository.save(answer);
    }

    @Override
    public void deleteAnswer(Long answerId) {

        Answer answer = answerRepository.findById(answerId)
                .orElseThrow(() ->
                        new AnswerNotFoundException(
                                "Answer not found with id : "
                                        + answerId));

        answerRepository.delete(answer);
    }
}
