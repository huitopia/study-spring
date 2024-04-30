package com.study.controller;

import com.study.service.Service04;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping("main37")
public class Controller37 {
    private final Service04 service;

    @GetMapping("sub1")
    public void method1() {
        service.action01();
    }

    @GetMapping("sub2")
    public void method2() {
        service.action02();
    }

    @GetMapping("sub3")
    public void method3() {
        service.action03();
    }

    @GetMapping("sub4")
    public void method4() {
        service.action04();
    }

    @GetMapping("sub5")
    public void method5() {
        service.action05();
    }

    @GetMapping("sub6")
    public void method6(
            @RequestParam(value = "q", defaultValue = "") String keyword
    ) {
        service.action06(keyword);
    }

    @GetMapping("sub7")
    public void method7() {
        service.action07();
    }
}
