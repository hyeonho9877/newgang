package com.LKS.newgang.domain;

import javax.persistence.*;

@Entity
public class Campus {

    @Id
    @Column(name = "campus_name", nullable = false)
    private String campusName;
    @JoinColumn(name = "colleagueName")
    @ManyToOne
    private Colleague colleagueName;

    public Colleague getColleagueName() {
        return colleagueName;
    }
    public String getCampusName() {
        return campusName;
    }
}
