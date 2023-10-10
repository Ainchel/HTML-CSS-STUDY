create table oct10_test(

	t_title varchar2(20 char) primary key,
	t_when date not null

);

SELECT * FROM oct10_test;

--1.웹페이지에서 입력받은 후 DB에 저장하기
--저장할 때, 날짜 형식은 연/월/일을 <select> 태그로(연도는 올해 기준 10년치) 받아온다.

--2.DB에 저장된 데이터를 화면에 출력하기.
--출력할 때, jstl의 fmt를 활용하기. (연/월/일)