package com.LKS.newgang.repository;

import com.LKS.newgang.domain.Department;
import com.LKS.newgang.domain.Major;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MajorRepository extends JpaRepository<Major,Integer> {
    List<Major> findByDepartment(Department department);
    Optional<Major> findByDepartmentAndMajorName(Department department, String name);
}
