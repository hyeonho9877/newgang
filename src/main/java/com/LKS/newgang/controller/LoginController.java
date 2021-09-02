package com.LKS.newgang.controller;

import com.LKS.newgang.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * 유저의 로그인 요청을 응답하는 컨트롤러
 */
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class LoginController {

    private final LoginService loginService;

    /**
     * 웹 브라우저에서 입력받은 아이디와 비밀번호를 바탕으로 유저 인증을 실행하는 메소드
     * @param session 유저와 서버간의 세션
     * @param form 유저가 입력한 아이디와 비밀번호를 담고 있는 객체
     * @return 로그인에 성공하면 ok, 실패하면 badRequest
     */
    @PostMapping("/auth")
    public ResponseEntity<?> auth(HttpSession session, @RequestBody LoginForm form){
        if(loginService.authStudent(form.getUserID(), form.getPassword())){
            // set max session time to 10 min
            session.setMaxInactiveInterval(600);
            session.setAttribute("stdID", form.getUserID());
            // return page
            return ResponseEntity.ok().build();
        } else{
            return ResponseEntity.badRequest().body("학번 또는 비밀번호가 잘못돼었습니다.");
        }
    }

    /**
     * 로그아웃
     * @param session 유저와 서버간의 세션
     * @return ok
     */
    @PostMapping("/auth/logout")
    public ResponseEntity<?> logout(HttpSession session) {
        session.invalidate();
        return ResponseEntity.ok().build();
    }
}