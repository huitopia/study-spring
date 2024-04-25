# JOIN : 여러 테이블을 묶어서 조회하는 방법

USE w3schools;

SELECT *
FROM Products;
SELECT *
FROM Categories;
SELECT ProductName, CategoryName
FROM Products
         JOIN Categories
              ON Products.CategoryID = Categories.CategoryID
WHERE ProductName = 'Chais';