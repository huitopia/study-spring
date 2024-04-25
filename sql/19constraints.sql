USE w3schools;

# constraints 제약사항
# 특정의 컬럼에 제약사항을 줌 (예: NOT NULL, default 0, ...)
# NOT NULL : 꼭 값이 있어야함
CREATE TABLE my_table11
(
    col1 VARCHAR(10),
    # filed type constraints
    col2 VARCHAR(10) NOT NULL
);

DESC my_table11;

INSERT INTO my_table11(col1, col2)
VALUES ('blue', 'gray');
INSERT INTO my_table11(col2)
VALUES ('blue');

SELECT *
FROM my_table11;

# 해당 필드에 값이 있는 레코드 조회
SELECT *
FROM my_table11
WHERE col1 IS NOT NULL;

# 해당 필드에 값이 없는 레코드 조회
SELECT *
FROM my_table11
WHERE col1 IS NULL;

# todo: my_table12 생성, 2개의 field, NOT NULL
CREATE TABLE my_table12
(
    col1 VARCHAR(10),
    col2 INT NOT NULL
);

INSERT INTO my_table12 (col1, col2)
VALUES ('제약사항', 10);
INSERT INTO my_table12 (col2)
VALUES (20);

SELECT *
FROM my_table12;
