package com.study.mapper;

import lombok.Data;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface Mapper05 {


    @Data
    static class EmployeeIncome {
        private Integer employeeId;
        private String lastName;
        private String firstName;
        private Double income;
    }

    @Select("""
            SELECT e.EmployeeId,
                   e.LastName,
                   e.FirstName,
                   SUM(od.Quantity * p.Price) AS income
            FROM Orders o JOIN Employees e ON o.EmployeeId = e.EmployeeId
                          JOIN OrderDetails od ON o.OrderId = od.OrderId
                          JOIN Products p ON od.ProductId = p.ProductId
            WHERE o.OrderDate BETWEEN #{from} AND #{to}
            GROUP BY e.EmployeeId
            ORDER BY income DESC
            """)
    List<EmployeeIncome> selectIncomeList(String from, String to);

    @Data
    public class CustomerPrice {
        private String customerName;
        private String orderDate;
        private Double customerPrice;
    }

    @Select("""
            SELECT c.CustomerName,
                   o.OrderDate,
                   SUM(p.Price * od.Quantity) customerPrice
            FROM Orders o
                     JOIN Customers c ON o.CustomerID = c.CustomerID
                     JOIN OrderDetails od ON od.OrderID = o.OrderID
                     JOIN Products p ON od.ProductID = p.ProductID
            WHERE o.OrderDate LIKE #{from}
            GROUP BY c.CustomerID
            ORDER BY customerPrice DESC
            """)
    List<CustomerPrice> selectPriceList(String from);

}