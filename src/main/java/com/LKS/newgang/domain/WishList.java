package com.LKS.newgang.domain;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
public class WishList {

    @Id
    @Column(name = "wish_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int no;

    @JoinColumn(name = "std_no")
    @ManyToOne(cascade = CascadeType.ALL)
    private Student stdNo;

    @JoinColumn(name = "lec_no")
    @ManyToOne(cascade = CascadeType.ALL)
    private Lecture lecNo;

    public WishList(Student student, Lecture lecture){
        this.stdNo = student;
        this.lecNo = lecture;
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
}
