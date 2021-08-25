package com.LKS.newgang.repository;

import com.LKS.newgang.domain.Student;
import com.LKS.newgang.domain.WishList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WishListRepository extends JpaRepository<WishList, Integer> {
    List<WishList> findByStdNoEquals(Student target);
}
