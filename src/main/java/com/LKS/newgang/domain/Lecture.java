package com.LKS.newgang.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Getter
@NoArgsConstructor
public class Lecture {

    @Id
    @Column(name = "lec_no", nullable = false)
    private int no;
    private String lectureName;
    private String classification;
    private String time;
    private String professor;
    @JoinColumn(name = "department_name")
    @ManyToOne
    private Department department;
    private int grade;
    private int max_grade;
    private int max_other_grade;
    private int max_transfer;
    private int curr_grade;
    private int curr_other_grade;
    private int curr_transfer;

    public Lecture(int lectureNo){
        this.no=lectureNo;
    }
}
