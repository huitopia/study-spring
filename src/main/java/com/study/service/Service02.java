package com.study.service;

import com.study.mapper.Mapper06;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
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
}
