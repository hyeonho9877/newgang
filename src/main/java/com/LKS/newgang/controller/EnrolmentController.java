package com.LKS.newgang.controller;

import com.LKS.newgang.domain.Enrolment;
import com.LKS.newgang.service.EnrolmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class EnrolmentController {
    private final EnrolmentService enrolmentService;

    @PostMapping("/enrolment")
    public List<Enrolment> enrolmentPage(HttpSession session){
        String stdID = String.valueOf(session.getAttribute("stdID"));
        return enrolmentService.getList(stdID);
    }

    /**
     * 소망가방 담기 신청
     * @param lectureNo 신청하려는 강의의 강의번호
     * @param session 유저와 서버간의 세션
     * @return 성공적으로 신청이 완료되면 ResponseEntity.ok(), 실패 시에는 badRequest 리턴
     */
    @GetMapping("/enrolment/apply")
    public ResponseEntity<?> apply(@RequestParam(name = "lectureNo") String lectureNo, HttpSession session){
        String stdID = String.valueOf(session.getAttribute("stdID"));
        String result = enrolmentService.apply(stdID, lectureNo);
        if(result.equals("신청이 완료되었습니다."))
            return ResponseEntity.ok(result);
        else return ResponseEntity.badRequest().body(result);
    }
}
