package com.study.mapper;

import com.study.domain.MyBean281Customer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface Mapper02 {
    @Select("SELECT NOW()")
    public String selectNow(); // 추상 메소드는 {} X

    // 조회 결과의 field 와 리턴타입의 객체 프로퍼티명이 같으면 값을 바인딩 함
    @Select("""
            SELECT CustomerID,CustomerName,ContactName,Address,City,Country 
            FROM Customers 
            WHERE CustomerID = 1
            """)
    MyBean281Customer selectCustomerRead();
}
