package com.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/api/main41")
public class Controller41 {
    @PostMapping("sub1")
    public void method1(@RequestBody Map<String, Object> map) {
        // @RequestBody
        // 역직렬화(parse, decode) JSON -> Map
        System.out.println("map = " + map);
    }

    @PostMapping("sub2")
    public void method2(@RequestBody Map<String, Object> map) {
        System.out.println("map = " + map);
        System.out.println("map.keySet() = " + map.keySet());
    }

    @PostMapping("sub3")
    public void sub3(@RequestBody Map<String, Object> map) {
        System.out.println("map = " + map);
    }

    @PostMapping("sub4")
    public void sub4(@RequestBody Map<String, Object> map) {
        System.out.println("map = " + map);
    }

    @PostMapping("sub5")
    public void sub5(@RequestBody Map<String, Object> map) {
        System.out.println("map = " + map);
        Object name = map.get("name");
        System.out.println("name.getClass() = " + name.getClass());
        Object age = map.get("age");
        System.out.println("age.getClass() = " + age.getClass());
        Object married = map.get("married");
        System.out.println("married.getClass() = " + married.getClass());
        Object apple = map.get("apple");
        System.out.println("apple.getClass() = " + apple.getClass());
        Object food = map.get("food");
        System.out.println("food.getClass() = " + food.getClass());
    }
}
