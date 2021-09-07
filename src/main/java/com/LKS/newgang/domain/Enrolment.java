package com.LKS.newgang.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Optional;

@Entity
@Setter
@Getter
public class Enrolment {

    @Id
    @Column(name = "enr_no")
    private int no;

    @JoinColumn(name = "std_no")
    @ManyToOne
    private Student stdNo;

    @JoinColumn(name = "lec_no")
    @ManyToOne
    private Lecture lec_no;

    public Enrolment() {

    }

    public int getNo() {
        return no;
    }

    public Student getStdNo() {
        return stdNo;
    }

    public Lecture getLec_no() {
        return lec_no;
    }

    public Enrolment(Student student, Lecture lecture){
        this.stdNo = student;
        this.lec_no = lecture;
    }
}
