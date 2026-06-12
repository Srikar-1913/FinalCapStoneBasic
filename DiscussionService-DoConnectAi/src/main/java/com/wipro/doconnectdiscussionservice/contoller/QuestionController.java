package com.wipro.doconnectdiscussionservice.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.wipro.doconnectdiscussionservice.dto.QuestionDto;
import com.wipro.doconnectdiscussionservice.entity.Question;
import com.wipro.doconnectdiscussionservice.service.QuestionService;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @PostMapping("/save")
    public Question saveQuestion(
            @RequestBody QuestionDto questionDto) {

        return questionService.saveQuestion(questionDto);
    }

    @GetMapping("/getAll")
    public List<Question> getAllQuestions() {

        return questionService.getAllQuestions();
    }

    @GetMapping("/get/{questionId}")
    public Question getQuestionById(
            @PathVariable Long questionId) {

        return questionService.getQuestionById(questionId);
    }

    @PutMapping("/update/{questionId}")
    public Question updateQuestion(
            @PathVariable Long questionId,
            @RequestBody QuestionDto questionDto) {

        return questionService.updateQuestion(
                questionId,
                questionDto);
    }

    @DeleteMapping("/delete/{questionId}")
    public String deleteQuestion(
            @PathVariable Long questionId) {

        questionService.deleteQuestion(questionId);

        return "Question Deleted Successfully";
    }
}
