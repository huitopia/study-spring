package com.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;

@Controller
@RequestMapping("main20")
public class Controller20 {

    @RequestMapping("sub1")
    public void sub1() {
    }

    @RequestMapping("sub2")
    public void sub2() {
    }

    @RequestMapping("sub3")
    public void sub3() {
    }

    @RequestMapping("sub4")
    public void sub4() {
    }

    @RequestMapping("sub11")
    public void sub11() {

    }

    @RequestMapping("sub12")
    public void sub12(String type, String content, String city) {
        System.out.println("type = " + type);
        System.out.println("content = " + content);
        System.out.println("city = " + city);
    }

    @RequestMapping("sub13")
    public void sub13(String city) {
        System.out.println("city = " + city);
    }

    @RequestMapping("sub14")
    public void sub14(@RequestParam("foods") String[] foods) {
        System.out.println("foods = " + Arrays.toString(foods));
    }

    /*
     * sub11.jsp form 요소 작성
     * submit click > /main20/sub15 전송
     * type : select&option
     * phone : radio button
     * book : checkbox
     */
    @RequestMapping("sub15")
    public void sub15(String type, String phone, String[] book) {
        System.out.println("type = " + type);
        System.out.println("phone = " + phone);
        System.out.println("book = " + Arrays.toString(book));
    }

    @RequestMapping("sub16")
    public void sub16() {
    }

    @RequestMapping("sub17")
    public void sub17(String id, String password, String desc) {
        System.out.println("id = " + id);
        System.out.println("password = " + password);
        System.out.println("desc = " + desc);
    }

    @RequestMapping("sub18")
    public void sub18(String name, String city, String address) {
        System.out.println("name = " + name);
        System.out.println("city = " + city);
        System.out.println("address = " + address);
    }
}
