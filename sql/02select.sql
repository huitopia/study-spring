USE w3schools;

SELECT *
FROM Customers;

# 특정 컬럼만 조회
# SELECT column, column FROM Table
SELECT CustomerName, City
FROM Customers;

# 모든 컬럼 조회
# SELECT * FROM table
SELECT *
FROM Customers;

# 테이블의 컬럼들 조회
# DESCRIBE table
DESC Customers;

# todo : Employees table select filed list
DESC Employees;
# todo : Employees table select firstname, lastname field
SELECT FirstName, LastName
FROM Employees;
# SELECT 에 나열한 컬럼명의 순서대로 결과가 나옴
# SELECT table.filed ➡ 2개 이상의 테이블을 조회할 때
