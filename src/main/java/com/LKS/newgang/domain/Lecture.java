package com.LKS.newgang.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Lecture {
    @Id
    private int no;
    private String classification;
    private String time;
    private String professor;
    @JoinColumn(name = "department")
    @ManyToOne
    private Department department;
    private int grade;
    private int max_grade;
    private int max_other_grade;
    private int max_transfer;
    private int curr_grade;
    private int curr_other_grade;
    private int curr_transfer;

    public int getNo() {
        return no;
    }

    public String getClassification() {
        return classification;
    }

    public String getTime() {
        return time;
    }

    public String getProfessor() {
        return professor;
    }

    public Department getDepartment() {
        return department;
    }

    public int getGrade() {
        return grade;
    }

    public int getMax_grade() {
        return max_grade;
    }

    public int getMax_other_grade() {
        return max_other_grade;
    }

    public int getMax_transfer() {
        return max_transfer;
    }

    public int getCurr_grade() {
        return curr_grade;
    }

    public int getCurr_other_grade() {
        return curr_other_grade;
    }

    public int getCurr_transfer() {
        return curr_transfer;
    }
}
