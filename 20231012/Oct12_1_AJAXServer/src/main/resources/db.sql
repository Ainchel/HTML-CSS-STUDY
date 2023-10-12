create table oct12_fruit(
	f_name varchar2(10 char) primary key,
	f_price number(5) not null
);

INSERT INTO oct12_fruit VALUES('사과', '1500');
INSERT INTO oct12_fruit VALUES('딸기', '2000');
INSERT INTO oct12_fruit VALUES('감', '2500');
INSERT INTO oct12_fruit VALUES('배', '3000');
INSERT INTO oct12_fruit VALUES('귤', '3500');

SELECT * FROM oct12_fruit;