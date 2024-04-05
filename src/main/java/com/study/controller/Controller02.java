package com.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Controller02 {

    @RequestMapping(value = "/main2/sub1")
    public void sub1() {
        System.out.println("Controller02.sub1");
    }

    @RequestMapping(value = "/main2/sub2")
    public void sub2() {
        System.out.println("Controller02.sub2");
    }

    @RequestMapping(value = "/main2/sub3")
    public void sub3() {
        System.out.println("Controller02.sub3");
    }
}
