package com.study.service;

import com.study.domain.MyBean283Employees;
import com.study.mapper.Mapper08;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class Service04 {
    private final Mapper08 mapper;

    public void action01() {
        mapper.query1();
    }

    public void action02() {
        MyBean283Employees e = new MyBean283Employees();
//        e.setLastName("키키");
        mapper.query2(e);
    }

    public void action03() {
        MyBean283Employees e = new MyBean283Employees();
        e.setFirstName("lee");
        mapper.query3(e);
    }

    public void action04() {
        MyBean283Employees e = new MyBean283Employees();
        e.setFirstName("kim");
//        e.setFirstName("lee");
        mapper.query4(e);
    }

    public void action05() {
        MyBean283Employees e = new MyBean283Employees();
        e.setLastName("chae");
        e.setFirstName("jjok");
        mapper.query5(e);
    }

    public void action06(String keyword) {
        List<MyBean283Employees> e = mapper.query6(keyword);
        e.forEach(System.out::println);
    }

    public void action07() {
        mapper.query7();
    }
}
