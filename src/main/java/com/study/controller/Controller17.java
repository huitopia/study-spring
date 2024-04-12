package com.study.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("main17")
public class Controller17 {
    @RequestMapping("sub1")
    public void sub1(Model model, HttpSession session) {
        // session : 한 브라우저의 요청들이 공유하는 객체
        model.addAttribute("name", "hi");
        session.setAttribute("city", "london");
    }

    @RequestMapping("sub2")
    public String sub2(Model model) {
        // session 객체만 반환
        return "/main17/sub1";
    }

    @RequestMapping("sub3")
    public void sub3(String id, HttpSession session) {
        if (id != null && !id.isBlank()) {
            session.setAttribute("userId", id);
        }
    }

    @RequestMapping("sub4")
    public void sub4(Model model) {
    }

    @RequestMapping("sub5")
    public void sub5(Model model) {
    }

    @RequestMapping("sub6")
    public void sub6(String id, HttpSession session) {
        if (id != null && !id.isBlank()) {
            session.setAttribute("testId", id);
        }
    }

    @RequestMapping("sub7")
    public void sub7(Model model) {
    }

    @RequestMapping("sub8")
    public void sub8(Model model) {
    }

    @RequestMapping("sub9")
    public void sub9(HttpSession session) {
        // session 만료
        session.invalidate();

    }

}
