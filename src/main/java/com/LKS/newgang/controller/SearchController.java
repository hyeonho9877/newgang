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

    /**
     * 로그인한 학생의 소속 정보 전송
     * @param authentication 로그인한 학생의 정보
     * @return 학생의 소속 정보
     */
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

    /**
     * 선택된 캠퍼스를 기반으로 소속된 대학 정보 전송
     * @param info DB 검색에 필요한 정보
     * @return 대학 정보
     */
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


    /**
     * 선택된 캠퍼스, 대학, 학과를 기반으로 해당되는 전공 정보 전송
     * @param info DB 검색에 필요한 정보
     * @return 전공 정보
     */
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

    /**
     * 선택된 캠퍼스, 대학을 기반으로 해당되는 학과 정보를 전송
     * @param info DB 검색에 필요한 정보
     * @return 학과 정보
     */
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