package com.study.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api/main43")
public class Controller43 {
    // ResponseEntity 상태코드를 직접 명시해서 응답할 때
    @GetMapping("sub1")
    @ResponseBody // ResponseEntity 응답일땐 생략 가능
    public ResponseEntity method1() {
        return ResponseEntity.status(200).build();
    }

    @GetMapping("sub2")
    public ResponseEntity method2() {
        return ResponseEntity.status(400).build();
    }

    @GetMapping("sub3")
    public ResponseEntity method3() {
        return ResponseEntity.status(403).build();
    }

    @GetMapping("sub4")
    public ResponseEntity method4() {
        return ResponseEntity.status(401).build();
    }

    @GetMapping("sub5")
    public ResponseEntity method5() {
        return ResponseEntity.status(404).build();
    }

    @GetMapping("sub6")
    public ResponseEntity method6() {
        return ResponseEntity.status(500).build();
    }
}
