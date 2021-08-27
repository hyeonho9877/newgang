package com.LKS.newgang.repository;

import com.LKS.newgang.domain.Campus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampusRepository extends JpaRepository<Campus, String> {
}
