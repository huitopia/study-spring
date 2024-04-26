# (INNER) JOIN
# LEFT (OUTER) JOIN
# RIGHT (OUTER) JOIN
# FULL (OUTER) JOIN -> maria DB X = 대체 => UNION

# UNION (합집합)
USE mydb2;

CREATE TABLE table10
(
    col1 INT
);
CREATE TABLE table11
(
    col_a INT
);
INSERT INTO table10
VALUES (3),
       (4),
       (4),
       (5);
INSERT INTO table11
VALUES (3),
       (4),
       (7);

# 값 합치고 중복 제거 (set)
SELECT *
FROM table10
UNION
SELECT *
FROM table11;
# LEFT UNION RIGHT
SELECT *
FROM table10
         LEFT JOIN table11 ON col1 = col_a
UNION
SELECT *
FROM table10
         RIGHT JOIN table11 ON col1 = col_a;
# LEFT UNION ALL RIGHT
SELECT *
FROM table10
         LEFT JOIN table11 ON col1 = col_a
UNION ALL
SELECT *
FROM table10
         RIGHT JOIN table11 ON col1 = col_a;