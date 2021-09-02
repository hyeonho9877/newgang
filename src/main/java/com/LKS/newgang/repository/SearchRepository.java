package com.LKS.newgang.repository;

import com.LKS.newgang.domain.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

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
