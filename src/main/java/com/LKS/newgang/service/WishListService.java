package com.LKS.newgang.service;

import com.LKS.newgang.domain.Lecture;
import com.LKS.newgang.domain.Student;
import com.LKS.newgang.domain.WishList;
import com.LKS.newgang.repository.WishListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class WishListService {

    private final WishListRepository wishListRepository;

    public boolean apply(String stdID, String lectureNo){
        try {
            wishListRepository.save(new WishList(new Student(Integer.parseInt(stdID)), new Lecture(Integer.parseInt(lectureNo))));
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public List<WishList> getList(String stdID){
        try {
            return wishListRepository.findByStdNoEquals(new Student(Integer.parseInt(stdID)));
        }catch (Exception e){
            return new ArrayList<>();
        }
    }
}
