package com.example.test.controller;

import com.example.test.model.PollQuestion;
import com.example.test.service.PollQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.Produces;
import java.util.List;

@RestController
@RequestMapping(value={"/pollquestion"})
public class PollQuestionController {

    @Autowired
    private PollQuestionService pollQuestionService;

    @GetMapping
    @Produces("application/json")
    public ResponseEntity<List<PollQuestion>> getPoll() {
        return new ResponseEntity<>(pollQuestionService.getPollQuestionList(), new HttpHeaders(), HttpStatus.OK);
    }
}
