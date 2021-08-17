package com.LKS.newgang.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Colleague {

    @Id
    @Column(name = "colleague_name", nullable = false)
    private String colleagueName;

    public String getColleagueName() {
        return colleagueName;
    }
}
