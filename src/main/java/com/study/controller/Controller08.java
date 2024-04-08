package com.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("main8")
public class Controller08 {

    @RequestMapping("sub1")
    public void method1(Model model) {
        model.addAttribute("name1", "hi");
        model.addAttribute("name2", "hello");
    }

    @RequestMapping("sub2")
    public void method2(Model model) {
        model.addAttribute("city", "seoul");
        model.addAttribute("address", "hongdae");
    }

    @RequestMapping("sub3")
    public void method3(
            Model model,
            @RequestParam("nick") String nickName
    ) {
        model.addAttribute("name", nickName);
        model.addAttribute("age", 22);
    }

    @RequestMapping("sub4")
    public void method04(Model model) {
        /*
         * model attribute name : String
         * model attribute value : Object
         * 따라서 model attribute value 는 무엇이든 될 수 있다.
         * 자주 사용하는 타입
         * String, Wrapper
         * Array, List, Map
         * JavaBeans
         */

        // Array
        model.addAttribute("car", new String[]{"tesla", "bmw", "hyundai", "jeep"});
    }

    /* Array */
    @RequestMapping("sub5")
    public void method05(Model model) {
        model.addAttribute("cities", new String[]{"seoul", "busan", "incheon"});
        model.addAttribute("countries", new String[]{"korea", "japan", "china"});
    }

    /* List */
    @RequestMapping("sub6")
    public void method06(Model model) {
        List<String> listData = List.of("java", "css", "html", "jsp");
        model.addAttribute("myList", listData);
    }

    @RequestMapping("sub7")
    public void method07(Model model) {
        List<String> emotionData = List.of("➡️", "😇", "💡");
        model.addAttribute("emotionList", emotionData);
        List<Integer> numData = List.of(10, 5, 0);
        model.addAttribute("numList", numData);
    }

    @RequestMapping("sub8")
    public void method08(Model model) {
        model.addAttribute("numbers", List.of(500.0, 3.14));
        model.addAttribute("cities", List.of("seoul", "london", "newyork"));
    }

    /* Map */
    @RequestMapping("sub9")
    public void method09(Model model) {
        Map<String, String> map = new HashMap<>();
        map.put("name", "hui");
        map.put("age", "ten");
        map.put("address", "seoul");
        model.addAttribute("myMap", map);
    }

    @RequestMapping("sub10")
    public void method10(Model model) {
        Map<String, String> names = Map.of("kim", "seoul", "so", "incheon", "young", "newyork");
        model.addAttribute("names", names);
    }
}
