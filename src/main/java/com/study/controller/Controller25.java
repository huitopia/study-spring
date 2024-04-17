package com.study.controller;

import com.study.domain.MyBean251;
import com.study.domain.MyBean252;
import com.study.domain.MyBean254;
import com.study.domain.MyBean255;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;

@Controller
@RequestMapping("main25")
public class Controller25 {
    @Autowired
    private DataSource dataSource;

    @GetMapping("sub1")
    public void sub1(
            @RequestParam(value = "name", required = false)
            String searchName,
            @ModelAttribute("employees")
            ArrayList<MyBean251> list
    ) throws SQLException {
        String sql = STR."""
                SELECT * FROM Employees WHERE LastName = '\{searchName}'
                """;
        Statement statement = dataSource.getConnection()
                .createStatement();
        ResultSet rs = statement.executeQuery(sql);
        try (rs; statement) {
            while (rs.next()) {
                String id = rs.getString(1);
                String lastName = rs.getString(2);
                String firstName = rs.getString(3);
                String birthDate = rs.getString(4);
                String photo = rs.getString(5);
                String notes = rs.getString(6);

                MyBean251 obj = new MyBean251(id, lastName, firstName, birthDate, photo, notes);
                list.add(obj);
            }
        }
    }

    @GetMapping("sub2")
    public void sub2(@RequestParam(value = "name", required = false)
                     String search,
                     @ModelAttribute("products")
                     ArrayList<MyBean252> list
    ) throws SQLException {
        // todo : name 요청 파라미터와 일치하는 상품명으로 상품 조회
        String sql = STR."""
                SELECT * From Products WHERE ProductName = '\{search}'
                """;
        Statement statement = dataSource.getConnection().createStatement();
        ResultSet rs = statement.executeQuery(sql);
        try (rs; statement) {
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String unit = rs.getString(5);
                double price = rs.getDouble(6);
                MyBean252 bean = new MyBean252(id, name, unit, price);
                list.add(bean);
            }
        }
    }

    @GetMapping("sub3")
    public void sub3(@RequestParam(value = "name", required = false)
                     String search,
                     @ModelAttribute("products") ArrayList<MyBean252> list
    ) throws SQLException {
        String sql = """
                SELECT * FROM Products
                WHERE ProductName = ?        
                """;
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        // first parameter : ?
        // second parameter : push result
        preparedStatement.setString(1, search);
        ResultSet resultSet = preparedStatement.executeQuery();
        try (resultSet; preparedStatement; connection) {
            while (resultSet.next()) {
                MyBean252 row = new MyBean252(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(5),
                        resultSet.getDouble(6)
                );
                list.add(row);
            }
        }
    }

    @GetMapping("sub4")
    public void sub4(@RequestParam(value = "name", required = false)
                     String search,
                     @ModelAttribute("customers") ArrayList<MyBean254> list
    ) throws SQLException {
        // todo : 고객 이름을 입력 받아서 고객 정보 조회
        String sql = """
                SELECT *
                FROM Customers
                WHERE CustomerName LIKE ?
                """;
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, "%" + search + "%");
        ResultSet resultSet = preparedStatement.executeQuery();
        try (resultSet; preparedStatement; connection) {
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String contactName = resultSet.getString(3);
                String address = resultSet.getString(4);
                String city = resultSet.getString(5);
                String postalCode = resultSet.getString(6);
                String country = resultSet.getString(7);
                MyBean254 bean = new MyBean254(id, name, contactName, address, city, postalCode, country);
                list.add(bean);
            }
        }
    }

    // todo : 상품명 조회 메소드 작성
    @GetMapping("sub5")
    public void sub5(@RequestParam(value = "search", required = false) String search,
                     @ModelAttribute("products") ArrayList<MyBean255> list) throws SQLException {
        String sql = """
                SELECT * FROM Products WHERE ProductName LIKE ?
                """;
        String keyword = "%" + search + "%";
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, keyword);
        ResultSet resultSet = preparedStatement.executeQuery();
        try (resultSet; preparedStatement; connection) {
            while (resultSet.next()) {
                Integer id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                Integer supplierId = resultSet.getInt(3);
                Integer categoryId = resultSet.getInt(4);
                String unit = resultSet.getString(5);
                Double price = resultSet.getDouble(6);
                MyBean255 bean = new MyBean255(id, name, supplierId, categoryId, unit, price);
                list.add(bean);
            }
        }
    }
}
