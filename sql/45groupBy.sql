USE w3schools;

# GROUP BY : 집계함수(avg, sum, count, min, max)를 그룹별로 결과 도출
SELECT CategoryID, COUNT(ProductID)
FROM Products
GROUP BY CategoryID;

# 카테고리별 상품 수
SELECT CategoryID,
       (SELECT c.CategoryName
        FROM Categories c
        WHERE c.CategoryID = p.CategoryID),
       COUNT(ProductID)
FROM Products p
GROUP BY CategoryID;

SELECT c.CategoryID, c.CategoryName, COUNT(p.CategoryID)
FROM Categories c
         JOIN Products p ON c.CategoryID = p.CategoryID
GROUP BY c.CategoryID;

# 1997년 7월 기준 고객별 소비금액을 금액이 높은 순서로 조회
SELECT c.CustomerID,
       c.CustomerName,
       o.OrderDate,
       COUNT(o.OrderID)           totalOrder,
       SUM(p.Price * od.Quantity) customerPrice
FROM Orders o
         JOIN OrderDetails od ON o.OrderID = od.OrderID
         JOIN Products p ON od.ProductID = p.ProductID
         JOIN Customers c ON o.CustomerID = c.CustomerID
WHERE o.OrderDate LIKE '1997-07-__'
GROUP BY c.CustomerID
ORDER BY customerPrice DESC;

# 고객별, 상품별 주문량
SELECT c.CustomerName,
       p.ProductName,
       SUM(od.Quantity) totalOrder
FROM Orders o
         JOIN OrderDetails od ON o.OrderID = od.OrderID
         JOIN Products p ON od.ProductID = p.ProductID
         JOIN Customers c ON o.CustomerID = c.CustomerID
GROUP BY c.CustomerID, p.ProductID
ORDER BY c.CustomerID, totalOrder DESC;

# 국가별, 상품별 주문수량 조회 (국가(asc), 상품판매수(desc) 순 정렬)
SELECT c.Country,
       p.ProductName,
       SUM(od.Quantity) totalOrder
FROM Orders o
         JOIN OrderDetails od ON o.OrderID = od.OrderID
         JOIN Products p ON od.ProductID = p.ProductID
         JOIN Customers c ON o.CustomerID = c.CustomerID
GROUP BY c.Country, p.ProductName
ORDER BY c.Country, totalOrder DESC;

# 상품별, 국가별 주문수량
SELECT p.ProductName,
       c.Country,
       SUM(od.Quantity) totalOrder
FROM Orders o
         JOIN OrderDetails od ON o.OrderID = od.OrderID
         JOIN Products p ON od.ProductID = p.ProductID
         JOIN Customers c ON o.CustomerID = c.CustomerID
GROUP BY p.ProductName, c.Country
ORDER BY p.ProductName, totalOrder DESC;