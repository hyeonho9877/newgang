package com.LKS.newgang.domain;

import javax.persistence.*;

@Entity
public class Department {

    @Id
    @Column(name = "department_name", nullable = false)
    private String departmentName;

    public String getDepartmentName() {
        return departmentName;
    }
}
