package com.LKS.newgang.repository;

import com.LKS.newgang.domain.Department;
import com.LKS.newgang.domain.Major;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MajorRepository extends JpaRepository<Major,Integer> {
    List<Major> findByDepartment(Department department);
}
