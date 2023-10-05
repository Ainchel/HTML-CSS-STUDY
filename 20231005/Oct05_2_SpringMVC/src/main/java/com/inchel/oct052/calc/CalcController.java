package com.inchel.oct052.calc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

//새 패키지를 만들 때, top-level-package 뒤에 이름을 붙이는 방식으로 하고 있다.
// top-level-package 양식을 잘 지키자. 패키지 이름이 꼬일 경우 다른 프로젝트에서 URL명이 겹쳐버릴 위험이 있다.

//이 클래스 파일을 MVC의 C(컨트롤러)로 사용할 것이라, @Controller 어노테이션을 붙여준다.
@Controller
public class CalcController {

	//컨트롤러를 JSP에서 활용하는 스타일 : 파일 업로드도 하고, 날짜도 올리고... 등등 이것저것 했다.
	//그리고 Spring에서도 똑같이 할 것이다.
	//요청파라미터가 있을 때, String 형태로 받아온 후 형변환해서 열심히 썼다.

	//컨트롤러를 담당하는 클래스 파일은, String 타입 메소드에 return을 이동할 jsp명으로 건다. 잊지 말기.
//	@RequestMapping(value = "/calculate.do", method = RequestMethod.GET)
//	public String clacXY(HttpServletRequest req) {
//		int x = Integer.parseInt(req.getParameter("x"));
//		int y = Integer.parseInt(req.getParameter("y"));
//		System.out.println(x);
//		System.out.println(y);
//		
//		return "index";
//	}
	
	//GET 방식으로 넘어온 요청파라미터(URL에 직접 입력)를 처리할 때, 주소에 한글이 들어갔을 경우?
	// tomcat에서는, server.xml의 63번 줄에 자동 인코딩 방식을 지정했었다.
	// URIEncoding="UTF-8" 추가했던 것 기억하기.
	
	//POST 방식으로 넘어온 요청파라미터(내부적으로 넘어옴)를 처리할 때에는?
	//프로젝트 내에서, 코드로 직접 때려서 인코딩 방식을 지정했었다.
	//JSP 방식 :doPost 메소드에 request.setCharacterEncoding("UTF-8"); 입력했던 것 기억하기.
	//Spring 방식 : web.xml에 설정이 되어 있다.
	
	//2. Spring 스타일로 해보기.
	//메소드의 패러미터로, @RequestParam 어노테이션을 이용해 페이지에서 입력받은 데이터를 전해받는다.
//	@RequestMapping(value = "/calculate.do", method = RequestMethod.POST)
//	public String calcXY(
//			@RequestParam(value="n") String n, 
//			@RequestParam(value="x") int x,
//			@RequestParam(value="y") int y) {
//		
//		System.out.println(n);
//		System.out.println(x);
//		System.out.println(y);
//		
//		return "index";
//	}
	
	//3. Spring 스타일 - 2번째
	//먼저, 입력받은 데이터를 담아줄 클래스를 하나 만들자.
	//servlet-context.xml에 등록시킨 CalcDAO 객체와 자동으로 연결시켜주기.
	//@Autowired 어노테이션 사용
	
	//객체 자동으로 받아오기
 	@Autowired
	private calcDAO cDAO;
 	
 	@RequestMapping(value = "/calcuate.do", method = RequestMethod.POST)
 	public String calcXY(CalcResult cr, HttpServletRequest req) {
 		
 		cDAO.calculate(cr, req);
 		
 		return "index";
 	}
	
}
