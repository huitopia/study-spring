USE w3schools;

# UPDATE 테이블명
# SET field = 변경할 값, field = 변경할 값,,,
# WHERE row 조건

# UPDATE 전 같은 WHERE 여부 확인하기

SELECT *
FROM Customers
WHERE CustomerID = 10;

UPDATE Customers
SET Address    = 'STARK TOWER',
    PostalCode = '12345'
WHERE CustomerID = 10;

UPDATE Customers
SET ContactName = 'TONY STARK'
WHERE CustomerID = 10;

UPDATE Customers
SET CustomerName = 'IRON MAN'
WHERE CustomerID = 10;

SELECT *
FROM Customers
WHERE Country = 'UK';

UPDATE Customers
SET Country = '영국'
WHERE Country = 'UK';

SELECT *
FROM Customers
WHERE Country = '영국';

SELECT *
FROM Customers;
UPDATE Customers
SET Country = '영국';

SELECT *
FROM Products
WHERE ProductID = 1;

# 값 연산 후 실행 가능
UPDATE Products
SET Price = Price * 2
WHERE ProductID = 1;

# todo: CategoryID = 2 상품 가격 3배 업데이트
SELECT *
FROM Products
WHERE CategoryID = 2;

UPDATE Products
SET Price = Price * 3
WHERE CategoryID = 2;

