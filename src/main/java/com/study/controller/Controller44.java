package com.study.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.Map;

@Controller
@RequestMapping("/api/main44")
@RequiredArgsConstructor
public class Controller44 {

    private final JwtEncoder jwtEncoder;

    @PostMapping("login")
    @ResponseBody
    public String login(@RequestBody Map<String, Object> map) {
        // 전달된 데이터에서 "username" 키에 해당하는 값을 추출하여 문자열로 변환
        String username = map.get("username").toString();
        // 권한
        String scope = map.get("scope").toString();
        // WT의 클레임(Claims)을 정의하고 생성합니다.
        // 여기서는 토큰의 발행자, 발행 시간, 만료 시간, 서브젝트 등을 설정
        JwtClaimsSet claimSet = JwtClaimsSet.builder()
                // 발급자(issuer) 클레임을 설정
                .issuer("self")
                // 토큰의 발행 시간을 현재 시간으로 설정
                .issuedAt(Instant.now())
                // 토큰의 만료 시간을 현재 시간에서 24시간 후로 설정
                .expiresAt(Instant.now().plusSeconds(60 * 60 * 24))
                // 토큰의 사용자를 username 으로 설정
                .subject(username)
                // 사용자 정의 클레임으로 "scope" 설정 값은 scope
                // 클라이언트나 서버에서 사용하는 추가 정보 포함 가능
                .claim("scope", scope)
                // 설정한 클레임들을 바탕으로 객체 생성 > JWT의 페이로드로 사용됨
                .build();
        return jwtEncoder.encode(JwtEncoderParameters.from(claimSet))
                .getTokenValue();
    }

    @GetMapping("all")
    @ResponseBody
    public String all() {
        return "누구나 접근 가능한 경로";
    }

    @GetMapping("user")
    @ResponseBody
    @PreAuthorize("isAuthenticated()")
    public String user() {
        return "로그인 유저만 접근 가능한 경로";
    }

    @GetMapping("admin")
    @ResponseBody
    @PreAuthorize("hasAuthority('SCOPE_admin')")
    public String admin() {
        return "admin 접근 가능";
    }

    @GetMapping("manager")
    @ResponseBody
    @PreAuthorize("hasAuthority('SCOPE_manager')")
    public String manager() {
        return "manager 접근 가능";
    }

    @GetMapping("ma")
    @ResponseBody
    @PreAuthorize("hasAnyAuthority('SCOPE_maneger','SCOPE_admin')")
    public String ma() {
        return "admin+manager 접근 가능";
    }
}
