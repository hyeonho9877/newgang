package com.LKS.newgang.repository;

import com.LKS.newgang.domain.Enrolment;
import com.LKS.newgang.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnrolmentRepository extends JpaRepository<Enrolment, Integer> {
    List<Enrolment> findByStdNoEquals(Student target);
}
