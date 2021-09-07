package com.LKS.newgang.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Getter
@NoArgsConstructor
@Setter
public class Lecture {

    @Id
    @Column(name = "lec_no", nullable = false)
    private int no;
    private String lectureName;
    private String classification;
    private String time;
    private String professor;
    @JoinColumn(name = "department_name")
    @ManyToOne
    private Department department;
    @JoinColumn(name = "major_name")
    @ManyToOne
    private Major major;
    private int grade; //학년
    private int max_grade; // 현재학년중 최대 인원
    private int max_other_grade; //현재 학년이 아닌 학년중 최대 인원
    private int max_transfer;
    private int curr_grade; // 현재 학년중 신청한 인원
    private int curr_other_grade;
    private int curr_transfer;

    public Lecture(int lectureNo){
        this.no=lectureNo;
    }
}
