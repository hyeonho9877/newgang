package com.LKS.newgang.controller;

import com.LKS.newgang.domain.*;
import com.LKS.newgang.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
public class SearchController {

    @Autowired
    SearchService searchService;

    @GetMapping("/search.dept")
    public String lectureListbyDept(@RequestParam String department_name, Model model) {
        List<Lecture> lectureList = searchService.findByDepartment(department_name);
        model.addAttribute("lectureList", lectureList);
        return null;
    }

    @GetMapping("/search.major")
    public String lectureListbyMajor(@RequestParam String major_name, Model model) {
        List<Lecture> lectureList = searchService.findByMajor(major_name);
        model.addAttribute("lectureList", lectureList);
        return null;
    }

    /**
     * 현재 로그인한 학생의 소속 정보를 반환하는 메소드
     * @param session 유저와 서버간의 세션
     * @return 학생의 소속 정보
     */
    @PostMapping("/search/getStudentBelonging")
    public ResponseEntity<?> getStdBelong(HttpSession session) {
        Optional<HashMap<String, String>> stdInfo = searchService.stdBelonging(String.valueOf(session.getAttribute("stdID")));

        final ResponseEntity<?>[] result = new ResponseEntity<?>[1];

        stdInfo.ifPresentOrElse(info -> {
            result[0] = ResponseEntity.ok(info);
        }, () -> result[0] = ResponseEntity.badRequest().build());

        return result[0];
    }

    @PostMapping("/colleagueList")
    public ResponseEntity<?> getColleagueList(@RequestBody HashMap<String,String> info){
        try {
            return ResponseEntity.ok(searchService.colleagueList(info));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }



    @PostMapping("/majorList")
    public ResponseEntity<?> getMajorList(@RequestBody HashMap<String,String> info){
        try {
            return ResponseEntity.ok(searchService.majorList(info));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }


    @PostMapping("/departmentList")
    public ResponseEntity<?> getDeptList(@RequestBody HashMap<String,String> info) {
        try {
            return ResponseEntity.ok(searchService.deptList(info));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
}