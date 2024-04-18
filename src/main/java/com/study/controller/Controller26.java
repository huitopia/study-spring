package com.study.controller;

import com.study.domain.MyBean255;
import com.study.domain.MyBean261Order;
import com.study.domain.MyBean263Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;

@Controller
@RequestMapping("main26")
public class Controller26 {
    @Autowired
    private DataSource dataSource;

    @GetMapping("sub1")
    public void sub1(String start, String end,
                     @ModelAttribute("orderList") ArrayList<MyBean261Order> list) throws SQLException {
        String sql = """
                SELECT * FROM Orders
                WHERE OrderDate BETWEEN ? AND ?
                """;
        Connection con = dataSource.getConnection();
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, start);
        pstmt.setString(2, end);
        ResultSet rs = pstmt.executeQuery();
        try (rs; pstmt; con) {
            while (rs.next()) {
                Integer id = rs.getInt(1);
                Integer customerId = rs.getInt(2);
                Integer employeeId = rs.getInt(3);
                String date = rs.getString(4);
                Integer shipperId = rs.getInt(5);
                MyBean261Order bean = new MyBean261Order(id, customerId, employeeId, date, shipperId);
                list.add(bean);
            }
        }
    }

    @GetMapping("sub2")
    public void sub2() {
    }

    @GetMapping("sub3")
    public void sub3(@RequestParam(value = "category", required = false) String[] categorySelect,
                     Model model) throws SQLException {
        Connection conn = dataSource.getConnection();
        // 카테고리가 있으면
        if (categorySelect != null && categorySelect.length > 0) {
            String marks = "";
            for (int i = 0; i < categorySelect.length; i++) {
                marks += "?";
                if (i < categorySelect.length - 1) {
                    marks += ",";
                }
            }
            String sql = STR."""
                    SELECT * FROM Products
                    WHERE CategoryId IN (\{marks})
                    ORDER BY CategoryId, Price
                    """;
            PreparedStatement pstmt = conn.prepareStatement(sql);
            for (int i = 0; i < categorySelect.length; i++) {
                pstmt.setString((i + 1), categorySelect[i]);
            }
            ResultSet rs = pstmt.executeQuery();
            var productList = new ArrayList<MyBean255>();
            try (rs; pstmt) {
                while (rs.next()) {
                    Integer id = rs.getInt(1);
                    String name = rs.getString(2);
                    Integer supplierId = rs.getInt(3);
                    Integer categoryId = rs.getInt(4);
                    String unit = rs.getString(5);
                    Double price = rs.getDouble(6);
                    MyBean255 bean = new MyBean255(id, name, supplierId, categoryId, unit, price);
                    productList.add(bean);
                }
                model.addAttribute("prevCategorySelect", categorySelect);
                model.addAttribute("products", productList);
            }
        }
        String categorySql = "SELECT * FROM Categories";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(categorySql);
        var categoryList = new ArrayList<MyBean263Category>();
        try (rs; stmt) {
            while (rs.next()) {
                MyBean263Category category = new MyBean263Category();
                category.setId(rs.getInt(1));
                category.setName(rs.getString(2));
                categoryList.add(category);
            }
            model.addAttribute("categoryList", categoryList);
        }
    }
}
