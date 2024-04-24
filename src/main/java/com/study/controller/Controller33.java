package com.study.controller;

import com.study.domain.MyBean331;
import com.study.domain.MyBean332;
import com.study.domain.MyBean333;
import com.study.mapper.Mapper04;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("main33")
@RequiredArgsConstructor
public class Controller33 {
    private final Mapper04 mapper;

    @GetMapping("sub1")
    public void method1() {
        List<MyBean331> obj = mapper.select1();
        obj.forEach(System.out::println);
    }

    @GetMapping("sub2")
    public void method2() {
        List<MyBean332> obj = mapper.select2();
        obj.forEach(System.out::println);
    }

    /*
     *  todo: method3 create
     *   mapper.select3()
     *   List<MyBean333> type obj.forEach
     *   SELECT * FROM my_table10;
     */
    @GetMapping("sub3")
    public void method3() {
        List<MyBean333> obj = mapper.select3();
        obj.forEach(System.out::println);
    }

    @GetMapping("sub4")
    public void method4() {
        mapper.insert1("hello!", "54321", "876.54", "2024-01-01", "2024-02-02 14:14:14");
    }

    @GetMapping("sub5")
    public void method5() {
        String strVal = "mybatis";
        Integer intVal = 7890;
        Double doubleVal = 3.14;
        LocalDate dateVal = LocalDate.parse("1998-08-12");
        LocalDateTime dateTimeVal = LocalDateTime.parse("1998-08-12T12:14:14");
        mapper.insert2(strVal, intVal, doubleVal, dateVal, dateTimeVal);
    }

    // todo: method6 create, my_table10 Insert
    @GetMapping("sub6")
    public void method6() {
        mapper.insert3("이것이 자바다", "신용권",
                44, 5000.12,
                LocalDate.parse("1789-09-09"),
                LocalDateTime.parse("2020-09-09T09:09:09"));
    }

    @GetMapping("sub7")
    public void method7() {
        MyBean332 obj = new MyBean332();
        obj.setStringCol("hello");
        obj.setIntCol(7890);
        obj.setDateCol(LocalDate.parse("2020-09-09"));
        obj.setDateTimeCole(LocalDateTime.parse("2020-09-09T09:09:09"));
        obj.setDecCol(99.78);
        mapper.insert4(obj);
    }

    // todo: method8, my_table10 Insert Into Values, MyBean333
    @GetMapping("sub8")
    public void method8() {
        MyBean333 obj = new MyBean333();
        obj.setAge(7);
        obj.setName("채쪽");
        obj.setInserted(LocalDateTime.now());
        obj.setPublished(LocalDate.now());
        obj.setPrice(10000.00);
        obj.setTitle("금쪽이");
        mapper.insert5(obj);
    }

    @GetMapping("sub9")
    public void select9(Model model) {
        List<MyBean332> list = mapper.select2();
        model.addAttribute("datas", list);
    }

    @PostMapping("sub9")
    public String insert9(
            String strVal,
            String intVal,
            String realVal,
            String dateVal,
            String dateTimeVal
    ) {
        mapper.insert1(strVal, intVal, realVal, dateVal, dateTimeVal);
        return "redirect:/main33/sub9";
    }

    @GetMapping("sub10")
    public String select10(Model model) {
        List<MyBean332> list = mapper.select2();
        model.addAttribute("datas", list);
        return "main33/sub9";
    }

    @PostMapping("sub10")
    public String insert10(
            String strVal,
            Integer intVal,
            Double realVal,
            LocalDate dateVal,
            LocalDateTime dateTimeVal
    ) {
        mapper.insert2(strVal, intVal, realVal, dateVal, dateTimeVal);
        return "redirect:/main33/sub10";
    }

    @GetMapping("sub11")
    public String select11(Model model) {
        List<MyBean332> list = mapper.select2();
        model.addAttribute("datas", list);
        return "/main33/sub11";
    }

    @PostMapping("sub11")
    public String insert11(MyBean332 data) {
        mapper.insert4(data);
        return "redirect:/main33/sub11";
    }

    // todo: my_table10 레코드 조회 및 입력 로직 완성
    @GetMapping("sub12")
    public String select12(Model model) {
        List<MyBean333> list = mapper.select3();
        model.addAttribute("datas", list);
        return "/main33/sub12";
    }

    @PostMapping("sub12")
    public String insert12(MyBean333 data) {
        mapper.insert5(data);
        return "redirect:/main33/sub12";
    }
}
