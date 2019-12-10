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
    @Column(name = "idpoll")
    private Long idpoll;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "pollQuestion")
    private Set<Poll> poll;

    public PollQuestion(String textPoll, String pubmissionorder, Long idpoll, Set<Poll> poll) {
        this.textPoll = textPoll;
        this.pubmissionorder = pubmissionorder;
        this.idpoll = idpoll;
        this.poll = poll;
    }

    public PollQuestion() {
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

    public Long getIdpoll() {
        return idpoll;
    }

    public void setIdpoll(Long idpoll) {
        this.idpoll = idpoll;
    }


    @Override
    public String toString() {
        return "PollQuestion{" +
                "textPoll='" + textPoll + '\'' +
                ", pubmissionorder='" + pubmissionorder + '\'' +
                ", idpoll=" + idpoll +
                '}';
    }
}
