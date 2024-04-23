package com.study.controller;

import com.study.domain.MyBean281Customer;
import com.study.mapper.Mapper02;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // 내부에 Component 포함
@RequiredArgsConstructor
@RequestMapping("main31")
public class Controller31 {
    private final Mapper02 mapper;

    @GetMapping("sub1")
    public void method1() {
        String now = mapper.selectNow();
        System.out.println("now = " + now);
    }

    @GetMapping("sub2")
    public String method2() {
        MyBean281Customer customer = mapper.selectCustomerRead();
        System.out.println("customer = " + customer);
        return null;
    }

    @GetMapping("sub3")
    public String method3() {
        MyBean281Customer customer1 = mapper.selectCustomerRead2();
        System.out.println("customer1 = " + customer1);
        MyBean281Customer customer2 = mapper.selectCustomerRead3();
        System.out.println("customer2 = " + customer2);
        return null;
    }
}
