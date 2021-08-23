package com.LKS.newgang.repository;

import com.LKS.newgang.domain.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SearchRepository extends JpaRepository<Lecture, Long> {
    List<Lecture> findByDepartment(String departmentName);
}
