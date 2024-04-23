package com.study.core;

import lombok.Getter;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class Application10 {
    public static void main(String[] args) {
        BeanFactory factory = SpringApplication.run(Application10.class, args);
        MyClass101 bean = factory.getBean(MyClass101.class);
        MyClass102 field = bean.getField();
        System.out.println("field = " + field);
    }
}

// todo: 적절한 annotation 작성
@Component
@Getter
class MyClass101 {
    @Autowired
    private MyClass102 field;
}

@Component
class MyClass102 {
}
