package com.inchel.oct101.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestDAO {

	@Autowired
	private SqlSession ss;
	
	public void regTest(Test t, HttpServletRequest req) {
		try {
			
			System.out.println("regTest 진입 성공");
			
			//입력 페이지에서 받아온 정보(t_y, t_m, t_d)를 사용하여 Date 데이터로 만들어야 한다.
			//그렇게 만든 Date 타입 애를 SQL문에 던져줘야 함.
			String t_y = req.getParameter("t_y");
			
			// 월하고 일은 두자리 숫자로 집어넣기 위해 int형으로 받는다.
			// 왜 두자리? 월과 일이 한자린지 두자린지 모르고, 합쳤을 때 값의 형태가 헷갈리므로 강제 두자리로 변경.
			int t_m = Integer.parseInt(req.getParameter("t_m"));
			int t_d = Integer.parseInt(req.getParameter("t_d"));
			
			String t_when2 = String.format("%s%02d%02d", t_y, t_m, t_d);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			
			Date t_when = sdf.parse(t_when2);
			t.setT_when(t_when);
			
			System.out.println(t.getT_title());
			System.out.println(t.getT_when());
			
			if(ss.getMapper(TestMapper.class).regTest(t) == 1) {
				req.setAttribute("r", "시험 날짜 등록 성공");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "시험날짜 등록 실패");
		}
		
	}
	
	public void getAllTest(HttpServletRequest req) {
	
		try {
			req.setAttribute("tests", ss.getMapper(TestMapper.class).getAllTest());
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}

//cos.jar(파일 업로드)를 사용할 때, 서블릿 환경과 스프링 환경에서의 차이점
// 1. req.getParameter() => mr.getParameter()를 쓰는 것은 그대로이다.
// 2. 실행되는 서버 상에서, 파일이 업로드되는 그 path 쓰던 경로를 잡는 메소드가 살짝 달라진다.
// 2-1) 서블릿 환경 : String path = req.getServletContext().getRealPath("img"); << 이거 스프링에서는 안먹힌다.
// 2-2) 스프링 환경 : String path = req.getSession().getServletContext().getRealPath("resources/img");
// 2-1과 2-2의 차이  : req 뒤에 .getSession()을 하나 추가했다.
// 여기에서의 resources 폴더는, webapp 안의 resources 폴더이다. 헷갈리지 않게 주의.

