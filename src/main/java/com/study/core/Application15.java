package com.study.core;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class Application15 {
    public static void main(String[] args) {
        BeanFactory bf = SpringApplication.run(Application15.class, args);
        MyClass152 d = bf.getBean(MyClass151.class).getDependency();
        System.out.println("d = " + d);
    }
}

@Component
@Getter
@RequiredArgsConstructor
class MyClass151 {
    private final MyClass152 dependency;
}

@Component
class MyClass152 {
}
