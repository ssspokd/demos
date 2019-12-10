package com.example.test.service;


import com.example.test.model.PollQuestion;
import com.example.test.repository.PollQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PollQuestionService {

    @Autowired
    PollQuestionRepository pollQuestionRepository;

    public PollQuestionService(PollQuestionRepository pollQuestionRepository){
        this.pollQuestionRepository = pollQuestionRepository;
    }

    public List<PollQuestion> getPollQuestionList(){
        List<PollQuestion> pollQuestions = pollQuestionRepository.findAll();
        return  pollQuestions;
    }
}
