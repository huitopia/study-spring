package com.study.controller;

import com.study.domain.MyBean411;
import com.study.domain.MyBean412;
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

    @GetMapping("sub5")
    @ResponseBody
    public MyBean411 method5() {
        MyBean411 obj = new MyBean411();
        obj.setName("lee");
        obj.setAge(30);
        return obj;
    }

    @GetMapping("sub6")
    @ResponseBody
    public MyBean412 method6() {
        MyBean412 bean = new MyBean412();
        MyBean412 myBean412 = new MyBean412();
        myBean412.setFoods(List.of("감자", "고구마"));
        myBean412.setHeight(177.7);
        myBean412.setMarried(false);
        MyBean411 myBean411 = new MyBean411();
        myBean411.setName("흥민");
        myBean411.setAge(55);
        myBean412.setInfo(myBean411);
        myBean412.setName("강인");
        return myBean412;
    }
}
