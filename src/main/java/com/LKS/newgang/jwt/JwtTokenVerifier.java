package com.LKS.newgang.jwt;

import com.google.common.base.Strings;
import io.jsonwebtoken.*;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.crypto.SecretKey;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class JwtTokenVerifier extends OncePerRequestFilter {

    private final SecretKey secretKey;
    private final JwtConfig jwtConfig;

    public JwtTokenVerifier(SecretKey secretKey,
                            JwtConfig jwtConfig) {
        this.secretKey = secretKey;
        this.jwtConfig = jwtConfig;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        System.out.println(JwtTokenVerifier.class);
        String accessTokenHeader = request.getHeader(jwtConfig.getAccessTokenHeader());
        String refreshTokenHeader = request.getHeader(jwtConfig.getRefreshTokenHeader());

        if (Strings.isNullOrEmpty(accessTokenHeader) && Strings.isNullOrEmpty(refreshTokenHeader)) {
            filterChain.doFilter(request, response);
            return;
        } else if(!Strings.isNullOrEmpty(accessTokenHeader) && !accessTokenHeader.startsWith(jwtConfig.getTokenPrefix())){
            filterChain.doFilter(request, response);
            return;
        } else if(!Strings.isNullOrEmpty(refreshTokenHeader) && !refreshTokenHeader.startsWith(jwtConfig.getTokenPrefix())){
            filterChain.doFilter(request, response);
            return;
        }

        if(!Strings.isNullOrEmpty(accessTokenHeader)) {
            String token = accessTokenHeader.substring(jwtConfig.getTokenPrefix().length());
            this.authWithJwtToken(token);
        } else if (!Strings.isNullOrEmpty(refreshTokenHeader)) {
            String token = refreshTokenHeader.substring(jwtConfig.getTokenPrefix().length());
            this.authWithJwtToken(token);
        }

        filterChain.doFilter(request, response);
    }

    @Override
    public String toString() {
        return "This is JwtTokenVerifier!";
    }

    public Claims parseJwt(String token){
        JwtParser parser = Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build();
        Jws<Claims> claimsJws = parser.parseClaimsJws(token);

        return claimsJws.getBody();
    }

    public void authWithJwtToken(String token) {
        try {
            Claims body = this.parseJwt(token);
            String username = body.getSubject();

            var authorities = (List<Map<String, String>>) body.get("authorities");

            Set<SimpleGrantedAuthority> simpleGrantedAuthorities = authorities.stream()
                    .map(m -> new SimpleGrantedAuthority(m.get("authority")))
                    .collect(Collectors.toSet());

            Authentication authentication = new UsernamePasswordAuthenticationToken(
                    username,
                    null,
                    simpleGrantedAuthorities
            );

            SecurityContextHolder.getContext().setAuthentication(authentication);

        } catch (JwtException e) {
            e.printStackTrace();
            throw new IllegalStateException(String.format("Token %s cannot be trusted", token));
        }
    }
}