package com.LKS.newgang.domain;

import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
public class Colleague {

    @Id
    @Column(name = "colleague_name", nullable = false)
    private String colleagueName;
    @JoinColumn(name = "campus_name", nullable = false)
    @ManyToOne
    private Campus campus_name;

    public Campus getCampus_name() {
        return campus_name;
    }

    public String getColleagueName() {
        return colleagueName;
    }
}
