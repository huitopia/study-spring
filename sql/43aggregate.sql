USE w3schools;

# 1번 카테고리 상품의 평균 가격은?
SELECT AVG(Price)
FROM Products
WHERE CategoryID = 1;

# 1번 상품의 총 판매 갯수
SELECT SUM(Quantity)
FROM OrderDetails
WHERE ProductID = 1;

# 2번 상품의 1997년 중 총 판매 갯수
SELECT SUM(od.Quantity)
FROM Orders o
         JOIN OrderDetails od ON o.OrderID = od.OrderID
WHERE o.OrderDate LIKE '1997-__-__'
  AND od.ProductID = 2;

# 1번 고객이 1997년 중에 총 소비한 금액은?
SELECT SUM(p.Price * od.Quantity)
FROM Orders o
         JOIN OrderDetails od ON o.OrderID = od.OrderID
         JOIN Products p ON od.ProductID = p.ProductID
WHERE o.CustomerID = 1
  AND o.OrderDate LIKE '1997-__-__';

# todo: 멕시코 고객들이 1997년에 소비한 금액
SELECT SUM(p.Price * od.Quantity)
FROM Orders o
         JOIN Customers c ON o.CustomerID = c.CustomerID
         JOIN OrderDetails od ON o.OrderID = od.OrderID
         JOIN Products p ON od.ProductID = p.ProductID
WHERE c.Country = 'Mexico'
  AND o.OrderDate LIKE '1997-__-__';