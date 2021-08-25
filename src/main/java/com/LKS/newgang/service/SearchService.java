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

    /**
     * 교과목 조회 시, 학생의 DB 정보를 바탕으로 소속 정보를 검색
     * @param stdID 조회할 학생의 학번
     * @return DB에 존재하는 학생의 소속 정보
     */
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