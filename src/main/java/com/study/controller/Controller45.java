package com.study.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/api/main45")
@RequiredArgsConstructor
public class Controller45 {

    @PostMapping("sub1")
    @ResponseBody
    public String sub1(@RequestParam("name") String name,
                       @RequestParam("file") MultipartFile file) throws IOException {
        System.out.println("name = " + name);
        System.out.println("file = " + file.getOriginalFilename());
        String path = "/Users/hya/IdeaProjects/study-spring/src/main/resources/templates/" + file.getOriginalFilename();
        file.transferTo(new File(path));
        return null;
    }
}
