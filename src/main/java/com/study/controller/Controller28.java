package com.study.controller;

import com.study.domain.MyBean281Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Controller
@RequestMapping("main28")
public class Controller28 {
    @Autowired
    DataSource dataSource;

    @GetMapping("sub1")
    public void method1() {
    }

    @PostMapping("sub1")
    public String method2(
            MyBean281Customer customer
    ) throws SQLException {
        System.out.println("customer = " + customer);
        Connection conn = dataSource.getConnection();
        String sql = """
                INSERT INTO Customers
                (CustomerName, ContactName, Address, City, PostalCode, Country)
                VALUES (?, ?, ?, ?, ?, ?)
                """;
        PreparedStatement ps = conn.prepareStatement(sql);
        try (ps; conn) {
            ps.setString(1, customer.getName());
            ps.setString(2, customer.getContactName());
            ps.setString(3, customer.getAddress());
            ps.setString(4, customer.getCity());
            ps.setString(5, customer.getPostalCode());
            ps.setString(6, customer.getCountry());
            int rowCount = ps.executeUpdate();
        }
        return "redirect:/main28/sub1"; // post 요청 아니고 get 으로 보냄
    }
}
