package com.wipro.doconnectdiscussionservice.service;

import java.util.List;

import com.wipro.doconnectdiscussionservice.dto.AnswerDto;
import com.wipro.doconnectdiscussionservice.entity.Answer;

public interface AnswerService {

    Answer saveAnswer(AnswerDto answerDto);

    List<Answer> getAllAnswers();

    Answer getAnswerById(Long answerId);

    Answer updateAnswer(Long answerId,
                        AnswerDto answerDto);

    void deleteAnswer(Long answerId);
}
