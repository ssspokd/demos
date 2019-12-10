package com.example.test.repository;

import com.example.test.model.PollQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PollQuestionRepository extends JpaRepository<PollQuestion,Long>  {

}
