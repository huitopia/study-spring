package com.study.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Controller38 {
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    // @PreAuthorize() : 특정 조건이 충족되지 않으면 메소드 호출을 거부
    @GetMapping("/path1")
    @PreAuthorize("isAuthenticated()") // 메소드 호출 전에 현재 사용자가 인증되었는지를 확인
    public void path1() {
        System.out.println("Controller38.path1");
    }
}
