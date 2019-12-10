package com.example.test.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "pollquestion")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class PollQuestion  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name="textpoll")
    private String textPoll;
    @Column(name="pubmissionorder")
    private String pubmissionorder;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="poll_id")
    private Poll poll;

    public PollQuestion() {
    }

    public PollQuestion(String textPoll, String pubmissionorder, Poll poll) {
        this.textPoll = textPoll;
        this.pubmissionorder = pubmissionorder;
        this.poll = poll;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTextPoll() {
        return textPoll;
    }

    public void setTextPoll(String textPoll) {
        this.textPoll = textPoll;
    }

    public String getPubmissionorder() {
        return pubmissionorder;
    }

    public void setPubmissionorder(String pubmissionorder) {
        this.pubmissionorder = pubmissionorder;
    }

    public Poll getPoll() {
        return poll;
    }

    public void setPoll(Poll poll) {
        this.poll = poll;
    }
}
