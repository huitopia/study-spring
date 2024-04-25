# Third Normal Form
# 1) 2NF 이다.
# 2) 키가 아닌 컬럼끼리 종속되면 안됨
USE mydb1;
# DROP TABLE phone_number; 자식 먼저 삭제 후 부모 삭제
# DROP TABLE customer;
# 3NF 위반
CREATE TABLE customer
(
    id         INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(3),
    last_name  VARCHAR(3),
    level      INT,
    benefit    VARCHAR(100)
);
INSERT INTO customer(first_name, last_name, level, benefit)
VALUES ('k', 'dh', 1, 'free drink'),
       ('k', 'cy', 1, 'free drink'),
       ('l', 'll', 2, 'size up'),
       ('o', 'mj', 2, 'size up'),
       ('p', 'sh', 3, '10% sale');
SELECT *
FROM customer;
DROP TABLE customer;
DROP TABLE customer_benefit;

# 3NF 위반 안한 테이블
CREATE TABLE customer
(
    id         INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(3),
    last_name  VARCHAR(3),
    level      INT,
    FOREIGN KEY (level) REFERENCES customer_benefit (level)
);
CREATE TABLE customer_benefit
(
    level   INT PRIMARY KEY,
    benefit VARCHAR(100)
);
DESC customer;
INSERT INTO customer(first_name, last_name, level)
VALUES ('k', 'dh', 1),
       ('k', 'cy', 1),
       ('l', 'll', 2),
       ('o', 'mj', 2),
       ('p', 'sh', 3);
INSERT INTO customer_benefit(level, benefit)
VALUES (1, 'free drink'),
       (2, '10% sale'),
       (3, 'size up');
SELECT *
FROM customer;
SELECT *
FROM customer_benefit;


