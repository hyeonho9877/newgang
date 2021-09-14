package com.LKS.newgang.jwt;

import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import javax.crypto.SecretKey;
import java.util.Collection;
import java.util.Date;

@RequiredArgsConstructor
public class JwtTokenGenerator {

    private final JwtConfig jwtConfig;
    private final SecretKey secretKey;

    public String generateNewAccessToken(String subject, Collection<? extends GrantedAuthority> authorities){

        return Jwts.builder()
                .setSubject(subject)
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 10))
                .setIssuer(jwtConfig.getIssuer())
                .claim("authorities", authorities)
                .signWith(secretKey)
                .compact();
    }

    public String generateNewRefreshToken(String subject, Collection<? extends GrantedAuthority> authorities){

        return Jwts.builder()
                .setSubject(subject)
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24))
                .setIssuer(jwtConfig.getIssuer())
                .claim("authorities", authorities)
                .signWith(secretKey)
                .compact();
    }

}
