package com.example.test.controller;


import com.example.test.exception.RecordNotFoundException;
import com.example.test.model.Poll;
import com.example.test.service.PollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Produces;
import java.util.List;

@RestController
@RequestMapping(value={"/poll"})
public class PollController {

    @Autowired
    private PollService pollService;

    @GetMapping
    @Produces("application/json")
    public ResponseEntity<List<Poll>> getPoll() {
        return new ResponseEntity<>(pollService.getAllPoll(), new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Produces("application/json")
    public ResponseEntity<Poll> getEmployeeById(@PathVariable("id") Long id)
            throws RecordNotFoundException {
        Poll entity = pollService.getPollById(id);

        return new ResponseEntity<Poll>(entity, new HttpHeaders(), HttpStatus.OK);
    }

}
