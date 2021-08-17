package com.LKS.newgang.repository;

import com.LKS.newgang.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<Student,Integer>{
}
