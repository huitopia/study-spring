package com.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("main3")
public class Controller03 {

    @RequestMapping("sub1")
    public void method1() {
        System.out.println("Controller03.method1");
    }

    @RequestMapping("sub2")
    public void method2() {
        System.out.println("Controller03.method2");
    }

    @RequestMapping(value = "sub3", params = "name")
    public void method3(String name) {
        System.out.println("이름 : " + name);
    }

    @RequestMapping(value = "sub3", params = {"address", "city"})
    public void method5(
            String address, String city
    ) {
        System.out.println(address + ", " + city);
    }

    // main3/sub3?country&city
    @RequestMapping(value = "sub3", params = {"country", "city"})
    public void method6() {
        System.out.println("Controller03.method6");
    }
}
