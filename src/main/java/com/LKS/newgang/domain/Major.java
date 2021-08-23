package com.LKS.newgang.domain;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
public class Major {
    @Id
    @Column(name = "major_name", nullable = false)
    private String majorName;
    @JoinColumn(name="department_name")
    @ManyToOne
    private Department department;

    public Major(String majorName){
        this.majorName = majorName;
    }

    public String getMajorName() {
        return majorName;
    }

    public Department getDepartment() {
        return department;
    }
}
