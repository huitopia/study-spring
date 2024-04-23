package com.study.core;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

// component scan : 현재 클래스가 속한 패키지와 그 하위 패키지를 모두 탐색
// @Component 붙은 클래스의 객체를 생성하고 조직함(dependency Injection)
@SpringBootApplication
public class Application2 {
    public static void main(String[] args) {
        // run() : main method 가 있는 class 안에 class 객체?
        BeanFactory beanFactory = SpringApplication.run(Application2.class);
        Dao2 bean1 = beanFactory.getBean(Dao2.class);
        Controller2 bean2 = beanFactory.getBean(Controller2.class);
        System.out.println("bean1 : " + System.identityHashCode(bean1));
        System.out.println("bean2 : " + System.identityHashCode(bean2));
    }
}

@Component
class Dao2 {
}

@Component
class Controller2 {
}

