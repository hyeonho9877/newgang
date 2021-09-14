package com.LKS.newgang.service;

import com.LKS.newgang.jwt.JwtConfig;
import com.LKS.newgang.jwt.JwtTokenGenerator;
import com.LKS.newgang.jwt.JwtTokenVerifier;
import com.google.common.base.Strings;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Transactional
@Service
@RequiredArgsConstructor
public class MainService {

    private final JwtConfig jwtConfig;
    private final JwtTokenVerifier tokenVerifier;
    private final JwtTokenGenerator tokenGenerator;

    public boolean verifyTokenForm(String refreshToken) {
        return !Strings.isNullOrEmpty(refreshToken) && refreshToken.startsWith(jwtConfig.getTokenPrefix());
    }

    public Claims parseJwt(String header){
        String token = header.substring(jwtConfig.getTokenPrefix().length());
        try {
            return tokenVerifier.parseJwt(token);
        } catch (JwtException e) {
            throw new IllegalStateException(String.format("Token %s cannot be trusted", token));
        }
    }

    public String generateNewToken(Claims body){
        String username = body.getSubject();
        String issuer = body.getIssuer();

        var authorities = (List<Map<String, String>>) body.get("authorities");

        Set<SimpleGrantedAuthority> simpleGrantedAuthorities = authorities.stream()
                .map(m -> new SimpleGrantedAuthority(m.get("authority")))
                .collect(Collectors.toSet());

        String newToken = tokenGenerator.generateNewAccessToken(username, simpleGrantedAuthorities);
        return newToken;
    }
}
