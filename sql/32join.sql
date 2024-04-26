CREATE DATABASE mydb2;

USE mydb2;

CREATE TABLE table1
(
    col_a INT
);
CREATE TABLE table2
(
    col_b INT
);
INSERT INTO table1 (col_a)
VALUES (1),
       (2),
       (3),
       (4);
INSERT INTO table2 (col_b)
VALUES (2),
       (2),
       (3),
       (4),
       (5);
SELECT *
FROM table1;
SELECT *
FROM table2;

# JOIN : 두 개(이상)의 테이블을 결합
# 컬럼수 : 두 테이블의 컬럼 수의 합
# 레코드수 : 두 테이블 행의 수의 곱
# cartesian product > 모든 결합
SELECT *
FROM table1
         JOIN table2;
# INNER JOIN : 두 테이블에 모두 있는 값만(cartesian 곱 했을 때 같은 것)
#   1
SELECT *
FROM table1
         JOIN table2 ON col_a = col_b;
#   2
SELECT *
FROM table1
         JOIN table2
WHERE col_a = col_b;

CREATE TABLE table3
(
    col_a INT
);
CREATE TABLE table4
(
    col_b INT
);
INSERT INTO table3 (col_a)
VALUES (5),
       (6),
       (7);
INSERT INTO table4(col_b)
VALUES (7),
       (6),
       (7),
       (8);
# cartesian
SELECT *
FROM table3
         JOIN table4;
# INNER JOIN
SELECT *
FROM table3
         JOIN table4 ON col_a = col_b;
