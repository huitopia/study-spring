USE mydb2;

# LEFT (OUTER) JOIN
# INNER JOIN + 왼쪽 테이블에만 있는 레코드

SELECT *
FROM table1
         LEFT OUTER JOIN table2 ON col_a = col_b;

DELETE
FROM table1;
DELETE
FROM table2;

INSERT INTO table1 value (1),(2),(2),(3),(4);
INSERT INTO table2 value (3),(4),(5),(5);

SELECT *
FROM table1
# 3,4
         JOIN table2 ON col_a = col_b;
SELECT *
FROM table1
# a의 3,4,1,2,2 기준으로 b의 집합 값
         LEFT OUTER JOIN table2 ON col_a = col_b;
SELECT *
FROM table2
# b의 3,4,5,5 기준으로 a의 집합 값
         LEFT OUTER JOIN table1 ON col_b = col_a;
DELETE
FROM table3;
DELETE
FROM table4;

INSERT INTO table3
VALUES (4),
       (5),
       (6),
       (3);
INSERT INTO table4
VALUES (5),
       (6),
       (7),
       (7),
       (8);
# cartesian : 20row
SELECT *
FROM table3
         JOIN table4;
# INNER JOIN : 5,6
SELECT *
FROM table3
         JOIN table4 ON col_a = col_b;
# LEFT JOIN
# 3의 5,6,4,3 기준으로 4의 5,6
SELECT *
FROM table3
         LEFT OUTER JOIN table4 ON col_a = col_b;
# 4의 5,6,7,7,8 기준으로 3의 5,6
SELECT *
FROM table4
         LEFT OUTER JOIN table3 ON col_a = col_b;

# RIGHT OUTER JOIN
SELECT *
FROM table3
         # 결과 같음
# SELECT * FROM table4 LEFT OUTER JOIN table3 ON col_a = col_b;
         RIGHT JOIN table4 ON col_a = col_b;

# table1, 2 right join
SELECT *
FROM table1
         # table2 기준으로 table1 중복값
         RIGHT JOIN table2 ON col_a = col_b;
SELECT *
FROM table2
         # table1 기준으로 table2 중복값
         RIGHT JOIN table1 ON col_a = col_b;

