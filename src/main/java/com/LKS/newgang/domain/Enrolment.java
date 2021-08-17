package com.LKS.newgang.domain;

import javax.persistence.*;

@Entity
public class Enrolment {
    @Id
    private int no;
    @JoinColumn(name = "std_no")
    @ManyToMany
    private Student std_no;
    @JoinColumn
    @ManyToMany
    private Lecture lec_no;

    public int getNo() {
        return no;
    }

    public Student getStd_no() {
        return std_no;
    }

    public Lecture getLec_no() {
        return lec_no;
    }
}
