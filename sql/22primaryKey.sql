USE w3schools;

# PRIMARY KEY : NOT NULL + UNIQUE + 변경 가능성 0에 가까운 값
CREATE TABLE my_table17
(
    col1 INT,
    col2 INT PRIMARY KEY # NOT NULL UNIQUE
);

INSERT INTO my_table17 (col1, col2)
VALUES (1, 1);
INSERT INTO my_table17 (col1, col2)
VALUES (1, 1); # error
INSERT INTO my_table17 (col1, col2)
VALUES (1, 2);
INSERT INTO my_table17 (col2)
VALUES (3);

SELECT *
FROM my_table17;

# PRIMARY KEY : 제약사항은 한 테이블에 하나만 줄 수 있음

CREATE TABLE my_table18
(
    col1 INT PRIMARY KEY,
    col2 INT PRIMARY KEY
); # ERROR

CREATE TABLE my_table18
(
    col1 INT NOT NULL UNIQUE,
    col2 INT NOT NULL UNIQUE
); # PRIMARY KEY 는 중복 불가능 하지만 NOT NULL UNIQUE 중복으로 제약사항 주는 건 가능하다.

CREATE TABLE my_table19
(
    col1 INT PRIMARY KEY,
    col2 INT NOT NULL UNIQUE
);

DESC my_table18; # col1 PRIMARY KEY
DESC my_table19;
# col1 PRIMARY KEY

# PRIMARY KEY 는 테이블에서 1개의 필드만 가질 수 있다

# 여러 컬럼 조합으로 PRIMARY KEY 제약사항을 줄 수 있다.
CREATE TABLE my_table21
(
    col1 INT,
    col2 INT,
    col3 INT,
    PRIMARY KEY (col1, col2)
);

DESC my_table21;

INSERT INTO my_table21 (col1, col2, col3)
VALUES (1, 1, 1);
INSERT INTO my_table21 (col1, col2, col3)
VALUES (1, 2, 1);
INSERT INTO my_table21 (col1, col2, col3)
VALUES (2, 2, 1);

SELECT *
FROM my_table21;

# my_table22 (Primary Key, NOT NULL UNIQUE, -)
CREATE TABLE my_table22
(
    col1 INT PRIMARY KEY,
    col2 INT NOT NULL UNIQUE,
    col3 INT
);

INSERT INTO my_table22 (col1, col2, col3)
VALUES (1, 1, 1);
INSERT INTO my_table22 (col1, col2, col3)
VALUES (2, 2, 1);
INSERT INTO my_table22 (col1, col2)
VALUES (3, 3);

SELECT *
FROM my_table22;

# CHECK, FOREIGN KEY