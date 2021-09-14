package com.LKS.newgang.controller;

import com.LKS.newgang.jwt.JwtConfig;
import com.LKS.newgang.service.MainService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * 유저가 로그인을 성공한 후 기능탭 내에서 이루어지는 작업이 아닌 외부에서 이루어지는 작업에 대한 요청에 응답하는 컨트롤러
 */
@RestController
@RequiredArgsConstructor
public class MainController {


    private final JwtConfig jwtConfig;
    private final MainService mainService;

    @ResponseBody
    @GetMapping("/refreshToken")
    public void resetLoginSession(HttpServletRequest request, HttpServletResponse response) {
        String refreshToken = request.getHeader(jwtConfig.getRefreshTokenHeader());

        if (mainService.verifyTokenForm(refreshToken)) {
            try {
                Claims body = mainService.parseJwt(refreshToken);
                String accessToken = mainService.generateNewToken(body);

                HashMap<String, String> tokens = new HashMap<>();
                tokens.put(jwtConfig.getAccessTokenHeader(), accessToken);
                tokens.put(jwtConfig.getRefreshTokenHeader(), refreshToken);

                response.setContentType(APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(), tokens);
            } catch (Exception e) {

            }
        }
    }
}