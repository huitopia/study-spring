USE w3schools;
# 1번 상품 상품명, 카테고리명 조회
SELECT p.ProductName, c.CategoryName
FROM Products p
         LEFT OUTER JOIN Categories c
                         ON p.CategoryID = c.CategoryID
WHERE p.ProductID = 1;
# 10번 상품의 상품명, SupplierID 이름과 국가 조회
SELECT p.ProductID, p.ProductName, s.SupplierName, s.Country
FROM Products p
         JOIN Suppliers s
              ON p.SupplierID = s.SupplierID
WHERE p.ProductID = 10;

# 주문번호 10249번 고객의 이름 조회
SELECT c.CustomerName
FROM Orders o
         JOIN Customers c
              ON o.CustomerID = c.CustomerID
WHERE o.OrderID = 10249;
# 주문번호 10249번 처리한 직원 이름 조회
SELECT e.FirstName, e.LastName
FROM Orders o
         JOIN Employees e ON o.EmployeeID = e.EmployeeID
WHERE OrderID = 10249;
# 주문번호 10249번 배달한 배달원 이름 조회
SELECT s.ShipperName
FROM Orders o
         JOIN Shippers s ON o.ShipperID = s.ShipperID
WHERE o.OrderID = 10249;

# 90번 고객의 이름과 주문한 날짜 오름차순 조회
SELECT c.CustomerID, c.CustomerName, o.OrderDate
FROM Orders o
         JOIN Customers c ON o.CustomerID = c.CustomerID
WHERE c.CustomerID = 90
ORDER BY o.OrderDate;

# 3번 직원이 주문을 처리한 날짜 오름차순 직원 이름, 날짜 조회
SELECT e.FirstName, e.LastName, o.OrderDate
FROM Employees e
         JOIN Orders o ON e.EmployeeID = o.EmployeeID
WHERE e.EmployeeID = 3
ORDER BY o.OrderDate;