package com.wipro.doconnectdiscussionservice.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.doconnectdiscussionservice.dto.AnswerDto;
import com.wipro.doconnectdiscussionservice.entity.Answer;
import com.wipro.doconnectdiscussionservice.service.AnswerService;

@RestController
@RequestMapping("/answers")
public class AnswerController {

    @Autowired
    private AnswerService answerService;

    @PostMapping("/save")
    public Answer saveAnswer(
            @RequestBody AnswerDto answerDto) {

        return answerService.saveAnswer(answerDto);
    }

    @GetMapping("/getAll")
    public List<Answer> getAllAnswers() {

        return answerService.getAllAnswers();
    }

    @GetMapping("/get/{answerId}")
    public Answer getAnswerById(
            @PathVariable Long answerId) {

        return answerService.getAnswerById(answerId);
    }

    @PutMapping("/update/{answerId}")
    public Answer updateAnswer(
            @PathVariable Long answerId,
            @RequestBody AnswerDto answerDto) {

        return answerService.updateAnswer(
                answerId,
                answerDto);
    }

    @DeleteMapping("/delete/{answerId}")
    public String deleteAnswer(
            @PathVariable Long answerId) {

        answerService.deleteAnswer(answerId);

        return "Answer Deleted Successfully";
    }
}
