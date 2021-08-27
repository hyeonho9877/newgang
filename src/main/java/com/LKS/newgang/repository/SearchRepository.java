package com.LKS.newgang.repository;

import com.LKS.newgang.domain.Department;
import com.LKS.newgang.domain.Lecture;
import com.LKS.newgang.domain.Student;
import com.LKS.newgang.domain.Major;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;
import java.util.Optional;

public interface SearchRepository extends JpaRepository<Lecture,Integer> {

    @Query("select l from Lecture l where l.department.departmentName =: department")
    List<Lecture> findByDepartment(@Param("department") String department);
    /*public List<Lecture> findByDepartment(String department) {
        List<Lecture> lectureList = (List<Lecture>) em.createQuery("select l from Lecture l where l.department.departmentName =: department", Lecture.class)
                .setParameter("department", department)
                .getResultList();
        return lectureList;
    }*/

    @Query("select l from Lecture l where l.major.majorName =: major")
    List<Lecture> findByMajor(@Param("major") String major);
    /*public List<Lecture> findByMajor(String major) {
        List<Lecture> lectureList = (List<Lecture>) em.createQuery("select l from Lecture l where l.major.majorName =: major", Lecture.class)
                .setParameter("major", major)
                .getResultList();
        return lectureList;
    }*/

}
