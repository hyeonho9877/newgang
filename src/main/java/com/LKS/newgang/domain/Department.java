package com.LKS.newgang.domain;

import javax.persistence.*;

@Entity
public class Department {

    @Id
    @Column(name = "department_name", nullable = false)
    private String departmentName;

    @JoinColumn(name = "colleague_name")
    @ManyToOne
    private Colleague colleague;

    public String getDepartmentName() {
        return departmentName;
    }

    public Colleague getColleague() {
        return colleague;
    }
}
