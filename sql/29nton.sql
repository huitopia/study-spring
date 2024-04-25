# n to n : 다 대 다 관계
USE mydb1;

CREATE TABLE board
(
    id      INT PRIMARY KEY AUTO_INCREMENT,
    title   VARCHAR(20),
    content VARCHAR(20)
);
CREATE TABLE member
(
    id    INT PRIMARY KEY AUTO_INCREMENT,
    email VARCHAR(20),
    info  VARCHAR(20)
);
# n:n 관계의 테이블의 중간 테이블 생성
CREATE TABLE board_like
(
    member_id INT REFERENCES member (id),
    board_id  INT REFERENCES board (id),
    PRIMARY KEY (member_id, board_id)
);
