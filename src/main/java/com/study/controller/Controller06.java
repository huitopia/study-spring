package com.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;

@Controller
@RequestMapping("/main6")
public class Controller06 {
    @RequestMapping("sub1")
    public void method1() {
        System.out.println("Controller06.method1");
    }

    @RequestMapping("sub2")
    public void method2(@RequestParam("w1") String param1,
                        @RequestParam("w2") String parma2) {
        System.out.println(param1 + ", " + parma2);
    }

    // /main6/sub3/name=kim@age=44
    @RequestMapping("sub3")
    public void method3(@RequestParam(required = false) String name,
                        @RequestParam(required = false) Integer age
    ) {
        System.out.println(name + "의 나이는 " + age);
    }

    @RequestMapping("sub4")
    public void method4(
            // @RequestParam("name") String name
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Integer age
    ) {
        System.out.println("이름은 " + name + ", 나이는 " + age);
    }

    // main6/sub5?address=shin&city=seoul
    @RequestMapping("sub5")
    public void method5(
            @RequestParam(required = false) String address,
            @RequestParam(required = false) String city
    ) {
        System.out.println("address = " + address);
        System.out.println("city = " + city);
    }

    // main6/sub6?address=hong&city=seoul
    @RequestMapping("sub6")
    // @RequestParam 생략시 required = false
    public void method6(String address, String city) {
        System.out.println("address = " + address + ", city = " + city);
    }

    // main6/sub7?name=hh&age=77
    /*
     * method argument type = 기본(wrapper 포함), String 이면
     * @RequestParam 으로 간주
     */
    @RequestMapping("sub7")
    public void method7(
            String name, Integer age
    ) {
        System.out.println("name = " + name + ", age = " + age);
    }

    // main6/sub8?name=ki&address="seoul","busan"
    @RequestMapping("sub8")
    public void method8(String name, String[] address) {
        System.out.println(name + ", " + Arrays.toString(address));
    }

    // main6/sub9?age=&city=
    @RequestMapping("sub9")
    public void method9(Integer[] age, String[] city) {
        System.out.println("age : " + Arrays.toString(age) + ", city"
                + Arrays.toString(city));
    }
}
