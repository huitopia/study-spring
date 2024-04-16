package com.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("main22")
public class Controller22 {
    @GetMapping("sub1")
    public String sub1() {
        // view forward
        return "/main22/sub1";
    }

    @GetMapping("sub2")
    public String sub2() {
        /* redirect: 접두어 붙이면 redirection 응답
         * redirection 응답(302) : 브라우저는 302 응답을 받으면
         * Location Header 에 있는 값으로 재요청 보냄
         */
        return "redirect:/main22/sub1";
    }

    @GetMapping("sub3")
    public void sub3() {
        // login form 있는 jsp (view) forward
    }

    @PostMapping("sub4")
    public String sub4(String id, String password) {
        boolean ok = id.equals(password);
        if (ok) {
            // 로그인 성공 처리
            // 성공 후 보여주는 페이지로 이동
            return "redirect:/main22/sub5";
        } else {
            // 로그인 실패 처리
            // 로그인 form 페이지로 이동
            return "redirect:/main22/sub3";
        }
    }

    @GetMapping("sub5")
    public void sub5() {
    }

    @GetMapping("sub6")
    public void sub6() {
        // login form view forward
    }

    @PostMapping("sub7")
    public String sub7(String id, String password) {
        boolean bool = id.equals(password);
        // id 와 password 가 일치하면 로그인 성공 > /main22/sub8
        if (bool) {
            return "redirect:/main22/sub8";
        } else {
            // 실패 > /main22/sub6
            return "redirect:/main22/sub6";
        }
    }

    @GetMapping("sub8")
    public void sub8() {
    }

    //
    @GetMapping("sub9")
    public String sub9(RedirectAttributes rttr) {
        String condition = "fail";
        if (Math.random() < 0.5) {
            condition = "ok";
        }
        // redirection 정보 전달은 RedirectAttributes 활용
        rttr.addAttribute("condition", condition);
        rttr.addAttribute("type", "soccer");
        rttr.addAttribute("city", "seoul");
        rttr.addAttribute("address", "DMC");
        // Query String
        return "redirect:/main22/sub10?";
        // http://localhost:8080/main22/sub10?&condition=fail&type=soccer&city=seoul&address=DMC
    }

    @GetMapping("sub10")
    public void sub10(String condition) {
        System.out.println("condition = " + condition);
        System.out.println("Controller22.sub10");
    }
}
