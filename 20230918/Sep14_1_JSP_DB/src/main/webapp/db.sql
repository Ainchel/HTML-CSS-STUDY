-- 사과 테이블을 만들자 : 지역 / 색 / 맛 / 가격 / 소개글 데이터 필요.

CREATE TABLE sep14_apple(
	a_location VARCHAR2(100 CHAR) PRIMARY KEY,
	a_color VARCHAR2(100 CHAR) NOT NULL,
	a_taste VARCHAR2(100 CHAR) NOT NULL,
	a_price NUMBER(10) NOT NULL,
	a_introduce VARCHAR2(200 CHAR) NOT NULL
);

CREATE SEQUENCE sequence_name;

INSERT INTO sep14_apple VALUES('서울', '빨강', '달콤', 2500, '빨갛고 달콤한 평범한 사과');
INSERT INTO sep14_apple VALUES('대전', '파랑', '새콤', 3500, '파랗고 새콤한 이상한 사과');
INSERT INTO sep14_apple VALUES('대구', '노랑', '짭짤', 2800, '노랗고 짭짤한 신기한 사과');

SELECT * FROM sep14_apple;

SELECT ROWNUM, a_location, a_color, a_taste, a_price, a_introduce FROM(
	SELECT * FROM sep14_apple ORDER BY a_price)
	  WHERE ROWNUM BETWEEN 1 AND 5 ;

SELECT ROWNUM, a_location, a_color, a_taste, a_price, a_introduce 
	FROM(SELECT * FROM sep14_apple ORDER BY a_price);
	
DROP TABLE sep14_apple;

SELECT ROWNUM, a_location, a_color, a_taste, a_price, a_introduce
FROM (SELECT a_location, a_color, a_taste, a_price, a_introduce, ROWNUM AS rn
  	FROM (SELECT * FROM sep14_apple ORDER BY a_price))
		WHERE rn BETWEEN 6 AND 10;
		
select a_location, a_color, a_taste, a_price, a_introduce, "A_PAGENUM"
FROM(SELECT a_location, a_color, a_taste, a_price, a_introduce, dense_rank() over(order by a_price) "A_PAGENUM"
from sep14_apple)
WHERE "A_PAGENUM" BETWEEN 1 AND 5;

UPDATE sep14_apple SET a_color='노랑', a_taste='짭짤', a_price=4800, a_introduce='테스트'
	WHERE a_location='대구';
