package com.study.service;

import com.study.domain.MyBean281Customer;
import com.study.domain.MyBean283Employees;
import com.study.mapper.Mapper07;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
@RequiredArgsConstructor
public class Service03 {
    private final Mapper07 mapper;

    public void insertData() {
        MyBean283Employees e = new MyBean283Employees();
        e.setLastName("박");
        e.setFirstName("바바");
        mapper.insert(e);
        System.out.println(e.getId());
    }

    public void insertData2() {
        MyBean281Customer c = new MyBean281Customer();
        // todo: 새 고객 데이터 입력 하고 id 출력
        c.setName("가나다");
        mapper.insert2(c);
        System.out.println(c.getId());
    }
}
