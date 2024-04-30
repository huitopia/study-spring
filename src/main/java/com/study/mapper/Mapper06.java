package com.study.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface Mapper06 {
    @Update("""
            UPDATE mydb2.bank
            SET money = money - 500
            WHERE name = '둘둘'
            """)
    int minusMoney();

    @Update("""
            UPDATE mydb2.bank
            SET money = money + 500
            WHERE name = '하나'
            """)
    int plusMoney();
}
