package com.LKS.newgang.domain;

import javax.persistence.*;

@Entity
public class Student {
    @Id
    private int no;
    private String password;
    private String greatStudent;
    private int grade;
    private int semester;
    @JoinColumn(name = "campus")
    @ManyToOne
    private Campus campus;
    @JoinColumn(name = "colleague")
    @ManyToOne
    private Colleague colleague;
    @JoinColumn(name = "department")
    @ManyToOne
    private Department department;
    private String name;

    public String getPassword() {
        return password;
    }

    public String getGreatStudent() {
        return greatStudent;
    }

    public int getGrade() {
        return grade;
    }

    public int getSemester() {
        return semester;
    }

    public Campus getCampus() {
        return campus;
    }

    public Colleague getColleague() {
        return colleague;
    }

    public Department getDepartment() {
        return department;
    }

    public String getName() {
        return name;
    }


    public int getNo() {
        return no;
    }
}
