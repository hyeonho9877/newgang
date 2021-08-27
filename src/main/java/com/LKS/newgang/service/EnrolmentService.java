package com.LKS.newgang.service;

import com.LKS.newgang.domain.Department;
import com.LKS.newgang.domain.Enrolment;
import com.LKS.newgang.domain.Lecture;
import com.LKS.newgang.domain.Student;
import com.LKS.newgang.repository.EnrolmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class EnrolmentService {

    @Autowired
    EnrolmentRepository er;
    public void enroll(Lecture lc, Student std) {
        Enrolment enrolment = new Enrolment();
        enrolment.setLec_no(lc);
        enrolment.setStd_no(std);
        er.save(enrolment);
    }
}
