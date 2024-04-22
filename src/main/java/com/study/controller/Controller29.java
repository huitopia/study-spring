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
@RequestMapping("main29")
public class Controller29 {
    @Autowired
    DataSource dataSource;

    @GetMapping("sub1")
    public void method1(Integer id, Model model) throws SQLException {
        if (id != null) {
            String sql = """
                    SELECT *
                    FROM Customers
                    WHERE CustomerId = ?
                    """;
            Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            try (rs; pstmt; conn) {
                if (rs.next()) {
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

    @PostMapping("sub1/delete")
    public String method2(Integer id,
                          RedirectAttributes rttr) throws SQLException {
        String sql = """
                DELETE FROM Customers
                WHERE CustomerId = ?
                """;
        Connection conn = dataSource.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, id);
        // ResultSet 받을 결과 없음
        try (pstmt; conn) {
            int rowCount = pstmt.executeUpdate();
            if (rowCount > 0) {
                rttr.addFlashAttribute("message", id + "번 고객 삭제 완료");
            } else {
                rttr.addFlashAttribute("message", "삭제 실패");
            }
        }
        return "redirect:/main29/sub1";
    }
}
