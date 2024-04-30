# TRANSACTION : 하나의 업무 단위
USE mydb2;

CREATE TABLE bank
(
    name  VARCHAR(3) PRIMARY KEY,
    money INT NOT NULL
);
INSERT INTO bank
VALUES ('하나', 10000),
       ('둘둘', 10000);

SELECT *
FROM bank;

UPDATE bank
SET money = money - 500
WHERE name = '둘둘';

UPDATE bank
SET money = money + 500
WHERE name = '하나';

# -- 1 성공
START TRANSACTION; # 시작

COMMIT;
# 끝

# -- 2 실패(반영하지 않고 시작 전으로 돌림)
START TRANSACTION; # 시작
ROLLBACK # 끝