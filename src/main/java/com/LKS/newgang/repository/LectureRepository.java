package com.LKS.newgang.repository;

import com.LKS.newgang.domain.Department;
import com.LKS.newgang.domain.Lecture;
import com.LKS.newgang.domain.Major;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LectureRepository extends JpaRepository<Lecture,Integer> {
    List<Lecture> findByDepartment(Department department);

    List<Lecture> findByMajor(Major major);
}
