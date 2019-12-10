package com.example.test.service;

import com.example.test.repository.PollRepository;

import java.util.List;

import com.example.test.model.Poll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PollService {

    @Autowired
    PollRepository pollRepository;

    public PollService(PollRepository pollRepository) {
        this.pollRepository = pollRepository;
    }

    public List<Poll> getAllPoll() {
        return pollRepository.findAll();
    }

    public Poll getPollById(long id) {
        return pollRepository.getOne(id);
    }
}
