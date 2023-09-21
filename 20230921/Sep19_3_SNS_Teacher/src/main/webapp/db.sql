create table sns_member(
	m_id varchar2(10 char) primary key,
	m_pw varchar2(12 char) not null,
	m_name varchar2(10 char) not null,
	m_phone varchar2(11 char) not null,
	m_birthday date not null,
	m_photo varchar2(200 char) not null
);

select * from sns_member;


-- select * from sns_member where m_id='1' or '1'='1';





















