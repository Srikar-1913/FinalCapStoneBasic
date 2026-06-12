package com.wipro.doconnectdiscussionservice.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.doconnectdiscussionservice.dto.QuestionDto;
import com.wipro.doconnectdiscussionservice.entity.Question;
import com.wipro.doconnectdiscussionservice.exceptions.QuestionNotFoundException;
import com.wipro.doconnectdiscussionservice.repository.QuestionRepository;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public Question saveQuestion(QuestionDto questionDto) {

        Question question = new Question();

        question.setTitle(questionDto.getTitle());
        question.setDescription(questionDto.getDescription());
        question.setCreatedAt(LocalDateTime.now());

        return questionRepository.save(question);
    }

    @Override
    public List<Question> getAllQuestions() {

        return questionRepository.findAll();
    }

    @Override
    public Question getQuestionById(Long questionId) {

        return questionRepository.findById(questionId)
                .orElseThrow(() ->
                        new QuestionNotFoundException(
                                "Question not found with id : "
                                        + questionId));
    }

    @Override
    public Question updateQuestion(Long questionId,
                                   QuestionDto questionDto) {

        Question question = questionRepository.findById(questionId)
                .orElseThrow(() ->
                        new QuestionNotFoundException(
                                "Question not found with id : "
                                        + questionId));

        question.setTitle(questionDto.getTitle());
        question.setDescription(questionDto.getDescription());

        return questionRepository.save(question);
    }

    @Override
    public void deleteQuestion(Long questionId) {

        Question question = questionRepository.findById(questionId)
                .orElseThrow(() ->
                        new QuestionNotFoundException(
                                "Question not found with id : "
                                        + questionId));

        questionRepository.delete(question);
    }
}
