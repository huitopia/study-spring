package com.study.mapper;

import com.study.domain.MyBean281Customer;
import com.study.domain.MyBean283Employees;
import com.study.domain.MyBean284Products;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

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

    @Select("""
            SELECT 
            CustomerID id, 
            CustomerName name,
            ContactName,
            Address,
            City,
            Country,
            PostalCode
            FROM Customers
            """)
        // return type 복수
    List<MyBean281Customer> selectAllCustomer1();

    @Select("""
                       SELECT
            EmployeeID id, LastName, FirstName, BirthDate,Photo,Notes
                       FROM Employees """)
    List<MyBean283Employees> selectAllEmployee1();

    @Select("""
            SELECT CustomerID id, CustomerName name,ContactName,Address,City,Country,PostalCode
            FROM Customers WHERE Country = #{country1} OR Country = #{country2} """)
    List<MyBean281Customer> selectCustomerByCountry(String country1, String country2);

    @Select("""
            SELECT ProductID   id,
                   ProductName name,
                   SupplierID,
                   CategoryID,
                   Unit,
                   Price
            FROM Products
            WHERE Price BETWEEN #{min} AND #{max}
            ORDER BY Price
            """)
    List<MyBean284Products> selectProductByPrice(Double min, Double max);

}
