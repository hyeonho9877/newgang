package com.LKS.newgang.domain;

import javax.persistence.*;

@Entity
public class Colleague {

    @Id
    @Column(name = "colleague_name", nullable = false)
    private String colleagueName;
    @JoinColumn(name = "departmentName")
    @ManyToOne
    private Department departmentName;

    public Department getDepartmentName() {
        return departmentName;
    }

    public String getColleagueName() {
        return colleagueName;
    }
}
