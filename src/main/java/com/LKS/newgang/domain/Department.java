package com.LKS.newgang.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity
public class Department {

    @Id
    @Column(name = "department_name", nullable = false)
    private String departmentName;

    public String getDepartmentName() {
        return departmentName;
    }
}
