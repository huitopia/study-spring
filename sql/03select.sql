USE w3schools;
# field 나열 순서대로 조회됨
SELECT CustomerName, City
FROM Customers;

# DISTINCT: 중복 제거
SELECT DISTINCT Country
From Customers;

SELECT DISTINCT Customers.City, Customers.Country
From Customers;

# COUNT: raw 수 구하는 내장 함수
SELECT COUNT(City)
FROM Customers;

# 중복 제거 한 수
SELECT COUNT(DISTINCT City)
FROM Customers;

SELECT DISTINCT Customers.Country
FROM Customers;
