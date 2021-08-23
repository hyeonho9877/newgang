package com.LKS.newgang.service;


import com.LKS.newgang.domain.Campus;
import com.LKS.newgang.domain.Colleague;
import com.LKS.newgang.domain.Department;
import com.LKS.newgang.domain.Lecture;
import com.LKS.newgang.repository.LectureRepository;
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
    private LectureRepository lectureRepository;

    public List<Lecture> findByDepartment(String departmentName) {
        List<Lecture> lectures = new ArrayList<>();
        lectureRepository.findByDepartment(departmentName).forEach(e -> lectures.add(e));
        return lectures;

    }
}
