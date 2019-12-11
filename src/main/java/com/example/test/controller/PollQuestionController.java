package com.example.test.controller;

import com.example.test.model.PollQuestion;
import com.example.test.service.PollQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value={"/pollquestion"})
public class PollQuestionController {

    @Autowired
    private PollQuestionService pollQuestionService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PollQuestion> getPoll() {
        List<PollQuestion> pollQuestions =  pollQuestionService.getPollQuestionList();
        return pollQuestions;
    }
}
