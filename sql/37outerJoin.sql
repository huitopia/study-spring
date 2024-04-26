USE mydb2;

SELECT *
FROM product;
SELECT *
FROM category;

# 상품이 존재하지 않는 카테고리 찾기
SELECT *
FROM category c
         LEFT JOIN product p ON c.id = p.category_id
WHERE p.id IS NULL;

USE w3schools;
# 한 번도 주문한 적 없는 고객의 이름 조회
SELECT c.CustomerName
FROM Customers c
         LEFT JOIN Orders o ON c.CustomerID = o.CustomerID
WHERE o.OrderID IS NULL;

# 1996년에 주문한적 있는 고객들 이름
SELECT c.CustomerName, o.OrderDate
FROM Customers c
         LEFT JOIN Orders o ON c.CustomerID = o.CustomerID
WHERE o.OrderDate LIKE '1996-__-__';
# 1996년에 주문한적 없는 고객들 이름
SELECT c.CustomerName
FROM Orders o
         RIGHT JOIN Customers c ON c.CustomerID = o.CustomerID
WHERE o.OrderID IS NULL;

INSERT INTO Employees (LastName, FirstName)
VALUES ('흥민', '손'),
       ('강인', '이');
SELECT *
FROM Employees e
         LEFT OUTER JOIN Orders o ON e.EmployeeID = o.EmployeeID
WHERE o.OrderID IS NULL;