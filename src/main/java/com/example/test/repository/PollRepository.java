package com.example.test.repository;

import com.example.test.model.Poll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public  interface PollRepository  extends JpaRepository<Poll,Long>
{


}