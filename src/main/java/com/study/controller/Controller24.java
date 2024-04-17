package com.study.controller;

import com.study.domain.MyBean241;
import com.study.domain.MyBean242;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

@Controller
@RequestMapping("main24")
public class Controller24 {
    @Autowired
    private DataSource dataSource;

    @GetMapping("sub1")
    public void sub1(Model model) throws Exception {
        String sql = """
                SELECT FirstName, LastName FROM Employees
                """;
        var list = new ArrayList<MyBean241>();
        Connection con = dataSource.getConnection();
        Statement statement = con.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        try (rs; statement; con) {
            while (rs.next()) {
                MyBean241 bean = new MyBean241();
                bean.setFirstName(rs.getString(1));
                bean.setLastName(rs.getString(2));
                list.add(bean);
            }
        }
        model.addAttribute("employees", list);
    }

    @GetMapping("sub2")
    public void sub2(@ModelAttribute("customers") ArrayList<MyBean242> list) throws Exception {
        String sql = """
                SELECT CustomerName, City, Country
                FROM Customers
                """;
        Connection con = dataSource.getConnection();
        Statement statement = con.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        try (resultSet; statement; con) {
            while (resultSet.next()) {
                MyBean242 myBean242 = new MyBean242();
                myBean242.setCustomerName(resultSet.getString(1));
                myBean242.setCity(resultSet.getString(2));
                myBean242.setCountry(resultSet.getString(3));
                list.add(myBean242);
            }
        }
    }

    @RequestMapping("sub3")
    // 고객이 있는 나라들을 중복없이 조회 후 jsp에서 출력
    public void sub3(@ModelAttribute("countries") ArrayList<String> list) throws Exception {
        String sql = """
                SELECT DISTINCT Country
                FROM Customers;
                """;
        
        Statement statement = dataSource.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        try (resultSet; statement) {
            while (resultSet.next()) {
                String country = resultSet.getString(1);
                list.add(country);
            }
        }
    }
}
