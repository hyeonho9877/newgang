package com.LKS.newgang.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
public class Enrolment {

    @Id
    @Column(name = "enr_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int no;

    @JoinColumn(name = "std_no")
    @ManyToOne
    private Student stdNo;

    @JoinColumn(name = "lec_no")
    @ManyToOne
    private Lecture lecNo;

    public Enrolment() {

    }

    public int getNo() {
        return no;
    }

    public Student getStdNo() {
        return stdNo;
    }

    public Lecture getLecNo() {
        return lecNo;
    }

    public Enrolment(Student student, Lecture lecture){
        this.stdNo = student;
        this.lecNo = lecture;
    }
}
