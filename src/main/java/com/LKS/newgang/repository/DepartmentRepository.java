package com.LKS.newgang.repository;

import com.LKS.newgang.domain.Colleague;
import com.LKS.newgang.domain.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
    List<Department> findByColleague(Colleague colleague);
    Optional<Department> findByColleagueAndDepartmentName(Colleague colleague, String departmentName);

}
