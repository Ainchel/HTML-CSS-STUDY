package com.inchel.oct051.member;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//연,월,일이 들어간 SimpleDateFormat을 필드로 써볼 예정

//이 클래스를 servlet-context.xml의 객체로써 등록하기 위해, @Service 어노테이션을 사용할 것이다.
//그렇게 하면, servlet-context.xml에 코드는 없지만, 객체로써 등록한 효과를 낼 수 있다.

//만약, 현재 연/월/일 형태를 연-월-일 시:분:초로 변경하고 싶다면?

@Service
public class MemberDAO {

	@Autowired
	private SimpleDateFormat sdf;
	
	public void test() {
		Date now = new Date();
		System.out.println(sdf.format(now));
	}
	
}
