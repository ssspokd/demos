package com.example.test.service;

import com.example.test.exception.RecordNotFoundException;
import com.example.test.model.Poll;
import com.example.test.repository.PollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PollService {

    @Autowired
    private PollRepository pollRepository;

    public PollService(PollRepository pollRepository) {
        this.pollRepository = pollRepository;
    }

    public List<Poll> getAllPoll() {
        return  pollRepository.findAll();
    }

    public Poll getPollById(long id) {
        return pollRepository.getOne(id);
    }

    public Poll createOrUpdateEmployee(Poll poll) {
        Optional<Poll>  entity = pollRepository.findById(poll.getId());
        if(entity.isPresent())
        {
            return poll;
        } else {
            return pollRepository.save(poll);
        }

    }

    public void createPoll(Poll poll){
        pollRepository.save(poll);
    }

    public void deletePollById(long id) throws RecordNotFoundException {
        Optional<Poll> pollOptional = pollRepository.findById(id);
        if(pollOptional.isPresent()){
            pollRepository.deleteById(id);
        }
        else
        {
            throw new RecordNotFoundException("No employee record exist for given id");
        }
    }

    public Page<Poll> getAllPollPagination(int page, int size) {
        Pageable pageable =  new QPageRequest(page,size);
        return pollRepository.findAll(pageable);
    }

}
