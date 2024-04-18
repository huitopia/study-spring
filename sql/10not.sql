USE w3schools;

# not : 조건을 만족하지 않으면 TRUE
SELECT *
FROM Employees
WHERE NOT BirthDate >= '1960-01-01';

SELECT *
FROM Customers
WHERE NOT Country IN ('Italy', 'France')
ORDER BY Country;

SELECT *
FROM Products
WHERE Price NOT BETWEEN 50 AND 200
ORDER BY Price DESC;

# 여러 조건 사용시 괄호 잘 사용하기
SELECT *
FROM Products
WHERE (NOT CategoryID = 1)
  AND Price > 50
ORDER BY CategoryID, Price;

# todo: 1997년 주문을 제외하고 주문 조회
SELECT *
FROM Orders
WHERE NOT OrderDate BETWEEN '1997-01-01' AND '1997-12-31';

# todo: 국가가 UK, USA 아닌 공급자 조회
SELECT *
FROM Suppliers
WHERE NOT Country IN ('UK', 'USA');
