package com.study.mapper;

import com.study.domain.MyBean283Employees;
import com.study.domain.MyBean284Products;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface Mapper08 {
    @Select("""
            <script>
            SELECT * FROM Employees
            WHERE LastName = 'abc'
                <if test="false">
                OR FirstName = 'abc'
                </if>
            </script>
            """)
    List<MyBean283Employees> query1();

    @Select("""
            <script>
                SELECT * FROM my_table1
                <if test="lastName != null">
                -- not null
                </if>
                <if test="lastName == null">
                -- null
                </if>
            </script>
            """)
    List<MyBean283Employees> query2(MyBean283Employees e);

    @Select("""
            SELECT * FROM my_table2
            <script>
                <if test="firstName == 'lee'">
                 -- firstName 이 lee 일때 포함되는 코드
                </if>
                <if test="firstName != 'lee'">
                 -- firstName 이 lee 가 아니면 포함되는 코드
                </if>
            </script>
            """)
    List<MyBean283Employees> query3(MyBean283Employees e);

    @Select("""
            <script>
            SELECT * FROM my_table1
                <if test="firstName == null">
                -- firstName == null
                </if>
                <if test="firstName != null">
                -- firstName != null
                </if>
                <if test='firstName == "kim"'>
                -- firstName == kim
                </if>
                <if test='firstName == "lee"'>
                -- firstName == lee
                </if>
            </script>
            """)
    Object query4(MyBean283Employees e);

    @Select("""
            <script>
            SELECT * FROM my_table
                <trim prefix="WHERE" prefixOverrides="OR">
                    <if test="lastName != null">
                        OR LastName = #{lastName}
                    </if>
                    <if test="firstName != null">
                         FirstName = #{firstName}
                    </if>
                </trim>
            </script>
            """)
    Object query5(MyBean283Employees e);

    @Select("""
            <script>
                <bind name="patternKeyword" value ='"%" + keyword + "%"'/>
                SELECT * FROM Employees
                WHERE notes LIKE #{patternKeyword}
            </script>
            """)
    List<MyBean283Employees> query6(String keyword);

    @Select("""
            <script>
            <![CDATA[
            SELECT * FROM Products
            WHERE Price < 5
            ]]>
            </script>
            """)
    List<MyBean284Products> query7();
}
