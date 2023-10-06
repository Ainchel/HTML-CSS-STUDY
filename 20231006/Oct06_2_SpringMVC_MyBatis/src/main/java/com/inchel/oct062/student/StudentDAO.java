package com.inchel.oct062.student;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // xml에 객체를 등록한 것처럼 처리. 싱글톤처럼 사용 가능.
public class StudentDAO {

	//xml에서 등록해뒀던, sql 관련 항목을 가져오기 위해 SqlSession 객체 생성
	@Autowired
	private SqlSession ss;
	
	public void regStudent(Student s, HttpServletRequest req) {
		try {
			
			//DB로의 연결을 자동으로 해준다 (SqlsessionTemplate를 servlet-context.xml에서 설정해둬서.)
			//connect나 close는 해주지 않아도 된다.
			
			System.out.println("학생입력 진입");
			
			//db에서 값을 받아오기 & 객체로 만들기 - Spring이 자동으로 해결해준다.
			
			//일단 웹페이지에서 입력받아온 객체의(이름과) 내용부터 출력.
			System.out.println(s.getS_name());
			System.out.println(s.getS_nickname());
			
			//SQL문을 수행하기 - MyBatis를 활용하는 것으로.
			//아까 만들어뒀던  StudentMapper에 만들어뒀던 interface를 사용한다.
			//SqlSession 만들어뒀던 것의 메소드를 통해서 인터페이스 객체를 생성한다.
			StudentMapper sm = ss.getMapper(StudentMapper.class);
			
			//미완성된 상태인 추상메소드를 여기서 완성시킨다.
			//방법 : 추상 메소드를 여기에 호출시키면, 인터페이스와 연결된 mapper.xml의 해당 코드가 실행된다.
			if (sm.regStudent(s) == 1) {
				req.setAttribute("r", "학생 등록 성공!");
				//ss.commit(); => 커밋도 자동으로 시켜준다고 한다.
			}
			
		}
		
		catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "학생 등록 실패(DB연결오류)");
		}
		
	}
	
	public void readStudent(HttpServletRequest req) {
		
		try {
			
			StudentMapper sm = ss.getMapper(StudentMapper.class);
			
			List<Student> studentList = ss.selectList("readStudent");
			
			for(Student s : studentList) {
				System.out.println(s.getS_name());
				System.out.println(s.getS_nickname());
			}
			
			req.setAttribute("list", studentList);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
