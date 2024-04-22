USE w3schools;

SELECT *
FROM Employees
ORDER BY EmployeeID DESC;

# 지우기 전에 꼭 같은 WHERE 확인 하기
DELETE
FROM Employees
WHERE EmployeeID = 2046;

DELETE
FROM Employees
WHERE FirstName = 'king';

# 모든 레코드 지우기 : WHERE 사용 X