package com.LKS.newgang.controller;

import com.LKS.newgang.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @PostMapping("/auth")
    public String auth(LoginForm form){
        if(loginService.authStudent(form.getUserID(), form.getPassword())){
            // return page
        }
        return null;
    }
}
