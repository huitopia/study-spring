package com.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("main5")
public class Controller05 {
    @RequestMapping("sub1")
    public void method1(@RequestParam("city") String param) {
        System.out.println(param + " 검색 로직 실행");
    }

    // /main5/sub2?address=sinchon
    @RequestMapping("sub2")
    public void method2(@RequestParam("address") String param) {
        System.out.println(param + "로 가는 경로 탐색");
    }

    @RequestMapping("sub4")
    public void method4(@RequestParam("height") double param) {
        if (param > 190.0) System.out.println("큰 키");
        else if (param > 140.0) System.out.println("중간 키");
        else if (param > 0.0) System.out.println("작은 키");
    }
}
