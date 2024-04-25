USE w3schools;

SHOW tables;

CREATE DATABASE mydb1;

USE mydb1;

SHOW tables;
CREATE TABLE my_table1
(
    name VARCHAR(3),
    age  INT
);

# todo: mydb2 database create, table create
CREATE DATABASE mydb2;
USE mydb2;
SHOW tables;
CREATE TABLE my_table1
(
    name VARCHAR(3),
    age  INT
);

DROP DATABASE mydb2;

# todo: mydb1 삭제
DROP DATABASE mydb1;


