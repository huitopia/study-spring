SELECT *
FROM w3schools.Employees;
SELECT *
FROM w3schools.Customers;
CREATE DATABASE test1;
CREATE TABLE test1.test
(
    id   int,
    name varchar(20)
);
# DATABASE NAME.TABLE NAME
SELECT *
FROM test1.test;
# 현재 사용중인 DATABASE 선택
USE test1;
# 현재 DB의 table 은 DB명 생략 가능
SELECT *
FROM test;
# 다른 DB의 table 은 생략 불가
SELECT *
FROM w3schools.Customers;

USE w3schools;
SELECT *
FROM Customers;

