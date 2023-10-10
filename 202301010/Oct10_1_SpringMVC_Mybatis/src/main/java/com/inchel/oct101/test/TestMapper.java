package com.inchel.oct101.test;

import java.util.List;

public interface TestMapper {

	//여기 인터페이스의 메소드명은 매퍼xml에서의 각 sql문의 id와 같아야 한다.
	//xml문의 <insert id = "regTest" parameterType="com.inchel.oct101.test.Test"> 이 줄 id 참고.
	public abstract int regTest(Test t);
	
	public abstract List<Test> getAllTest();
	
}
