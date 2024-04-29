USE w3schools;

# 1행 1열 결과 (scalar)
SELECT AVG(Price)
FROM Products;

SELECT *
FROM Products
WHERE Price >= (SELECT AVG(Price)
                FROM Products);

# todo: 1번 카테고리 상품의 평균가격보다 높은 2번 카테고리 상품명 조회
SELECT ProductName, Price
FROM Products
WHERE CategoryID = 2
  AND Price > (SELECT AVG(Price)
               FROM Products
               WHERE CategoryID = 1);

# 여러행 1열 결과
SELECT CustomerID
FROM Customers
WHERE Country = 'mexico';

# mexico 고객이 주문한 건들 조회
SELECT *
FROM Orders
WHERE CustomerID IN (SELECT CustomerID
                     FROM Customers
                     WHERE Country = 'mexico');

# todo: 1번 카테고리 상품들이 주문된 날짜들 조회
SELECT ProductID
FROM Products
WHERE CategoryID = 1;
SELECT o.OrderDate
FROM Orders o
         JOIN OrderDetails od ON o.OrderID = od.OrderID
WHERE od.ProductID IN (SELECT ProductID
                       FROM Products
                       WHERE CategoryID = 1);

SELECT o.OrderDate
FROM Orders o
         JOIN OrderDetails od
              ON o.OrderID = od.OrderID
         JOIN Products p
              ON od.ProductID = p.ProductID
WHERE p.CategoryID = 1;

# 여러행 여러열 결과
SELECT City, Country
FROM Customers
WHERE CustomerID IN (1, 2);

SELECT CustomerName
FROM Customers
WHERE (City, Country) IN (('Berlin', 'Germany'),
                          ('México D.F.', 'Mexico'));

SELECT CustomerName
FROM Customers
WHERE (City, Country) IN (SELECT City, Country
                          FROM Customers
                          WHERE CustomerID IN (1, 2));

# 상관서브쿼리(속도가 좀 느린편, 조인으로 해결할 수 있는 지 고민)
# 외부쿼리의 값이 내부 쿼리에 사용될 때

# 각 고객의 주문 횟수
SELECT c.CustomerName, COUNT(o.OrderID) orderCount
FROM Customers c
         JOIN Orders o ON o.CustomerID = c.CustomerID
GROUP BY c.CustomerName;

# todo: 각 상품별 총 매출금액
# 1
SELECT p.ProductID,
       p.ProductName,
       SUM(p.Price * od.Quantity) totalPrice
FROM Products p
         JOIN OrderDetails od ON p.ProductID = od.ProductID
GROUP BY p.ProductID;
# 2
SELECT ProductID,
       ProductName,
       (SELECT SUM(od.Quantity)
        FROM OrderDetails od
        WHERE od.ProductID = p.ProductID) * p.Price AS 매출액
FROM Products p;