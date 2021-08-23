package com.LKS.newgang.domain;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
public class Colleague {

    @Id
    @Column(name = "colleague_name", nullable = false)
    private String colleagueName;

    @JoinColumn(name = "campus_name")
    @ManyToOne
    private Campus campus;

    public Colleague(String colleagueName){
        this.colleagueName = colleagueName;
    }

    public Campus getCampus() {
        return campus;
    }

    public String getColleagueName() {
        return colleagueName;
    }
}
