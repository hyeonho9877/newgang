package com.LKS.newgang.service;


import com.LKS.newgang.domain.Lecture;
import com.LKS.newgang.domain.Student;
import com.LKS.newgang.repository.SearchRepository;
import com.LKS.newgang.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
@RequiredArgsConstructor
public class SearchService {

    @Autowired
    private SearchRepository searchRepository;

    private final StudentRepository studentRepository;

    public List<Lecture> findByDepartment(String departmentName) {
        List<Lecture> lectures = new ArrayList<>();
        searchRepository.findByDepartment(departmentName).forEach(e -> lectures.add(e));
        return lectures;

    }

    public List<Lecture> findByDepartment() {
        return null;
    }

    public Optional<HashMap<String,String>> stdBelonging(String stdID) {
        HashMap<String, String> map = new HashMap<>();
        try {
            Optional<Student> byId = studentRepository.findById(Integer.parseInt(stdID));
            byId.ifPresent(std -> {
                map.put("campus", std.getCampus().getCampusName());
                map.put("colleague", std.getColleague().getColleagueName());
                map.put("department", std.getDepartment().getDepartmentName());
                Optional.ofNullable(std.getMajor())
                        .ifPresentOrElse(
                                major -> map.put("major", major.getMajorName()),
                                () -> map.put("major", ""));
            });

            if(map.isEmpty())
                return Optional.empty();
            else return Optional.of(map);

        }catch(Exception e){
            return Optional.empty();
        }

    }
}