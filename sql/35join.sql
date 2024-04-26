USE mydb2;

CREATE TABLE product
(
    id          INT PRIMARY KEY AUTO_INCREMENT,
    name        VARCHAR(10) NOT NULL,
    price       INT         NOT NULL DEFAULT 0,
    category_id INT REFERENCES category (id)
);

CREATE TABLE category
(
    id   INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(10) NOT NULL
);

INSERT INTO category (name)
VALUES ('초콜렛'),
       ('탄산음료'),
       ('과자'),
       ('유제품'),
       ('생필품');
INSERT INTO product(name, price, category_id)
VALUES ('가나', 500, 1),
       ('페레로로쉐', 700, 1),
       ('크런키', 400, 1),
       ('콜라', 300, 2),
       ('사이다', 300, 2),
       ('포카칩', 600, 3),
       ('새우깡', 550, 3);

# 일치하는 category_id 값 불러오기
SELECT *
FROM product
         LEFT JOIN category ON product.category_id = category.id;

# ALIAS 별칭 : AS
SELECT p.name 상품명, p.price 가격, c.name 카테고리
FROM product AS p
         LEFT JOIN category AS c ON p.category_id = c.id;