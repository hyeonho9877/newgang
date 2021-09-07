package com.LKS.newgang.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Student {

    @Id
    @Column(name = "std_no", nullable = false)
    private int no;
    private String password;
    private String greatStudent;
    private int grade;
    private int semester;
    private boolean transfer;

    @JoinColumn(name = "campus_name")
    @ManyToOne
    private Campus campus;

    @JoinColumn(name = "colleague_name")
    @ManyToOne
    private Colleague colleague;

    @JoinColumn(name = "department_name")
    @ManyToOne
    private Department department;
    private String name;

    @JoinColumn(name="major_name")
    @ManyToOne
    private Major major;

    public Student(int stdNo){
        this.no = stdNo;
    }

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

    public Major getMajor() {
        return major;
    }
}