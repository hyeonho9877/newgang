package com.LKS.newgang.controller;

import com.LKS.newgang.domain.Department;
import com.LKS.newgang.domain.Lecture;
import com.LKS.newgang.domain.Major;
import com.LKS.newgang.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
public class SearchController {

    @Autowired
    SearchService searchService;

    @GetMapping("/search.dept")
    @PreAuthorize(value = "hasAuthority('course:read')")
    public String lectureListbyDept(@RequestParam Department department_name, Model model) {
        List<Lecture> lectureList = searchService.findByDepartment(department_name);
        model.addAttribute("lectureList", lectureList);
        return null;
    }

    @GetMapping("/search.major")
    @PreAuthorize(value = "hasAuthority('course:read')")
    public String lectureListbyMajor(@RequestParam Major major_name, Model model) {
        List<Lecture> lectureList = searchService.findByMajor(major_name);
        model.addAttribute("lectureList", lectureList);
        return null;
    }

    @PostMapping("/search/getStudentBelonging")
    @PreAuthorize(value = "hasAuthority('student:read')")
    public ResponseEntity<?> getStdBelong(Authentication authentication) {
        Optional<HashMap<String, String>> stdInfo = searchService.stdBelonging(authentication.getName());

        final ResponseEntity<?>[] result = new ResponseEntity<?>[1];

        stdInfo.ifPresentOrElse(info -> {
            result[0] = ResponseEntity.ok(info);
        }, () -> result[0] = ResponseEntity.badRequest().build());

        return result[0];
    }

    @PostMapping("/colleagueList")
    @PreAuthorize(value = "hasAuthority('course:read')")
    public ResponseEntity<?> getColleagueList(@RequestBody HashMap<String,String> info){
        try {
            return ResponseEntity.ok(searchService.colleagueList(info));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }



    @PostMapping("/majorList")
    @PreAuthorize(value = "hasAuthority('course:read')")
    public ResponseEntity<?> getMajorList(@RequestBody HashMap<String,String> info){
        try {
            return ResponseEntity.ok(searchService.majorList(info));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }


    @PostMapping("/departmentList")
    @PreAuthorize(value = "hasAuthority('course:read')")
    public ResponseEntity<?> getDeptList(@RequestBody HashMap<String,String> info) {
        try {
            return ResponseEntity.ok(searchService.deptList(info));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
}