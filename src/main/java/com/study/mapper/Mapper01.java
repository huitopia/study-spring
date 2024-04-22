package com.study.mapper;

import com.study.domain.MyBean281Customer;
import org.springframework.stereotype.Component;

import java.sql.*;

@Component
public class Mapper01 {
    public MyBean281Customer getCustomerById(Integer id) throws SQLException {
        // connection
        // preparedStatement
        // resultSet
        // Object 생성
        // return
        if (id != null) {
            String sql = """
                    SELECT * FROM Customers
                    WHERE CustomerID = ?
                    """;
            Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/w3schools", "root", "1024");
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

                    return bean;
                }
            }
        }
        return null;
    }
}
