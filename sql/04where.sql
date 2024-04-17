USE w3schools;
# SELECT 에 컬럼명
# FROM 테이블명
# WHERE 뽑아낼 행의 조건
SELECT Customers.CustomerName, City, Country
FROM Customers
# 컬럼명 비교 연산자 값
WHERE City = 'London';

# CustomerID 1번 조회
SELECT *
FROM Customers
WHERE CustomerID = 1;

#-- 비교연산자 : =, <, <=, >, >=, != or <>

# CustomerID 3보다 작음
SELECT *
FROM Customers
WHERE CustomerID < 3;
# CustomerID 5보다 크거나 같음
SELECT *
FROM Customers
WHERE CustomerID >= 50;
# CustomerID 2가 아님
SELECT *
FROM Customers
WHERE CustomerID <> 2;
# CustomerName S 시작
SELECT *
FROM Customers
WHERE CustomerName >= 'S';
# 문자열 형식도 비교 가능하지만 대소문자 구분은 안된다.
SELECT *
FROM Customers
WHERE CustomerName > 's';
# 날짜 형식
SELECT *
FROM Employees
WHERE BirthDate = '1968-12-08';
# 1955-01-01 이후 출생자
SELECT *
FROM Employees
WHERE BirthDate >= '1955-01-01';

# todo : 미국에 있는 Suppliers 조회
SELECT *
FROM Suppliers
WHERE Country = 'USA';
# todo : LastName='Fuller' Employees 조회
SELECT *
FROM Employees
WHERE LastName = 'Fuller';
# todo : CategoryId = 3 Products 조회
SELECT *
FROM Products
WHERE CategoryID = 3;
# todo : Price > 20.00  products 조회
SELECT *
FROM Products
WHERE Price >= 20.00;
# todo : 주문일이 1997년 이전인 Orders 조회
SELECT *
FROM Orders
WHERE OrderDate < '1997-01-01';