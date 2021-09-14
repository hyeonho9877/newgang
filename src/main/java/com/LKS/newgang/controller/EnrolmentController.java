package com.LKS.newgang.controller;

import com.LKS.newgang.domain.Enrolment;
import com.LKS.newgang.service.EnrolmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EnrolmentController {
    private final EnrolmentService enrolmentService;

    @PostMapping("/enrolment")
    public List<Enrolment> enrolmentPage(Authentication authentication){
        String stdID = authentication.getName();
        return enrolmentService.getList(stdID);
    }

    @GetMapping("/enrolment/apply")
    public ResponseEntity<?> apply(@RequestParam(name = "lectureNo") String lectureNo, Authentication authentication){
        String stdID = authentication.getName();
        String result = enrolmentService.apply(stdID, lectureNo);
        if(result.equals("신청이 완료되었습니다."))
            return ResponseEntity.ok(result);
        else return ResponseEntity.badRequest().body(result);
    }
}
