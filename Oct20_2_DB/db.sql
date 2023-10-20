create table oct20_coffee(
--커피 이름, 가격, 원두 입력
	c_no number(3) primary key,
	c_name varchar2(20 char) not null,
	c_price number(5) not null,
	c_bean varchar2(20 char) not null
);

create sequence oct20_coffee_seq;

drop table oct20_coffee;

insert into oct20_coffee values("맥심", "5000", "믹스커피");

select * from oct20_coffee order by c_price;

select c_price, ROWNUM AS rn from (select * from oct20_coffee order by c_price);