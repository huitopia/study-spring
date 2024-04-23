package com.study.core;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class Application5 {
    public static void main(String[] args) {
        BeanFactory factory = SpringApplication.run(Application5.class, args);
        MyClass51 b1 = factory.getBean(MyClass51.class);
        System.out.println("b1 = " + b1);
        MyClass52 b2 = factory.getBean(MyClass52.class);
        System.out.println("b2 = " + b2);
        Object b3 = factory.getBean("myClass51");
        System.out.println("b3 = " + b3);
        Object b4 = factory.getBean("mybean1");
        System.out.println("b4 = " + b4);
    }
}

/* springBean Name 없으면 클래스명을 lowerCamelCase 로 변경한 이름 사용*/
@Component // SpringBean Create
class MyClass51 {
}

@Component("mybean1") // SpringBean Name Create
class MyClass52 {
}
