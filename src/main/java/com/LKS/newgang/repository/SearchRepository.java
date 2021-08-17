package com.LKS.newgang.repository;

import com.LKS.newgang.domain.Lecture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SearchRepository extends JpaRepository<Lecture, Long> {

    public List<Lecture> findByCampus(String campusName);

    public List<Lecture> findByDepartment(String departmentName);

    public List<Lecture> findByColleague(String ColleagueName);
}
