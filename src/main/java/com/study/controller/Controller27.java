package com.study.controller;

import com.study.domain.MyBean254;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Controller
@RequestMapping("main27")
public class Controller27 {
    @Autowired
    private DataSource dataSource;

    @GetMapping("sub1")
    public String sub1(Integer page,
                       @ModelAttribute("customerList") ArrayList<MyBean254> list
    ) throws SQLException {
        int offset = (page - 1) * 10;
        String sql = """
                SELECT * FROM Customers
                ORDER BY CustomerID
                LIMIT ?, 10
                """;
        Connection conn = dataSource.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, offset);
        ResultSet rs = ps.executeQuery();
        try (rs; ps; conn) {
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String contactName = rs.getString(2);
                String address = rs.getString(3);
                String city = rs.getString(4);
                String postalCode = rs.getString(5);
                String country = rs.getString(6);
                MyBean254 bean = new MyBean254(id, name, contactName, address, city, postalCode, country);
                list.add(bean);
            }
        }
        return "main27/sub1";
    }
}
