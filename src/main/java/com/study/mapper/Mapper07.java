package com.study.mapper;

import com.study.domain.MyBean281Customer;
import com.study.domain.MyBean283Employees;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

@Mapper
public interface Mapper07 {
    @Insert("""
            INSERT INTO Employees (LastName, FirstName)
            VALUES (#{lastName},#{firstName})
            """)
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(MyBean283Employees e);

    @Insert("""
            INSERT INTO Customers (CustomerName)
            VALUES (#{name})
            """)
    //  데이터베이스의 자동 생성된 키(일반적으로 PRIMARY KEY)를
    //  자바 객체의 특정 프로퍼티에 매핑하는 데 사용
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert2(MyBean281Customer c);
}
