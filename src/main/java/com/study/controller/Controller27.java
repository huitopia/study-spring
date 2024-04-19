package com.study.controller;

import com.study.domain.MyBean251Employees;
import com.study.domain.MyBean254;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;

@Controller
@RequestMapping("main27")
public class Controller27 {
    @Autowired
    private DataSource dataSource;

    @GetMapping("sub1")
    public String sub1(@RequestParam(defaultValue = "1") Integer page,
                       Model model
    ) throws SQLException {
        int offset = (page - 1) * 10;
        String sql = """
                SELECT * 
                FROM Customers
                ORDER BY CustomerID
                LIMIT ?, 10
                """;
        var list = new ArrayList<MyBean254>();
        Connection conn = dataSource.getConnection();
        // 페이지 정보 산출
        // 총 레코드 수 조회
        String countSql = "SELECT COUNT(*) FROM Customers";
        Statement stmt = conn.createStatement();
        ResultSet rs1 = stmt.executeQuery(countSql);
        int total = 0;
        try (rs1; stmt) {
            if (rs1.next()) {
                total = rs1.getInt(1);
            }
        }
        // lastPageNumber
        int lastPageNumber = (total - 1) / 10 + 1;
        model.addAttribute("lastPageNumber", lastPageNumber);
        // 페이지 링크의 begin, end 산출
        int endPageNumber = (((page - 1) / 10) + 1) * 10;
        int beginPageNumber = endPageNumber - 9;
        // end 산출
        // endPageNumber 는 최종 페이지를 넘을 수 없다.
        endPageNumber = Math.min(endPageNumber, lastPageNumber);
        model.addAttribute("endPageNumber", endPageNumber);
        model.addAttribute("beginPageNumber", beginPageNumber);
        // nextPageNumber
        int nextPageNumber = beginPageNumber + 10;
        if (nextPageNumber <= lastPageNumber) {
            model.addAttribute("nextPageNumber", nextPageNumber);
        }
        // prevPageNumber
        int prevPageNumber = beginPageNumber - 10;
        if (prevPageNumber >= 1) {
            model.addAttribute("prevPageNumber", prevPageNumber);
        }
        // 현재 페이지
        model.addAttribute("currentPage", page);
        // 고객 레코드 조회
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
        model.addAttribute("customerList", list);
        return "main27/sub1";
    }

    // todo : 직원 테이블 조회 (paging 처리) 메소드와 jsp 작성
    @GetMapping("sub2")
    public String sub2(@RequestParam(defaultValue = "1") Integer page,
                       Model model
    ) throws SQLException {
        // DB 연결
        Connection conn = dataSource.getConnection();
        //-- 페이징 시작
        // 총 게시물 수
        String countSql = "SELECT COUNT(*) FROM Employees";
        // 고정 SQL
        Statement stmt = conn.createStatement();
        ResultSet rs1 = stmt.executeQuery(countSql);
        int total = 0; // COUNT 담을 int 생성
        try (rs1; stmt) {
            // COUNT index = 1
            if (rs1.next()) {
                total = rs1.getInt(1);
            }
        }
        // lastPageNumber
        int lastPageNumber = (total - 1) / 10 + 1;
        model.addAttribute("lastPageNumber", lastPageNumber);

        // begin / end
        // Integer 나누기 연산은 소수자리 안 낌
        int endPageNumber = (((page - 1) / 10) + 1) * 10;
        int beginPageNumber = endPageNumber - 9;
        //
        // endPageNumber 는 최종 페이지를 넘을 수 없음
        endPageNumber = Math.min(endPageNumber, lastPageNumber);

        model.addAttribute("beginPageNumber", beginPageNumber);
        model.addAttribute("endPageNumber", endPageNumber);

        // prevPageNumber
        int prevPageNumber = beginPageNumber - 10;
        if (prevPageNumber >= 1) { // page = 11 -> prevPageNumber = 1
            model.addAttribute("prevPageNumber", prevPageNumber);
        }
        // nextPageNumber
        int nextPageNumber = beginPageNumber + 10;
        if (nextPageNumber < lastPageNumber) {
            model.addAttribute("nextPageNumber", nextPageNumber);
        }
        // currentPage
        model.addAttribute("currentPage", page);
        //-- 페이징 끝
        //-- Employees 조회 시작
        int offset = (page - 1) * 10;
        String sql = """
                SELECT *
                FROM Employees
                ORDER BY EmployeeID
                LIMIT ?, 10
                """;
        var list = new ArrayList<MyBean251Employees>();
        PreparedStatement ps = conn.prepareStatement(sql);
        // parameter 받은 값 ? 에 넣기
        ps.setInt(1, offset);
        ResultSet rs2 = ps.executeQuery();
        try (rs2; ps; conn) {
            while (rs2.next()) {
                Integer id = rs2.getInt(1);
                String lastName = rs2.getString(2);
                String firstName = rs2.getString(3);
                String birthDate = rs2.getString(4);
                String photo = rs2.getString(5);
                String notes = rs2.getString(6);
                MyBean251Employees bean = new MyBean251Employees(id, lastName, firstName, birthDate, photo, notes);
                list.add(bean);
            }
        }
        model.addAttribute("employeeList", list);
        return "main27/sub2";
    }
}
