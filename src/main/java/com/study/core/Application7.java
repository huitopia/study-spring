package com.study.core;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class Application7 {
    public static void main(String[] args) {
        BeanFactory factory = SpringApplication.run(Application7.class, args);
        Object b1 = factory.getBean(MyClass71.class);
        System.out.println("b1 = " + b1);
        Object b2 = factory.getBean(MyClass72.class);
        System.out.println("b2 = " + b2);
        Object b3 = factory.getBean("someMethod1"); // @Bean 의 이름은 메소드명으로 이름 결정
        System.out.println("b3 = " + b3);
    }
}

@Component
class MyClass71 {
}

@Configuration
class MyConfiguration7 {
    // @Component 붙일 수 없는 클래스로 SpringBean 만들기
    @Bean
    public MyClass72 someMethod1() {
        return new MyClass72();
    }
}

// 가상의 외부 코드
class MyClass72 {
}
