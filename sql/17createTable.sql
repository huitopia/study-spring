USE w3schools;

# CREATE TABLE : 신규 테이블 생성
# 테이블 생성시 컬럼들 정의 필수
# CREATE TABLE 테이블명 (컬럼명1 컬럼타입, ...);

# 테이블명, 필드명 작성 관습 : snake_case
# UPPER_SNAKE_CASE, lower_snake_case

CREATE TABLE my_table1
(
    address varchar(30),
    city    varchar(50),
    country varchar(20)
);

INSERT INTO my_table1(address, city, country)
VALUES ('신촌', '서울', '한국');

SELECT *
FROM my_table1;

DESC my_table1;

# todo : my_table2 생성
#  컬럼 name varchar(30), age varchar(30)
#  DESC 테이블 확인
#  INSERT 레코드 추가
#  SELECT 조회
CREATE TABLE my_table2
(
    name varchar(30),
    age  int(10)
);

DESC my_table2;

INSERT INTO my_table2 (name, age)
VALUES ('chae', 7);

SELECT *
FROM my_table2;