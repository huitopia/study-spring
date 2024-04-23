package com.study.core;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class Application6 {
    public static void main(String[] args) {
        BeanFactory factory = SpringApplication.run(Application6.class, args);
        Object b1 = factory.getBean("myBean51");
        System.out.println("b1 = " + b1);
        Object b2 = factory.getBean("myClass62");
        System.out.println("b2 = " + b2);
        Object b3 = factory.getBean(MyClass61.class);
        System.out.println("b3 = " + b3);
        Object b4 = factory.getBean(MyClass62.class);
        System.out.println("b4 = " + b4);

        System.out.println(b1 == b3);
        System.out.println(b2 == b4);
    }
}

// todo: Component 생성
@Component("myBean51")
class MyClass61 {
}

@Component
class MyClass62 {
}