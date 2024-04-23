package com.study.core;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class Application8 {
    public static void main(String[] args) {
        BeanFactory factory = SpringApplication.run(Application8.class, args);
        MyClass81 b1 = factory.getBean(MyClass81.class);
        MyClass82 b2 = factory.getBean(MyClass82.class);
        Object b3 = factory.getBean("myBean81");
        Object b4 = factory.getBean("myBean82");
        System.out.println(b1 == b3);
        System.out.println(b2 == b4);
    }
}

// todo: @Configuration 클래스와 @Bean 메소드 2개 작성
@Component("myBean81")
class MyClass81 {
}

@Configuration
class Configuration82 {
    @Bean("myBean82") // Bean Name
    public MyClass82 myClass82() {
        return new MyClass82();
    }
}

class MyClass82 {
}
