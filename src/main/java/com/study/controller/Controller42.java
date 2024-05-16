package com.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

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

    @GetMapping("/sub3")
    @ResponseBody
    public Map method3() {
        return Map.of("name", "kim",
                "age", 30,
                "married", true,
                "info", Map.of("team", "토트넘", "location", "london"),
                "item", List.of("k", "i", "m")
        );
    }

    @GetMapping("sub4")
    @ResponseBody
    public Map method4() {
        return Map.of("string", "sss",
                "integer", 01,
                "bool", true,
                "list", List.of("z", "x", "c", "v"),
                "mapmap", Map.of("k", "v"));
    }
}
