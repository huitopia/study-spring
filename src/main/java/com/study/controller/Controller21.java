package com.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("main21")
public class Controller21 {
    // GET 방식으로 요청이 오면 method1 실행
    @RequestMapping(value = "sub1", method = {RequestMethod.GET, RequestMethod.POST})
    public void method1() {
        System.out.println("Controller21.method1");
    }

    @RequestMapping("sub2")
    public void method2() {
        System.out.println("Controller21.method2");
    }

    @RequestMapping(value = "sub3", method = RequestMethod.GET)
    public void method3() {
        System.out.println("Controller21.method3");
    }

    @RequestMapping(value = "sub3", method = RequestMethod.POST)
    public void method4() {
        System.out.println("Controller21.method4");
    }

    // @RequestMapping(value = "sub4", method = RequestMethod.GET)
    @GetMapping("sub4")
    public void method5() {
        System.out.println("Controller21.method5");
    }

    // @RequestMapping(value = "sub4", method = RequestMethod.POST)
    @PostMapping("sub4")
    public void method6() {
        System.out.println("Controller21.method6");
    }

    @GetMapping("sub5")
    public void method7() {
        System.out.println("Controller21.method7");
    }

    @PostMapping("sub5")
    public void method8() {
        System.out.println("Controller21.method8");
    }
}
