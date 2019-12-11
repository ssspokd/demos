package com.example.test.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "poll")
public class Poll  implements Serializable {
    @Id
    @SequenceGenerator( name = "seqPoll", sequenceName = "seqPoll", allocationSize = 1, initialValue = 1 )
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "seqPoll")
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
    @OneToMany(mappedBy = "poll", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private List<PollQuestion> pollQuestions;

    public Poll() {
    }

    public Poll(Long id, String name, Date startDate, Date stopDate, boolean isActive, List<PollQuestion> pollQuestions) {
        this.name = name;
        this.startDate = startDate;
        this.stopDate = stopDate;
        this.isActive = isActive;
        this.pollQuestions = pollQuestions;
        this.id = id;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public List<PollQuestion> getPollQuestions() {
        return pollQuestions;
    }

    public void setPollQuestions(List<PollQuestion> pollQuestions) {
        this.pollQuestions = pollQuestions;
    }

}
