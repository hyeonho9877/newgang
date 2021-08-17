package com.LKS.newgang.domain;

import javax.persistence.*;

@Entity
public class Major {
    @Id
    @Column(name = "major_name", nullable = false)
    private String majorName;
    @JoinColumn(name="department_name")
    @ManyToOne
    private Department department;

    public String getMajorName() {
        return majorName;
    }

    public Department getDepartment() {
        return department;
    }
}
