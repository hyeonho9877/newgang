package com.LKS.newgang.service;


import com.LKS.newgang.domain.Lecture;
import com.LKS.newgang.repository.SearchRepository;
import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class SearchService {
    @Autowired
    private SearchRepository searchRepository;

    public List<Lecture> findByDepartment(String departmentName) {
        List<Lecture> lectures = new ArrayList<>();
        searchRepository.findByDepartment(departmentName).forEach(e -> lectures.add(e));
        return lectures;

    }

    public List<Lecture> findByDepartment() {

    }

    public List<Lecture> findByColleague() {

    }
}
