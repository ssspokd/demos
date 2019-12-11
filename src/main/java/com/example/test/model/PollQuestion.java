package com.example.test.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "pollquestion")
public class PollQuestion  implements Serializable {

    @Id
    @SequenceGenerator( name = "seqPollQuestions", sequenceName = "seqPollQuestions", allocationSize = 1, initialValue = 1 )
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "seqPollQuestions")
    @Column(name = "id")
    private long id;
    @Column(name="textpoll")
    private String textPoll;
    @Column(name="pubmissionorder")
    private int pubmissionorder;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="poll_id")
    @JsonBackReference
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Poll poll;

    public PollQuestion() {
    }

    public PollQuestion(String textPoll, int pubmissionorder, Poll poll) {
        this.textPoll = textPoll;
        this.pubmissionorder = pubmissionorder;
        this.poll = poll;
    }

    public PollQuestion(String textPoll, int pubmissionorder,Long id) {
        this.textPoll = textPoll;
        this.pubmissionorder = pubmissionorder;
        this.poll = poll;
        this.id = id;
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

    public int getPubmissionorder() {
        return pubmissionorder;
    }

    public void setPubmissionorder(int pubmissionorder) {
        this.pubmissionorder = pubmissionorder;
    }

    public Poll getPoll() {
        return poll;
    }

    public void setPoll(Poll poll) {
        this.poll = poll;
    }

    @Override
    public String toString() {
        return "PollQuestion{" +
                "  id=" + id +
                ", textPoll='" + textPoll + '\'' +
                ", pubmissionorder='" + pubmissionorder + '\'' +
                ", poll=" + poll +
                '}';
    }
}
