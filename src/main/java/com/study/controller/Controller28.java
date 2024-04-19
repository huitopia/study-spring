package com.study.controller;

import com.study.domain.MyBean281Customer;
import com.study.domain.MyBean283Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;

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
            MyBean281Customer customer,
            RedirectAttributes rttr
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
            if (rowCount == 1) {
                rttr.addFlashAttribute("message", "new customer add");
            }
        }
        return "redirect:/main28/sub1"; // post 요청 아니고 get 으로 보냄
    }

    // todo: 새 직원 입력하기
    @GetMapping("sub2")
    public void method3(Model model) throws SQLException {
        if (model.containsAttribute("message")) {
            Connection conn = dataSource.getConnection();
            String sql = """
                    SELECT *
                    FROM Employees
                    ORDER BY EmployeeID DESC
                    LIMIT 1
                    """;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            var list = new ArrayList<MyBean283Employees>();
            try (rs; stmt; conn) {
                if (rs.next()) {
                    MyBean283Employees bean = new MyBean283Employees();
                    bean.setId(rs.getInt(1));
                    bean.setLastName(rs.getString(2));
                    bean.setFirstName(rs.getString(3));
                    bean.setBirthDate(rs.getString(4));
                    bean.setPhoto(rs.getString(5));
                    bean.setNotes(rs.getString(6));
                    list.add(bean);
                }
            }
            model.addAttribute("employees", list);
        }
    }

    @PostMapping("sub2")
    public String method4(MyBean283Employees employees,
                          RedirectAttributes rttr) throws SQLException {
        String sql = """
                INSERT INTO Employees (LastName, FirstName, BirthDate, Photo, Notes) 
                VALUES (?, ?, ?, ?, ?)
                """;
        Connection conn = dataSource.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        try (ps; conn) {
            ps.setString(1, employees.getLastName());
            ps.setString(2, employees.getFirstName());
            ps.setString(3, employees.getBirthDate());
            ps.setString(4, employees.getPhoto());
            ps.setString(5, employees.getNotes());
            int rowCount = ps.executeUpdate();
            if (rowCount == 1) {
                rttr.addFlashAttribute("message", "new employees create success");
            }
        }
        return "redirect:/main28/sub2";
    }
}
