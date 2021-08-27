package com.LKS.newgang.repository;

import com.LKS.newgang.domain.Enrolment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnrolmentRepository extends JpaRepository<Enrolment, Integer> {

}
