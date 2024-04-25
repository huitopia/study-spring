use w3schools;

# DEFAULT 값을 주지 않을 때의 기본 값 정의
CREATE TABLE my_table13
(
    col1 VARCHAR(10),
    col2 VARCHAR(10) DEFAULT 'abc'
);

INSERT INTO my_table13 (col1, col2)
VALUES ('qwe', 'zxc');

INSERT INTO my_table13 (col2)
VALUES ('qwe');

INSERT INTO my_table13 (col1)
VALUES ('qwe');

SELECT *
FROM my_table13;

INSERT INTO my_table13 (col1, col2)
VALUES ('blue', NULL);

# todo: my_table14, 4 field(-,NOT NULL, DEFAULT, NOT NULL DEFAULT)
CREATE TABLE my_table14
(
    col1 VARCHAR(10),
    col2 VARCHAR(10) NOT NULL,
    col3 INT                  DEFAULT 0,
    col4 INT         NOT NULL DEFAULT 0
);

INSERT INTO my_table14 (col1, col2, col3, col4)
VALUES ('qwe', 'qwe', 10, 10);

INSERT INTO my_table14(col2)
VALUES ('qwe');

SELECT *
FROM my_table14;

INSERT INTO my_table14(col2, col3)
VALUES ('qwe', NULL);

# DEFAULT 값 != NOT NULL
