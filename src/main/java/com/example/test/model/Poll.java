package com.example.test.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;


@Entity
@Table(name = "poll")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Poll  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "namePoll", unique = true, nullable = false)
    private String name;
    @Column(name = "startDate")
    private Date startDate;
    @Column(name = "endDate")
    private Date stopDate;
    @Column(name = "isActive")
    private boolean isActive;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public PollQuestion getPollQuestion() {
        return pollQuestion;
    }

    public void setPollQuestion(PollQuestion pollQuestion) {
        this.pollQuestion = pollQuestion;
    }

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "pollQuestion", nullable = false)
    private PollQuestion pollQuestion;

    public Poll() {
    }

    public Poll(String name, Date startDate, Date stopDate, boolean isActive,PollQuestion pollQuestion) {
        this.name = name;
        this.startDate = startDate;
        this.stopDate = stopDate;
        this.isActive = isActive;
        this.pollQuestion = pollQuestion;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getStopDate() {
        return stopDate;
    }

    public void setStopDate(Date stopDate) {
        this.stopDate = stopDate;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
