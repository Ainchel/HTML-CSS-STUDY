package com.inchel.oct062.student;

import java.util.List;

public interface StudentMapper {

	//MyBatis에서 sql문을 사용하는 method들의 리턴 타입에 대하여.
	//insert, update, delete => 영향을 받은 데이터의 수 : 즉 int였다.
	//select의 경우, 결과가 하나만 나온다면 : resultType 객체(Student)를 사용한다.
	//결과가 여러개 나온다면 : List<resultType객체> (예 : List<Student>)를 사용한다.
	
	//위 리턴 타입에 맞게, 인터페이스에서 아래처럼 추상메소드를 작성해주어야 한다.
	
	//메소드의 이름을 지을 때에는, mapper.xml의 insert태그에서 속성으로 추가한 id와 일치해야 한다.
	//<insert id = "regStudent" parameterType="com.inchel.oct062.student.Student"> 에서의 id와 일치.
	//메소드의 파라미터는, mapper.xml의 parameterType과 반드시 일치해야 한다.
	//즉, parameterType이 가리키는 것이 Student 클래스이므로, 파라미터는 Student가 되어야 한다.
	public abstract int regStudent(Student s);
	
	//xml에서의 resultType 형식은, 작성한 타입에 맞는 클래스로 매핑을 알아서 시켜준다.
	//+ 따로 설정하지 않아도, 쿼리문의 결과가 여러개라면 List 형식으로 반환을 시켜준다.
	
	public abstract List<Student> readStudent();
}
