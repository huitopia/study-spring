# Normalization : 정규화(정규형)
# First Normal Form (1NF, 제 1정규화)
# 1) 각 행을 유일하게 구분하는 컬럼(PK)이 존재
# 2) 모든 데이터는 원자적으로 저장 -> 한 컬럼에 여러 값 저장 X
CREATE DATABASE mydb1;
USE mydb1;

# 고객정보를 저장한 테이블(이메일, 이름, 전화번호, 주소, 주민등록번호)
CREATE TABLE customer
(
    id           INT PRIMARY KEY AUTO_INCREMENT,
    email        VARCHAR(300),
    name         VARCHAR(100),
    phone_number VARCHAR(100),
    address      VARCHAR(200),
    ssn          VARCHAR(13)
);
INSERT INTO customer (email, name, phone_number, address, ssn)
VALUES ('', '', '', '', '');

# table 분해
CREATE TABLE customer
(
    id         INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(3),
    last_name  VARCHAR(3)
);

# 외래키(FK) 제약사항
CREATE TABLE phone_number
(
    id           INT PRIMARY KEY AUTO_INCREMENT,
    customer_id  INT, # FK
    phone_number VARCHAR(13),
    # id는 customer 에 존재하는 id 만 저장
    FOREIGN KEY (customer_id) REFERENCES customer (id)
);

INSERT INTO customer(first_name, last_name)
VALUES ('k', 'dh'),
       ('k', 'cy');
SELECT *
FROM customer;

INSERT INTO phone_number (customer_id, phone_number)
VALUES (1, '01012341234');
INSERT INTO phone_number (customer_id, phone_number)
VALUES (1, '01043214321');

INSERT INTO phone_number (customer_id, phone_number)
VALUES (3, '01043214321'); # FK 제약 사항으로 실패

INSERT INTO phone_number (customer_id, phone_number)
VALUES (2, '01043214321'); # FK 제약 사항으로 실패

SELECT *
FROM phone_number;

DROP TABLE customer;
DROP TABLE phone_number;

# Second Normal Form (2NF, 제 2정규화)
# Third Normal Form (3NF, 제 3정규화)