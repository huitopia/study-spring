package com.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

@Controller
@RequestMapping("main23")
public class Controller23 {
    @RequestMapping("sub1")
    public void method1(Model model) throws Exception {
        var list = new ArrayList<>();
        // 비즈니스 로직 실행
        String sql = """
                SELECT FirstName FROM Employees
                """;
        // 1. DB 연결
        String url = "jdbc:mariadb://localhost:3306/w3schools";
        String user = "root";
        String password = "";
        Connection con = DriverManager.getConnection(url, user, password);
        // 2. 실행 준비
        Statement statement = con.createStatement();
        // 3. query 실행
        ResultSet resultSet = statement.executeQuery(sql);
        // 5. 자원 닫기
        try (resultSet; statement; con) {
            // 4. 결과 가공
            while (resultSet.next()) {
                String name = resultSet.getString(1); // 첫번째 컬럼의 값 얻음
                list.add(name);
            }
        }
        // 모델에 결과 넣고
        model.addAttribute("nameList", list);
        // view forward
    }

    @RequestMapping("sub2")
    public void method2(Model model) throws Exception {
        String sql = """
                SELECT CustomerName FROM Customers
                """;
        var list = new ArrayList<>();
        // 1. db 연결
        String url = "jdbc:mariadb://localhost:3306/w3schools";
        String user = "root";
        String password = "1024";
        Connection con = DriverManager.getConnection(url, user, password);
        // 2. 실행 준비
        Statement statement = con.createStatement();
        // 3. 쿼리 가공
        ResultSet resultSet = statement.executeQuery(sql);
        // 5. 자원 닫기 - try-with-resources
        try (resultSet; statement; con) {
            // 4. 결과 가공
            while (resultSet.next()) {
                String name = resultSet.getString(1);
                list.add(name);
            }
        }
        // 6. 모델에 attribute 로 결과 넣기
        model.addAttribute("nameList", list);
        // 7. view forward
    }
}
