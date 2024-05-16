package com.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api/main42")
public class Controller42 {

    @GetMapping("/sub1")
    @ResponseBody // view 해석 x
    public String method1() {
        return "data?";
    }

    @GetMapping("/sub2")
    @ResponseBody
    public String method2() {
        return "log?????";
    }
}
