package com.LKS.newgang.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
@Setter
@Getter
public class Lecture {
    @Id
    private int no; //과목번호
    private String classification; //구분
    private String lec_name; //과목이름
    private String time; // 교시
    private String professor; //교수
    @JoinColumn(name = "department")
    @ManyToOne
    private Department department; //학과
    private int grade; //학년
    private int max_grade; // n학년 인원중 초과인원
    private int max_other_grade; // n학년 인원이 아닌 사람중 초과된 인원
    private int max_transfer; // 초과된 편입생
    private int curr_grade; // 현재 신청 인원
    private int curr_other_grade; //n학년이 아닌사람중에 신청한사람
    private int curr_transfer; //


}
