package com.LKS.newgang.domain;

import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
public class Enrolment {
    @Id
    @Column(name = "enr_no")
    private int no;

    @JoinColumn(name = "std_no")
    @ManyToOne
    private Student std_no;

    @JoinColumn(name = "lec_no")
    @ManyToOne
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
