package com.LKS.newgang.domain;

import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
public class Campus {

    @Id
    @Column(name = "campus_name", nullable = false)
    private String campusName;

    public Campus(String campusName){this.campusName = campusName;}

    public String getCampusName() {
        return campusName;
    }
}
