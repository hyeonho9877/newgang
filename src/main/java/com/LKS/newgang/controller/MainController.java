package com.LKS.newgang.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * 유저가 로그인을 성공한 후 기능탭 내에서 이루어지는 작업이 아닌 외부에서 이루어지는 작업에 대한 요청에 응답하는 컨트롤러
 */
@RestController
public class MainController {

    /**
     * 로그인 후 유저가 세션 만료 시간의 연장을 요청한 경우 실행되는 메소드
     * @param session 유저와 서버간의 세션 정보
     * @return 세션의 연장이 성공하면 ok, 실패하면 badRequest 리턴
     */
    @ResponseBody
    @PostMapping("/resetSession")
    public ResponseEntity<?> resetLoginSession(HttpSession session) {
        try {
            session.setMaxInactiveInterval(1); // 세션의 만료 시간을 재설정
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}