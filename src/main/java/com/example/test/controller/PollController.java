package com.example.test.controller;


import com.example.test.exception.MyResourceNotFoundException;
import com.example.test.exception.RecordNotFoundException;
import com.example.test.model.Poll;
import com.example.test.service.PollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping(value={"/poll"})
public class PollController {

    @Autowired
    private PollService pollService;

    @GetMapping(produces = { "application/hal+json" })
    public  ResponseEntity<List<Poll>> getPoll() {
        ResponseEntity<List<Poll>> entity = new ResponseEntity<>(pollService.getAllPoll(), new HttpHeaders(), HttpStatus.OK);
        return entity;
    }

    @GetMapping(value = "/{findPagination}", produces = { "application/hal+json" }, params = { "page", "size" })
    public  ResponseEntity<List<Poll>> getPollWithPaggination(@RequestParam("page") int page,
                                                              @RequestParam("size") int size, UriComponentsBuilder uriBuilder,
                                                              HttpServletResponse response) throws MyResourceNotFoundException {
        Page<Poll> resultPage  =  pollService.getAllPollPagination(page,size);
        if (page > resultPage.getTotalPages()) {
            throw new MyResourceNotFoundException();
        }
        ResponseEntity<List<Poll>> entity = new ResponseEntity<>(resultPage.toList(), new HttpHeaders(), HttpStatus.OK);
        return entity;
    }

    @GetMapping(value = "/{id}" , produces = { "application/hal+json" })
    public ResponseEntity<Poll> getEmployeeById(@PathVariable("id") Long id)
            throws RecordNotFoundException {
        Poll entity = pollService.getPollById(id);
        return new ResponseEntity<>(entity, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deletePoll(@PathVariable("id") Long id)throws RecordNotFoundException{
        pollService.deletePollById(id);
        return HttpStatus.FORBIDDEN;
    }

    @PostMapping(value="/create",headers="Accept=application/json")
    public ResponseEntity<Poll> create(@RequestBody Poll poll)
            throws RecordNotFoundException {
        Poll updated = pollService.createOrUpdateEmployee(poll);
        return new ResponseEntity<>(updated, new HttpHeaders(), HttpStatus.OK);
    }


    @PutMapping(value="/update", headers="Accept=application/json")
    public ResponseEntity<String> updateUser(@RequestBody Poll currentPoll)
    {
        if (pollService.getPollById(currentPoll.getId())==null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        pollService.createOrUpdateEmployee(currentPoll);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
