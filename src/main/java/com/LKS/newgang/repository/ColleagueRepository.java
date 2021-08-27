package com.LKS.newgang.repository;

import com.LKS.newgang.domain.Colleague;
import com.LKS.newgang.domain.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ColleagueRepository extends JpaRepository<Colleague, String> {

}
