# 문자열
# varchar(길이)
CREATE TABLE my_table3
(
    name  VARCHAR(4),
    title VARCHAR(5),
    notes VARCHAR(20)
);

DESC my_table3;

INSERT INTO my_table3 (name, title, notes)
VALUES ('hya', 'dev', 'spring');

SELECT *
FROM my_table3;

INSERT INTO my_table3 (name, title, notes)
VALUES ('hhhh', 'dev!', 'spring');

# todo : my_table4
#  책 제목, 책 내용, 저자
#  테이블 생성, 추가, 조회
CREATE TABLE my_table4
(
    title   VARCHAR(20),
    content VARCHAR(100),
    writer  varchar(10)
);

DESC my_table4;

INSERT INTO my_table4 (title, content, writer)
VALUES ('sql 완전 정복', 'sql에 관한 내용 있음', '데이터분석가 누군가');

SELECT *
FROM my_table4;

# 정수 INT / 실수 DECIMAL, DEC(총 길이, 소수점 이하 길이)
CREATE TABLE my_table5
(
    age    INT,
    height DEC(5, 2)
);

DESC my_table5;

SELECT *
FROM my_table5;

INSERT INTO my_table5 (age, height)
VALUES (10, 170.25);
# 소수점 뒷자리 자름(반올림 또는 내림)
INSERT INTO my_table5 (age, height)
VALUES (10, 170.333);
INSERT INTO my_table5 (age, height)
VALUES (10, 170.339);

# todo: 새 테이블 my_table6
#  한 개의 정수 타입 컬럼, 한 개의 실수 타입 컬럼
#  DESC 테이블, 레코드 추가, 조회
CREATE TABLE my_table6
(
    age    INT,
    height DEC(4, 3)
);
DESC my_table6;
INSERT INTO my_table6 (age, height)
VALUES (30, 1.222);
SELECT *
FROM my_table6;

# DATE : 날짜 (YYYY-MM-DD)
# DATETIME : 날짜시간 (YYYY-MM-DD HH:MM:SS)

CREATE TABLE my_table7
(
    col1 DATE,
    col2 DATETIME
);
DESC my_table7;
SELECT *
FROM my_table7;
INSERT INTO my_table7 (col1, col2)
VALUES ('2002-08-10', '1999-09-09 22:10:10');

# todo: my-table8 DATE, DATETIME 정의
#  INSERT, SELECT
CREATE TABLE my_table8
(
    col1 DATE,
    col2 DATETIME
);
DESC my_table8;
INSERT INTO my_table8 (col1, col2)
VALUES ('1994-04-27', '1994-04-27 22:30:00');
SELECT *
FROM my_table8;

CREATE TABLE my_table9
(
    string_col     VARCHAR(10),
    int_col        INT,
    dec_col        DEC(10, 2),
    date_col       DATE,
    date_time_cole DATETIME
);
INSERT INTO my_table9 (string_col, int_col, dec_col, date_col, date_time_cole)
VALUES ('곧 점심시간!!', 50000, 54321.98, '2024-02-02', '1888-08-01 19:20:30');

SELECT *
FROM my_table9;

DESC my_table9;

CREATE TABLE my_table10
(
    title     VARCHAR(30),
    name      VARCHAR(30),
    age       INT,
    price     DEC(10, 3),
    published DATE,
    inserted  DATETIME
);

DESC my_table10;

INSERT INTO my_table10 (title, name, age, price, published, inserted)
VALUES ('이것이 자바다', '신용권', 40, 23422.223, '1999-09-09', '1999-10-10 12:33:12'),
       ('스프링부트', '홍길동', 50, 2342.123, '2024-01-01', '2024-02-02 09:33:33');

SELECT *
FROM my_table10;

