package com.study.mapper;

import com.study.domain.MyBean281Customer;
import com.study.domain.MyBean283Employees;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface Mapper03 {
    // CustomerID 1번 고객 삭제
    @Delete("""
            DELETE FROM Customers WHERE CustomerID = 1             
            """)
    int deleteOneCustomer();

    // CustomerID ? 번 고객 삭제
    @Delete("""
            DELETE FROM Customers WHERE CustomerID = #{id}
            """)
    int deleteOneCustomerById(Integer id);

    @Delete("""
            DELETE FROM Employees WHERE EmployeeID = #{eid}
            """)
    int deleteOneCustomerById1(Integer eid);

    @Insert("""
            INSERT INTO Customers (CustomerName, ContactName, Address, City, PostalCode, Country)
            VALUES (#{name},#{contactName},#{address},#{city},#{postalCode},#{country})
            """)
    int insertCustomer(MyBean281Customer customer);

    @Insert("""
            INSERT INTO Employees (LastName, FirstName, BirthDate, Photo, Notes) 
            VALUES (#{lastName},#{firstName},#{birthDate},#{photo},#{notes})
            """)
    int insertEmployee(MyBean283Employees employee);
}
