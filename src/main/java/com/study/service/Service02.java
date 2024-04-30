package com.study.service;

import com.study.mapper.Mapper06;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
// service 내의 모든 method 적용 가능
@Transactional(rollbackFor = Exception.class)
public class Service02 {
    private final Mapper06 mapper;

    public void transferMoney1() {
        // - 500
        mapper.minusMoney();
        // + 500
        mapper.plusMoney();
    }

    @Transactional
    public void transferMoney2() {
        mapper.minusMoney();
        if (true) {
            throw new RuntimeException();
        }
    }

    // check Exception roll back X
    @Transactional
    public void transferMoney3() throws Exception {
        mapper.minusMoney();
        if (true) {
            throw new Exception();
        }
    }

    // check Exception 설정
    @Transactional(rollbackFor = Exception.class)
    public void transferMoney4() throws Exception {
        mapper.minusMoney();
        if (true) {
            throw new Exception();
        }
    }

    @Transactional
    public void transferMoney5() {
        mapper.minusMoney();

        try { // Exception 발생하면 RuntimeException 으로 보냄
            if (true) {
                throw new Exception();
            }
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
