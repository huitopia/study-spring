USE w3schools;
# -- WildCard
# - : 한글자 아무거나
# % : 0개 이상의 글자 아무거나
SELECT *
FROM Products
WHERE ProductName LIKE '%ca%';
# 7월 포함 조회
SELECT *
FROM Orders
WHERE OrderDate LIKE '____-07-__';
# cha%로 시작 조회
SELECT *
FROM Products
WHERE ProductName LIKE 'cha%';
# todo: anton 이 포함된 상품명을 가진 상품 조회
SELECT *
FROM Products
WHERE ProductName LIKE '%anton%';
# todo: b로 시작하는 고객명을 가진 고객들 조회
SELECT *
FROM Customers
WHERE CustomerName LIKE 'b%';
# todo: a로 끝나는 나라에 있는 고객들 조회
SELECT *
FROM Customers
WHERE Country LIKE '%a';
# todo: 1일에 주문된 주문 조회
SELECT *
FROM Orders
WHERE OrderDate LIKE '____-__-_1';

SELECT *
FROM Products;