package com.LKS.newgang.repository;

import com.LKS.newgang.domain.Campus;
import com.LKS.newgang.domain.Colleague;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ColleagueRepository extends JpaRepository<Colleague, Integer> {
    List<Colleague> findByCampus(Campus campus);

    Optional<Colleague> findByCampusAndColleagueName(Campus campus, String colleagueName);
}
