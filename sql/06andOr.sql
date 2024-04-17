USE w3schools;

#-- and : 여러 조건 만족
#-- or : 하나의 조건 만족
SELECT *
FROM Products
WHERE ProductName LIKE 'a%'
   OR ProductName LIKE 'c%';

SELECT *
FROM Products
WHERE CategoryID = 1
   OR CategoryID = 3
   OR CategoryID = 5;

SELECT *
FROM Products
WHERE SupplierID = 1
  AND CategoryID = 1;

SELECT *
FROM Products
WHERE SupplierID = 2
  AND CategoryID = 2 # 4개
  AND Price > 20;
# 3개

# WHERE 조건을 () 사용해서 우선 순위 결정
SELECT *
FROM Products
WHERE SupplierID = 2
  AND (CategoryID = 2
    OR Price > 20);

# todo : 국가 UK, USA 에 있는 고객들 조회
SELECT *
FROM Customers
WHERE Country = 'uk'
   OR Country = 'usa';
# todo : 도시 madrid, london 에 있는 고객들 조회
SELECT *
FROM Customers
WHERE City = 'madrid'
   or City = 'london';
# todo : 1997년 5월에 주문한 주문 조회
SELECT *
FROM Orders
WHERE OrderDate >= '1997-05-01'
  AND OrderDate < '1997-06-01';

SELECT *
FROM Customers
WHERE CustomerName LIKE '%bes%'
   OR ContactName LIKE '%be%';

SELECT *
FROM Employees
WHERE FirstName LIKE '%a'
   OR LastName LIKE '%a';