USE w3schools;

# ALTER TABLE : 테이블 구조 변경(컬럼 추가, 컬럼 삭제, 컬럼 수정(이름, 타입/제약사항))
CREATE TABLE my_table23
(
    name VARCHAR(3),
    age  INT
);
INSERT INTO my_table23 (name, age)
VALUES ('hee', 7),
       ('hui', 10);
# 신규 필드 추가
ALTER TABLE my_table23
    ADD COLUMN address VARCHAR(10);

# todo: my_table23 (field: city)
ALTER TABLE my_table23
    ADD COLUMN city VARCHAR(10);

ALTER TABLE my_table23
    ADD COLUMN country VARCHAR(10) NOT NULL; # 빈 스트링?

ALTER TABLE my_table23
    ADD COLUMN price INT NOT NULL; # 0?

ALTER TABLE my_table23
    ADD COLUMN state VARCHAR(10) NOT NULL DEFAULT 'seoul';

# age 컬럼 뒤에 birth 추가
# JDBC 는 컬럼 순서로 값을 받아오기 때문에 문제될 수 있음
ALTER TABLE my_table23
    ADD COLUMN birth DATE AFTER age;

# 필드 삭제
ALTER TABLE my_table23
    DROP COLUMN state;

# todo: city column delete
ALTER TABLE my_table23
    DROP COLUMN city;

# 필드 이름 변경
ALTER TABLE my_table23 RENAME COLUMN address TO town;

# todo: birth rename birth_date
ALTER TABLE my_table23 RENAME COLUMN birth TO birth_date;

# 자료형/제약사항 변경
ALTER TABLE my_table23
    MODIFY COLUMN price DEC(20, 2);

# todo: name modify varchar(30)
ALTER TABLE my_table23
    MODIFY COLUMN name VARCHAR(30);

INSERT INTO my_table23 (name, country)
VALUES ('1123123123213123213', 'korea');

# 기존 data 와 변경 타입의 조건 일치하지 않음 > 실행 안됨
ALTER TABLE my_table23
    MODIFY COLUMN name VARCHAR(3);

# 제약사항 변경
ALTER TABLE my_table23
    MODIFY COLUMN name VARCHAR(30) UNIQUE;

# todo: age column unique 추가
ALTER TABLE my_table23
    MODIFY COLUMN age INT(11) UNIQUE;

# UNIQUE 제약사항 삭제하기
# ALTER TABLE my_table23 DROP INDEX age;

# name column drop Unique
# ALTER TABLE my_table23 DROP INDEX name;

SHOW INDEX FROM my_table23;

# NOT NULL 추가
ALTER TABLE my_table23
    MODIFY COLUMN name VARCHAR(30) NOT NULL;

# NOT NULL 삭제
ALTER TABLE my_table23
    MODIFY COLUMN name VARCHAR(30) NULL;

# todo: age not null, null
UPDATE my_table23
SET age = 10
WHERE age IS NULL;

ALTER TABLE my_table23
    MODIFY COLUMN age INT(11) NOT NULL;

ALTER TABLE my_table23
    MODIFY COLUMN age INT(11) NULL;

# DEFAULT 추가
ALTER TABLE my_table23
    MODIFY COLUMN name VARCHAR(30) DEFAULT 'guest';
# DEFAULT 삭제
ALTER TABLE my_table23
    ALTER COLUMN name DROP DEFAULT;

# todo: age default 추가, 삭제
ALTER TABLE my_table23
    MODIFY COLUMN age INT(11) DEFAULT 0;

ALTER TABLE my_table23
    ALTER COLUMN age DROP DEFAULT;

# PRIMARY KEY 추가
ALTER TABLE my_table23
    ADD PRIMARY KEY (name);
# PRIMARY KEY 삭제
ALTER TABLE my_table23
    DROP PRIMARY KEY;

ALTER TABLE my_table23
    MODIFY COLUMN name VARCHAR(30) NULl;

# age PRIMARY KEY 추가 삭제
UPDATE my_table23
SET age = 2
WHERE name = 'hui';

ALTER TABLE my_table23
    ADD PRIMARY KEY (age);

ALTER TABLE my_table23
    DROP PRIMARY KEY;

ALTER TABLE my_table23
    MODIFY COLUMN age INT(11) NULL;

DESC my_table23;

SELECT *
FROM my_table23;