package com.LKS.newgang.repository;

import com.LKS.newgang.domain.Department;
import com.LKS.newgang.domain.Lecture;
import com.LKS.newgang.domain.Major;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SearchRepository extends JpaRepository<Lecture,Integer> {

    List<Lecture> findByDepartment(Department department);
    List<Lecture> findByMajor(Major major);
    /*@Query("select l from Lecture l where l.department.departmentName =: department")
    List<Lecture> findByDepartment(@Param("department") String department);


    @Query("select l from Lecture l where l.major.majorName =: major")
    List<Lecture> findByMajor(@Param("major") String major);*/


}
