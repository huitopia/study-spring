package com.study.controller;

import com.study.domain.MyBean091;
import com.study.domain.MyBean092;
import com.study.domain.MyBean093;
import com.study.domain.MyBean094;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("main9")
public class Controller09 {
    @RequestMapping("sub1")
    public void method1(Model model) {
        // 객체 생성
        MyBean091 myBean091 = new MyBean091();
        // 모델에 담기
        model.addAttribute("person", myBean091);
    }

    @RequestMapping("sub2")
    public void method2(Model model) {
        // 객체 생성
        MyBean092 myBean092 = new MyBean092();
        myBean092.setAge(20);
        myBean092.setName("chae");
        MyBean092 myBean092_1 = new MyBean092();
        myBean092_1.setName("yeon");
        myBean092_1.setAge(27);
        // 모델에 담기
        model.addAttribute("person", myBean092);
        model.addAttribute("person2", myBean092_1);
    }

    @RequestMapping("sub3")
    public void method3(Model model) {
        MyBean093 myBean093 = new MyBean093();
        myBean093.setAddress("hongdae");
        myBean093.setCity("seoul");
        myBean093.setAge(29);
        model.addAttribute("member1", myBean093);
        MyBean093 myBean093_1 = new MyBean093();
        myBean093_1.setAddress("haewoondae");
        myBean093_1.setCity("busan");
        myBean093_1.setAge(20);
        model.addAttribute("member2", myBean093_1);
    }

    @RequestMapping("sub4")
    public void method4(Model model) {
        MyBean094 myBean094 = new MyBean094();
        myBean094.setModelNumber("k5");
        myBean094.setProductPrice(5000);
        myBean094.setName("kia");
        myBean094.setWeight(2400.50);
        myBean094.setUsed(false);
        model.addAttribute("car", myBean094);
    }
}
