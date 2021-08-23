package com.LKS.newgang.domain;

import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
public class Campus {

    @Id
    @Column(name = "campus_name", nullable = false)
    private String campusName;

    public String getCampusName() {
        return campusName;
    }
}
