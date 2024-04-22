package com.study.controller;

import com.study.domain.MyBean281Customer;
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

    @GetMapping("sub1")
    public void method1(Integer id, Model model) throws SQLException {
        if (id != null) {
            String sql = """
                    SELECT * FROM Customers
                    WHERE CustomerID = ?
                    """;
            Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            try (rs; ps; conn) {
                while (rs.next()) {
                    MyBean281Customer bean = new MyBean281Customer();
                    bean.setId(rs.getInt(1));
                    bean.setName(rs.getString(2));
                    bean.setContactName(rs.getString(3));
                    bean.setAddress(rs.getString(4));
                    bean.setCity(rs.getString(5));
                    bean.setPostalCode(rs.getString(6));
                    bean.setCountry(rs.getString(7));

                    model.addAttribute("customer", bean);
                }
            }
        }
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
}
