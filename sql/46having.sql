USE w3schools;

# HAVING : 집계함수의 조건절

SELECT CategoryID, COUNT(ProductID)
FROM Products
GROUP BY CategoryID;

# 상품수가 10개 이상인 카테고리
SELECT CategoryID, COUNT(ProductID) count
FROM Products
GROUP BY CategoryID
HAVING count >= 10;

# 고객이 5명 이상 있는 국가들 조회
SELECT Country, COUNT(Country) total
FROM Customers
GROUP BY Country
HAVING total >= 5;

# 97년 7월 매출액(SUM(상품가격*갯수))이 10000달러 이상인 직원들 조회
SELECT e.EmployeeID, e.FirstName, SUM(p.Price * od.Quantity) total
FROM Employees e
         JOIN Orders o ON e.EmployeeID = o.EmployeeID
         JOIN OrderDetails od ON o.OrderID = od.OrderID
         JOIN Products p ON od.ProductID = p.ProductID
WHERE o.OrderDate LIKE '1997-07-__'
GROUP BY e.EmployeeID
HAVING total >= 10000
ORDER BY total DESC;