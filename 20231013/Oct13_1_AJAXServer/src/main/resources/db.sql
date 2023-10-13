create table oct13_error(

	e_what varchar2(30 char) primary key,
	e_where varchar2(30 char) not null
	
);

insert into oct13_error values('@빼먹음', 'DAO');
insert into oct13_error values('mapper입력 빼먹음', 'servlet-context.xml');
insert into oct13_error values('세미콜론(;) 넣음', 'mapper.xml');
insert into oct13_error values('패키지 클래스 X', 'mapper.xml');
insert into oct13_error values('패키지 파일 위치', '프로젝트');

select * from oct13_error order by e_where;