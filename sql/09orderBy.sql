# order by : 조회 순서 결정
# order by field
USE w3schools;

SELECT *
FROM Products
ORDER BY Price;
# ASC : 오름차순
SELECT *
FROM Products
ORDER BY Price ASC;

# DESC : 내림차순
SELECT *
FROM Products
ORDER BY Price DESC;

# 여러 필드 기준
# ORDER BY A, B > A 정렬 후 A 안에서 B 정렬
SELECT *
FROM Products
ORDER BY CategoryID, Price;

# 오름차순 생략 가능
SELECT *
FROM Products
# ORDER BY CategoryID ASC, Price DESC;
ORDER BY CategoryID, Price DESC;

# 컬럼명 대신 컬럼 index
SELECT *
FROM Products
ORDER BY 4;
# 4번째인 CategoryID 기준으로 정렬

# SELECT 에 명시한 필드명의 순서를 따라야함
SELECT ProductName, CategoryID, Price, Unit
FROM Products
# ORDER BY CategoryID, Price;
ORDER BY 2, 3;

# todo: 나이가 많은 직원부터 나이가 적은 직원순으로 직원 조회
SELECT *
FROM Employees
ORDER BY BirthDate;

# todo: 국가명, 도시명 순서로 고객 조회
SELECT *
FROM Customers
ORDER BY Country, City;

# todo: 도시명 순으로 공급자 조회
SELECT *
FROM Suppliers
ORDER BY City;

# todo: FirstName 역순으로 직원 조회
SELECT *
FROM Employees
ORDER BY FirstName DESC;