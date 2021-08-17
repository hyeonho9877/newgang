package com.LKS.newgang.domain;

import javax.persistence.*;

@Entity
public class Colleague {

    @Id
    @Column(name = "colleague_name", nullable = false)
    private String colleagueName;
    @JoinColumn(name = "campus_name")
    @ManyToOne
    private Campus campus;

    public String getColleagueName() {
        return colleagueName;
    }

    public Campus getCampus() {
        return campus;
    }
}
