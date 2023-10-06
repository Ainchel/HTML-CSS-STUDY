create table oct06_student(

	s_no number(3) primary key,
	s_name varchar2(10 char) not null,
	s_nickname varchar2(10 char) not null

);

create sequence oct06_student_seq;
DROP sequence oct06_student_seq;
SELECT * FROM oct06_student
-----------------------------------------------------------