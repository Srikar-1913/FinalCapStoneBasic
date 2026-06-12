package com.wipro.doconnectdiscussionservice.service;

import java.util.List;

import com.wipro.doconnectdiscussionservice.dto.QuestionDto;
import com.wipro.doconnectdiscussionservice.entity.Question;

public interface QuestionService {

    Question saveQuestion(QuestionDto questionDto);

    List<Question> getAllQuestions();

    Question getQuestionById(Long questionId);

    Question updateQuestion(Long questionId,
                            QuestionDto questionDto);

    void deleteQuestion(Long questionId);
}
