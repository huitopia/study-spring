package com.study.controller;

import com.study.domain.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("main14")
public class Controller14 {
    @RequestMapping("sub1")
    public void sub1(Model model) {
        MyBean141 o1 = new MyBean141("신촌", "한국", 33, "한");
        MyBean142 o2 = new MyBean142();
        o2.setName("인");
        o2.setId("19");
        o2.setAge(22);
        model.addAttribute("player1", o1);
        model.addAttribute("player2", o2);
    }

    @RequestMapping("sub2")
    public void sub2(Model model) {
        MyBean142 o1 = new MyBean142();
        o1.setName("김씨");
        MyBean142 o2 = new MyBean142();
        o2.setName("정씨");
        // attribute 명은 클래스명을 lowerCamelCase 로 변경된 이름으로 결정
        model.addAttribute(o1); // myBean142
        model.addAttribute(List.of(o1, o2)); // myBean142List[index].name
    }

    @RequestMapping("sub3")
    public void sub3(@ModelAttribute("player1") MyBean142 o1) {
        o1.setName("오씨");
    }

    @RequestMapping("sub4")
    public String sub4(@ModelAttribute MyBean142 o1) {
        o1.setName("김씨");
        return "/main14/sub3"; // view forwarding
    }

    @RequestMapping("sub5")
    public String sub5(MyBean142 o1) {
        o1.setName("이");
        return "/main14/sub3";
    }

    @RequestMapping("sub6")
    public void sub6(MyBean142 o1) {
        o1.setName("카리나");
    }

    @RequestMapping("sub7")
    public String sub(MyBean143 o1) {
        o1.setAddress("신촌");
        return "/main14/sub6";
    }

    // /main14/sub8?city=london&address=ny
    @RequestMapping("sub8")
    public void sub8(MyBean144 o1) {
        System.out.println(o1);
    }

    @RequestMapping("sub9")
    public void sub9(MyBean145 o1) {
    }

    @RequestMapping("sub10")
    public String sub10(MyBean145 o1) {
        return "/main14/sub9";
    }

    // /main14/sub11?city=서울&country=한국&price=3000
    @RequestMapping("sub11")
    public void sub11(MyBean146 o1) {
        System.out.println(o1);
    }

    // /main14/sub12?car=tesla&price=2000&model=k5&country=us
    @RequestMapping("sub12")
    public void sub12(
            Integer price, // @RequestParam
            String car, // @RequestParam
            MyBean147 o1, // @ModelAttribute
            MyBean146 o2
    ) {
        System.out.println("car = " + car);
        System.out.println("price = " + price);
        System.out.println("o1 = " + o1);
        System.out.println("o2 = " + o2);
    }
}
