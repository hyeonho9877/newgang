package com.LKS.newgang.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Major {

    @Id
    @Column(name = "major_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int no;

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
