package com.LKS.newgang.domain;

import javax.persistence.*;

@Entity
public class Campus {

    @Id
    @Column(name = "campus_name", nullable = false)
    private String campusName;

    public String getCampusName() {
        return campusName;
    }
}
