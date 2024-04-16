package com.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

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
    public String sub4(String id, String password,
                       RedirectAttributes rttr) {
        boolean ok = id.equals(password);
        if (ok) {
            rttr.addAttribute("type", "login");
            // 로그인 성공 처리
            // 성공 후 보여주는 페이지로 이동
            return "redirect:/main22/sub5";
        } else {
            rttr.addAttribute("type", "fail");
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
    public String sub7(String id, String password,
                       RedirectAttributes rttr
    ) {
        boolean bool = id.equals(password);
        // id 와 password 가 일치하면 로그인 성공 > /main22/sub8
        if (bool) {
            rttr.addAttribute("type", "login");
            return "redirect:/main22/sub8";
        } else {
            // 실패 > /main22/sub6
            rttr.addAttribute("type", "fail");
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

    @GetMapping("sub11")
    public String sub11(RedirectAttributes rttr) {
        // Qeury String
        rttr.addAttribute("type", "soccer");
        // Model
        rttr.addFlashAttribute("attr1", List.of("car", "food", "phone"));
        return "redirect:/main22/sub12";
    }

    /*
    @GetMapping("sub12")
    public void sub12(Model model) {
        Object attr1 = model.getAttribute("attr1");
        System.out.println("attr1 = " + attr1);
    }*/
    @GetMapping("sub12")
    public void sub12(@ModelAttribute("attr1") List<String> attr1) {
        System.out.println("attr1 = " + attr1);
    }

    @GetMapping("sub13")
    public void sub13() {
    }

    @PostMapping("sub14")
    public String sub14(String id,
                        String password,
                        RedirectAttributes rttr) {
        boolean ok = id.equals(password);
        if (ok) {
            // 로그인 성공시 메인 페이지
            rttr.addFlashAttribute("message", "login success");
            return "redirect:/main22/sub15";
        } else {
            // 로그인 실패시 다시 로그인 페이지
            rttr.addFlashAttribute("message", "id, pw check please");
            return "redirect:/main22/sub13";
        }
    }

    @GetMapping("sub15")
    public void sub15() {
    }

    @GetMapping("sub16")
    public void sub16() {
    }

    @PostMapping("sub17")
    public String sub17(
            String id,
            String password,
            RedirectAttributes rttr
    ) {
        boolean ok = id.equals(password);
        if (ok) {
            rttr.addFlashAttribute("message", "Login Success");
            return "redirect:/main22/sub18";
        } else {
            rttr.addFlashAttribute("message", "Login fail! Please id&pw check");
            return "redirect:/main22/sub16";
        }
    }

    @GetMapping("sub18")
    public void sub18() {
    }


}
