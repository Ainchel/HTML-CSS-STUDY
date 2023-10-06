package com.inchel.oct062.student;

import java.math.BigDecimal;

// 웹페이지 -> DB로 데이터 전송 작업을 스프링 버전으로.
// MyBatis를 사용할 것이다. ORM(Object Relationship Mapping) 컨셉의 Framework이다.
// => 객체와 데이터베이스의 데이터를 자동으로 연결(매핑) 시켜주는 Framework이다.
// 결과를 자바 객체로 받아와서 뿌려줄 수 있다.
// 이를 위해, db의 컬럼명과, Java DTO의 필드명이 같아야 한다는 조건이 있다.

// 오라클에서 사용하던 number라는 데이터 타입은, 정수와 실수를 동시에 담는다.
// 하지만 Java에서는 정수와 실수가 나뉘는데, 이것도 동시에 담아주는 "BigDecimal" 데이터타입을 사용할 것이다.

// Spring MVC의 경우, 요청파라미터를 자동으로 객체로 담아줄 수 있는 것을 확인했다.(요청 파라미터 이름과 Java DTO의 필드명이 같을 경우)

// 위 두 조건(DB - JAVA, 웹페이지 - JAVA)을 아우르기 위해서는, 결국 요청파라미터명 - Java 필드명 - DB컬럼명이 전부 같아야 한다.

public class Student {

	private BigDecimal s_no;
	private String s_name;
	private String s_nickname;
	
	public Student() {
		super();
	}
	
	public Student(BigDecimal s_no, String s_name, String s_nickname) {
		super();
		this.s_no = s_no;
		this.s_name = s_name;
		this.s_nickname = s_nickname;
	}
	
	public BigDecimal getS_no() {
		return s_no;
	}
	
	public void setS_no(BigDecimal s_no) {
		this.s_no = s_no;
	}
	
	public String getS_name() {
		return s_name;
	}
	
	public void setS_name(String s_name) {
		this.s_name = s_name;
	}
	
	public String getS_nickname() {
		return s_nickname;
	}
	
	public void setS_nickname(String s_nickname) {
		this.s_nickname = s_nickname;
	}
	
}
