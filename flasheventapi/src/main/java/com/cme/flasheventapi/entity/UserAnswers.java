package com.cme.flasheventapi.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "user_answers")
public class UserAnswers {
    @Id
    private Long id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "answer_one")
    private String answerOne;

    @Column(name = "answer_two")
    private String answerTwo;

    @Column(name = "answer_three")
    private String answerThree;

    @Column(name = "submit_day")
    private Integer submitDay;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAnswerOne() {
        return answerOne;
    }

    public void setAnswerOne(String answerOne) {
        this.answerOne = answerOne;
    }

    public String getAnswerTwo() {
        return answerTwo;
    }

    public void setAnswerTwo(String answerTwo) {
        this.answerTwo = answerTwo;
    }

    public String getAnswerThree() {
        return answerThree;
    }

    public void setAnswerThree(String answerThree) {
        this.answerThree = answerThree;
    }

    public Integer getSubmitDay() {
        return submitDay;
    }

    public void setSubmitDay(Integer submitDay) {
        this.submitDay = submitDay;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
