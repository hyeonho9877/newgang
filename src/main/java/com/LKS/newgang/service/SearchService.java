package com.LKS.newgang.service;


import com.LKS.newgang.domain.*;
import com.LKS.newgang.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Transactional
@Service
@RequiredArgsConstructor
public class SearchService {

    @Autowired
    private final StudentRepository studentRepository;
    private final CampusRepository campusRepository;
    private final ColleagueRepository colleagueRepository;
    private final DepartmentRepository departmentRepository;
    private final MajorRepository majorRepository;
    private final LectureRepository lectureRepository;

    public List<Lecture> findByDepartment(String campus, String colleague, String department) {
        Campus targetCampus = campusRepository.findById(campus).orElseThrow();
        Colleague targetColleague = colleagueRepository.findByCampusAndColleagueName(targetCampus, colleague).orElseThrow();
        Department targetDept = departmentRepository.findByColleagueAndDepartmentName(targetColleague, department).orElseThrow();

        return lectureRepository.findByDepartment(targetDept);
    }

    public List<Lecture> findByMajor(String campus, String colleague, String department, String major) {
        Campus targetCampus = campusRepository.findById(campus).orElseThrow();
        Colleague targetColleague = colleagueRepository.findByCampusAndColleagueName(targetCampus, colleague).orElseThrow();
        Department targetDept = departmentRepository.findByColleagueAndDepartmentName(targetColleague, department).orElseThrow();
        Major targetMajor = majorRepository.findByDepartmentAndMajorName(targetDept, major).orElseThrow();

        return lectureRepository.findByMajor(targetMajor);
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

    public List<String> colleagueList(HashMap<String, String> info){
        Campus campus = campusRepository.findById(info.get("campus")).orElseThrow();
        List<String> result = colleagueRepository.findByCampus(campus).stream().map(Colleague::getColleagueName).collect(Collectors.toList());
        return result;
    }

    public List<String> deptList(HashMap<String, String> info) {
        Campus campus = new Campus(info.get("campus"));
        Colleague colleague = colleagueRepository.findByCampusAndColleagueName(campus,info.get("colleague")).orElseThrow();
        List<String> result = departmentRepository.findByColleague(colleague).stream().map(Department::getDepartmentName).collect(Collectors.toList());
        return result;
    }

    public List<String> majorList(HashMap<String, String> info) {
        Campus campus = new Campus(info.get("campus"));
        Colleague colleague = colleagueRepository.findByCampusAndColleagueName(campus, info.get("colleague")).orElseThrow();

        Department department = departmentRepository.findByColleagueAndDepartmentName(colleague, info.get("department")).orElseThrow();
        List<String> result = majorRepository.findByDepartment(department).stream().map(Major::getMajorName).collect(Collectors.toList());
        return result;
    }
}