USE w3schools;

# INSERT INTO Table (field...)
# VALUE (row)
# VALUES (row...)

SELECT *
FROM Employees
ORDER BY EmployeeID DESC;

INSERT INTO Employees (LastName)
VALUES ('man');

# null : 값이 없음

INSERT INTO Employees (FirstName)
VALUES ('tony');

INSERT INTO Employees (LastName, FirstName, BirthDate, Photo, Notes)
VALUES ('captain', 'steve', '1990-01-01', 'pic1.pic', 'america');

INSERT INTO Employees (FirstName, LastName)
VALUES ('natasha', 'widow');

# todo: customers row 2개 추가
SELECT *
FROM Customers
ORDER BY CustomerID DESC;

INSERT INTO Customers (CustomerName, ContactName, Address, City, PostalCode, Country)
VALUES ('v', 'compose', 'sinchon', 'seoul', '1111', 'korea');

INSERT INTO Customers (CustomerName, ContactName, Address, City, PostalCode, Country)
VALUES ('itzy', 'mega', 'hongdae', 'seoul', '32-4', 'korea');

SELECT *
FROM Employees
ORDER BY EmployeeID DESC
LIMIT 1;