package com.study.controller;

import com.study.domain.MyBean281Customer;
import com.study.domain.MyBean283Employees;
import com.study.domain.MyBean284Products;
import com.study.mapper.Mapper02;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

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
        return null;
    }

    @GetMapping("sub4")
    public String method4() {
        MyBean281Customer customer2 = mapper.selectCustomerRead3();
        System.out.println("customer2 = " + customer2);
        return null;
    }

    @GetMapping("sub5")
    public void method5() {
        // todo: 2번 직원의 정보 조회 후 출력
        MyBean283Employees e = mapper.selectEmployee1();
        System.out.println("e = " + e);
    }

    @GetMapping("sub6")
    public void method6() {
        MyBean283Employees e = mapper.selectEmployee2(4);
        System.out.println("e = " + e);
    }

    @GetMapping("sub7")
    public void method7(Integer id) {
        MyBean283Employees e = mapper.selectEmployee2(id);
        System.out.println("e = " + e);
    }

    // todo ; mapper에 selectOneCustomer4 메소드 작성해서
    //  /main31/sub8?id=9
    //  로 요청 오면 9번 고객이 출력되도록 하세요.
    @GetMapping("sub8")
    public void method8(Integer id) {
        MyBean281Customer c = mapper.selectCustomerRead4(id);
        System.out.println("c = " + c);
    }

    @GetMapping("sub9")
    public void method9() {
        List<MyBean281Customer> customers = mapper.selectAllCustomer1();
        System.out.println("customers.size() = " + customers.size());
    }

    @GetMapping("sub10")
    public void method10() {
        List<MyBean283Employees> employee = mapper.selectAllEmployee1();
        employee.forEach(System.out::println);
    }

    @GetMapping("sub11")
    public void method11(String country1, String country2) {
        List<MyBean281Customer> list = mapper.selectCustomerByCountry(country1, country2);
    }

    // todo: main31/sub12?min=5&max=55;
    // 가격이 5~55 사이인 상품 가격 순 조회 후 콘솔에 출력
    @GetMapping("sub12")
    public void method12(Double min, Double max) {
        List<MyBean284Products> list = mapper.selectProductByPrice(min, max);
        list.forEach(System.out::println);
    }
}
