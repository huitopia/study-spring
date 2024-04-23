package com.study.mapper;

import com.study.domain.MyBean281Customer;
import com.study.domain.MyBean283Employees;
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

    @Select("""
            SELECT * FROM Customers WHERE CustomerID = 1
            """)
    MyBean281Customer selectCustomerRead2();

    @Select("""
            SELECT Customers.CustomerID id, 
            Customers.CustomerName name,
            ContactName,
            Address,
            City,
            Country,
            PostalCode
            FROM Customers WHERE CustomerID = 1
            """)
    MyBean281Customer selectCustomerRead3();

    @Select("""
            SELECT
            EmployeeID id,
            LastName,
            FirstName,
            BirthDate,
            Photo,
            Notes
            FROM Employees WHERE EmployeeID = 2
            """)
    MyBean283Employees selectEmployee1();

    @Select("""
            SELECT
            EmployeeID id, LastName, FirstName, 
            BirthDate,
            Photo,
            Notes
            FROM Employees WHERE EmployeeID = #{id} """)
    MyBean283Employees selectEmployee2(Integer id);

    @Select("""
            SELECT Customers.CustomerID id, 
            Customers.CustomerName name,
            ContactName,
            Address,
            City,
            Country,
            PostalCode
            FROM Customers WHERE CustomerID = #{id}
            """)
    MyBean281Customer selectCustomerRead4(Integer id);
}
