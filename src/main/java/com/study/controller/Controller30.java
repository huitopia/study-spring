package com.study.controller;

import com.study.domain.MyBean281Customer;
import com.study.domain.MyBean283Employees;
import com.study.mapper.Mapper01;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Controller
@RequestMapping("main30")
public class Controller30 {
    @Autowired
    private DataSource dataSource;
    // dependency
//    private Mapper01 mapper01 = new Mapper01();
    // Inversion of Control
    @Autowired
    private Mapper01 mapper01;

    @GetMapping("sub1")
    public void method1(Integer id, Model model) throws SQLException {
        MyBean281Customer bean = mapper01.getCustomerById(id);
        model.addAttribute("customer", bean);
    }

    @PostMapping("sub1/update")
    public String method2(MyBean281Customer customer, RedirectAttributes rttr) throws SQLException {
        String sql = """
                UPDATE Customers
                SET CustomerName = ?,
                    ContactName = ?,
                    Address = ?,
                    City = ?,
                    PostalCode = ?,
                    Country = ?
                WHERE CustomerID = ?
                """;
        Connection conn = dataSource.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        try (pstmt; conn) {
            pstmt.setString(1, customer.getName());
            pstmt.setString(2, customer.getContactName());
            pstmt.setString(3, customer.getAddress());
            pstmt.setString(4, customer.getCity());
            pstmt.setString(5, customer.getPostalCode());
            pstmt.setString(6, customer.getCountry());
            pstmt.setInt(7, customer.getId());

            int rowCount = pstmt.executeUpdate();
            if (rowCount > 0) {
                rttr.addFlashAttribute("message", customer.getId() + "번 고객이 수정되었습니다.");
            } else {
                rttr.addFlashAttribute("message", "수정되지 않았습니다.");
            }
        }
        rttr.addAttribute("id", customer.getId());
        return "redirect:/main30/sub1";
    }

    // todo: 직원 조회 및 수정
    @GetMapping("sub2")
    public void method3(Integer id, Model model) throws SQLException {
        if (id != null) {
            String sql = """
                    SELECT * FROM Employees
                    WHERE EmployeeID = ?
                    """;
            Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            try (rs; pstmt; conn) {
                while (rs.next()) {
                    MyBean283Employees bean = new MyBean283Employees();
                    bean.setId(rs.getInt(1));
                    bean.setLastName(rs.getString(2));
                    bean.setFirstName(rs.getString(3));
                    bean.setBirthDate(rs.getString(4));
                    bean.setPhoto(rs.getString(5));
                    bean.setNotes(rs.getString(6));
                    model.addAttribute("employee", bean);
                }
            }
        }
    }

    @PostMapping("sub2/update")
    public String method4(MyBean283Employees employee,
                          RedirectAttributes rttr
    ) throws SQLException {
        String sql = """
                UPDATE Employees
                SET LastName = ?,
                FirstName = ?,
                BirthDate = ?,
                Photo = ?,
                Notes = ?
                WHERE EmployeeID = ?
                """;
        Connection conn = dataSource.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, employee.getFirstName());
        pstmt.setString(2, employee.getLastName());
        pstmt.setString(3, employee.getBirthDate());
        pstmt.setString(4, employee.getPhoto());
        pstmt.setString(5, employee.getNotes());
        pstmt.setInt(6, employee.getId());
        int rowCount = pstmt.executeUpdate();
        if (rowCount > 0) {
            rttr.addFlashAttribute("message", employee.getId() + " UPDATE Success");
        } else {
            rttr.addFlashAttribute("message", employee.getId() + " UPDATE Fail");
        }
        rttr.addAttribute("id", employee.getId());
        return "redirect:/main30/sub2";
    }
}
