USE w3schools;

# * : 모든 row 의 모든 field
SELECT *
FROM Products;

# filed 정보
DESC Products;

# AS : field(또는 테이블)에 별칭 주며 생략 가능함
SELECT ProductID   AS id,
       ProductName AS name,
       Price          가격
FROM Products;