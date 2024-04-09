package com.study.controller;

import com.study.domain.MyBean101;
import com.study.domain.MyBean102;
import com.study.domain.MyBean103;
import com.study.domain.MyBean104;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("main10")
public class Controller10 {

    @RequestMapping("sub1")
    public void method01(Model model) {
        // 요청 분석
        // 비즈니스 로직 실행
        // 결과를 모델에 담고
        var data = new HashMap<String, List>();
        data.put("key1", List.of("java", "javascript"));
        data.put("key2", List.of("React", "view"));
        data.put("key 삼", List.of("spring", "node"));
        model.addAttribute("myList", data);
        // view로 포워딩(/WEB-INF/view/main10/sub1.jsp
    }

    @RequestMapping("sub2")
    public void method02(Model model) {
        var data = new ArrayList<Map>();
        data.add(Map.of("kim", 27, "ang", 100, "lee", 50));
        data.add(Map.of(
                "korea", "seoul",
                "japan", "tokyo",
                "미국", "워싱턴"
        ));
        model.addAttribute("myAttr", data);
    }

    @RequestMapping("sub3")
    public void method03(Model model) {
        var data = new HashMap<String, String>();
        data.put(
                "hui", "seoul"
        );
        data.put(
                "chae", "seoul"
        );
        data.put(
                "so", "incheon"
        );
        data.put(
                "jae", "부산"
        );
        model.addAttribute("attr1", data);
        model.addAttribute("attr2", "hui");
        model.addAttribute("attr3", "chae");
        model.addAttribute("jh", "강인");
    }

    @RequestMapping("sub4")
    public void method04(Model model) {
        var data = new ArrayList<Map>();
        data.add(Map.of(
                "s", "london",
                "lee", "tokyo"
        ));
        data.add(Map.of(
                "korea", "seoul",
                "japan", "tokyo"
        ));
        data.add(Map.of(
                "부산", "해운대"
        ));
        data.add(Map.of(
                "서울", "강남"
        ));

        model.addAttribute("list1", data);
        model.addAttribute("number1", 1);
        model.addAttribute("two", 2);
        model.addAttribute("three", "3");
        model.addAttribute("data1", "s");
        model.addAttribute("data2", "lee");
    }

    @RequestMapping("sub5")
    public void method05(Model model) {
        var data = new ArrayList<MyBean101>();
        MyBean101 e1 = new MyBean101();
        MyBean101 e2 = new MyBean101();
        MyBean101 e3 = new MyBean101();

        e1.setName("hui");
        e1.setAddress("seoul");
        e1.setAge(20);

        e2.setName("chae");
        e2.setAddress("seoul");
        e2.setAge(18);

        e3.setName("kai");
        e3.setAddress("incheon");
        e3.setAge(27);

        data.add(e1);
        data.add(e2);
        data.add(e3);

        model.addAttribute("myList", data);
    }

    @RequestMapping("sub6")
    public void method06(Model model) {
        var list = new ArrayList<MyBean102>();

        MyBean102 e1 = new MyBean102();
        MyBean102 e2 = new MyBean102();
        MyBean102 e3 = new MyBean102();

        e1.setModelName("k");
        e1.setPrice(5000);
        e1.setColor("white");

        e2.setModelName("p");
        e2.setPrice(6000);
        e2.setColor("black");

        e3.setModelName("m");
        e3.setPrice(2000);
        e3.setColor("yellow");

        list.add(e1);
        list.add(e2);
        list.add(e3);

        model.addAttribute("cars", list);
    }

    @RequestMapping("sub7")
    public void method07(Model model) {
        var list = new ArrayList<MyBean103>();
        MyBean103 e1 = new MyBean103();
        MyBean103 e2 = new MyBean103();

        e1.setName("한국");
        e1.setCities(List.of("서울", "인천", "부산"));

        e2.setName("일본");
        e2.setCities(List.of("도쿄", "오사카"));

        list.add(e1);
        list.add(e2);
        model.addAttribute("myList", list);
    }

    @RequestMapping("sub8")
    public void method08(Model model) {
        var list = new ArrayList<MyBean104>();
        MyBean104 e1 = new MyBean104();
        MyBean104 e2 = new MyBean104();

        e1.setCity("전주");
        e1.setFoods(List.of("비빔밥", "갈비", "육회"));

        e2.setCity("부산");
        e2.setFoods(List.of("회", "밀면", "돼지국밥"));

        list.add(e1);
        list.add(e2);

        model.addAttribute("data", list);
    }
}
