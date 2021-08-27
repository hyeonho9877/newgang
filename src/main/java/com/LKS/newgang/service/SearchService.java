package com.LKS.newgang.service;


import com.LKS.newgang.domain.*;
import com.LKS.newgang.repository.*;
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
    private final SearchRepository searchRepository;
    private final StudentRepository studentRepository;
    private final CampusRepository campusRepository;
    private final ColleagueRepository colleagueRepository;
    private final DepartmentRepository departmentRepository;
    private final MajorRepository majorRepository;

    public List<Lecture> findByDepartment(String department) {
        return searchRepository.findByDepartment(department);
    }

    public List<Lecture> findByMajor(String major) {
        return searchRepository.findByMajor(major);
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

    public List<HashMap<String, ArrayList<String>>> getCampusInfo(){
        List<Campus> campusList = campusRepository.findAll();
        List<Colleague> colleagueList = colleagueRepository.findAll();
        List<Department> departmentList = departmentRepository.findAll();
        List<Major> majorList = majorRepository.findAll();

        HashMap<String, ArrayList<String>> campusMap = new HashMap<>();
        HashMap<String, ArrayList<String>> colleagueMap = new HashMap<>();
        HashMap<String, ArrayList<String>> departmentMap = new HashMap<>();

        for(Campus campus : campusList){
            campusMap.put(campus.getCampusName(),new ArrayList<>());
        }

        for(Colleague colleague : colleagueList){
            campusMap.get(colleague.getCampus().getCampusName()).add(colleague.getColleagueName());
            colleagueMap.put(colleague.getColleagueName(),new ArrayList<>());
        }

        for(Department department : departmentList){
            colleagueMap.get(department.getColleague().getColleagueName()).add(department.getDepartmentName());
            departmentMap.put(department.getDepartmentName(), new ArrayList<>());
        }

        for (Major major : majorList) {
            departmentMap.get(major.getDepartment().getDepartmentName()).add(major.getMajorName());
        }

        return List.of(campusMap, colleagueMap, departmentMap);
    }
}