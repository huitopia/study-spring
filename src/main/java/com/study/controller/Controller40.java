package com.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Controller40 {
    @GetMapping("/api/someurl")
    public void method1() {
        System.out.println("Controller40.method1");
    }

    @PostMapping("/api/someurl")
    public void method2() {
        System.out.println("Controller40.method2");
    }

    @GetMapping("/api/someurl2")
    public void method3() {
        System.out.println("Controller40.method3");
    }

    @PostMapping("/api/someurl2")
    public void method4() {
        System.out.println("Controller40.method4");
    }

    @GetMapping("api/someurl3")
    public void method5(@RequestParam("id") Integer id,
                        @RequestParam("name") String name,
                        @RequestParam("email") String email) {
        System.out.println("id = " + id);
        System.out.println("name = " + name);
        System.out.println("email = " + email);
    }

    @PostMapping("/api/someurl3")
    public void method6(@RequestParam("name") String name,
                        @RequestParam("age") Integer age) {
        System.out.println("name = " + name);
        System.out.println("age = " + age);
    }

    @GetMapping("api/someurl4")
    public void method7(@RequestParam("age") Integer age,
                        @RequestParam("job") String job) {
        System.out.println("age = " + age);
        System.out.println("job = " + job);
    }

    @PostMapping("/api/someurl4")
    public void method8(Integer id, String name) {
        System.out.println("id = " + id);
        System.out.println("name = " + name);
    }
}
