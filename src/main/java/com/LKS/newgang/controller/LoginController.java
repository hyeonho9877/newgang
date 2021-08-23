package com.LKS.newgang.controller;

import com.LKS.newgang.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

/**
 * 유저의 로그인 요청을 응답하는 컨트롤러
 */
@Controller
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    /**
     * 웹 브라우저에서 입력받은 아이디와 비밀번호를 바탕으로 유저 인증을 실행하는 메소드
     * @param session 유저와 서버간의 세션
     * @param form 유저가 입력한 아이디와 비밀번호를 담고 있는 객체
     * @return 로그인에 성공할 시 메인 페이지로 이동, 실패시 새로고침
     */
    @PostMapping("/auth")
    public String auth(HttpSession session, LoginForm form){
        if(loginService.authStudent(form.getUserID(), form.getPassword())){
            // set max session time to 10 min
            session.setMaxInactiveInterval(600);
            session.setAttribute("stdID", form.getUserID());
            // return page
        }
        return "redirect:/";
    }


}
