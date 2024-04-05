package com.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

import java.util.Iterator;

@Controller
@RequestMapping("main4")
public class Controller04 {
    @RequestMapping("sub1")
    public void sub1(WebRequest request) {
        Iterator<String> names = request.getParameterNames();

        while (names.hasNext()) {
            String name = names.next();
            System.out.println(name);
        }
    }

    @RequestMapping(value = "sub2", params = {"name", "age", "city", "country"})
    public void sub2(WebRequest request) {
        Iterator<String> names = request.getParameterNames();
        while (names.hasNext()) {
            String name = names.next();
            String value = request.getParameter(name);
            System.out.println(name + " = " + value);
        }
    }

    // main4/sub3?query=
    @RequestMapping("sub3")
    public void sub3(WebRequest webRequest) {
        String value = webRequest.getParameter("query");
        if (value != null) {
            System.out.println(value + " 검색하기");
            System.out.println("검색결과 응답");
        }
    }

    // main4/sub4?city=
    @RequestMapping(value = "sub4")
    public void sub4(WebRequest webRequest) {
        String value = webRequest.getParameter("city");
        if (value != null) {
            System.out.println("도시 : " + value);
        }
    }

    @RequestMapping("sub5")
    public void sub5(WebRequest webRequest) {
        String value = webRequest.getParameter("age");
        int age = Integer.parseInt(value);
        if (age > 19) System.out.println("성인 정보");
        else if (age > 13) System.out.println("청소년 정보");
        else if (age > 0) System.out.println("유아 정보");
    }

    @RequestMapping("sub6")
    public void sub6(WebRequest webRequest) {
        String value = webRequest.getParameter("weight");
        double weight = Double.parseDouble(value);

        if (weight > 90.0) System.out.println("과체중");
        else if (weight > 50.0) System.out.println("보통");
        else if (weight > 0) System.out.println("저체중");
    }
}
