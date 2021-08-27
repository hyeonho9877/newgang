package com.LKS.newgang.repository;

import com.LKS.newgang.domain.Colleague;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColleagueRepository extends JpaRepository<Colleague, String> {

}
