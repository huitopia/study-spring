USE w3schools;

# UNIQUE 다른 레코드의 컬럼 값이 중복되지 않음

CREATE TABLE my_table15
(
    col1 VARCHAR(3),
    col2 VARCHAR(3) UNIQUE
);

DESC my_table15;

INSERT INTO my_table15 (col1, col2)
VALUES ('abc', 'def');

SELECT *
FROM my_table15;

# 같은 레코드 내의 다른 컬럼과 값 중복 허용
INSERT INTO my_table15(col1, col2)
VALUES ('qwe', 'qwe');

# 같은 레코드 내의 같은 컬럼의 값 중복 불가
INSERT INTO my_table15 (col1, col2)
VALUES ('def', 'def'); # error

INSERT INTO my_table15 (col1)
VALUES ('abc');

CREATE TABLE my_table16
(
    col1 INT,
    col2 INT NOT NULL,
    col3 INT NOT NULL UNIQUE
);

DESC my_table16;

INSERT INTO my_table16 (col1, col2, col3)
VALUES (1, 1, 1);
INSERT INTO my_table16 (col2, col3)
VALUES (2, 2);
INSERT INTO my_table16 (col2, col3)
VALUES (1, 3);

SELECT *
FROM my_table16;
