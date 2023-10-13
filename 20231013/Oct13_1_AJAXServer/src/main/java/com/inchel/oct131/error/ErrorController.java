package com.inchel.oct131.error;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

//별도 컨트롤러 생성

@Controller
public class ErrorController {

	@Autowired
	private ErrorDAO eDAO;
	
	//JSON으로 결과물을 줄 때에도, @ResponseBody 어노테이션은 사용한다. xmlElement 관련 어노테이션을 사용하지 않음.
	
	@RequestMapping(value = "/error.getJSON", method = RequestMethod.GET,
					produces = "application/json; charset=UTF-8")
	public @ResponseBody Errors getErrorJSON(HttpServletRequest req, HttpServletResponse res) {
		//이 사이트 외부에서 AJAX가 가능하게 하려면(원래는 못한다. 보안 정책 어쩌고 때문에)
		//1. 메소드에 응답 관련 파라미터(HttpServletResponse)를 추가한다.
		//2. 이 메소드에 아래 헤더를 추가한다.
		//아래 헤더와 세팅이 잠겨있으면, 프로젝트 실행이 아닌 방법으로 웹에서 실행시킬 경우(예전처럼 파일을 브라우저에 드래그해서 던지면)
		//html이 실행되지 않는다(jQuery가 실행되지 않는 것을 확인했다)
		res.addHeader("Access-Control-Allow-Origin", "*");
		return eDAO.getJSON(req);
	}
	
	@RequestMapping(value = "/error.searchJSON", method = RequestMethod.GET,
					produces = "application/json; charset=UTF-8")
	public @ResponseBody Errors searchErrorJSON(Error e, HttpServletRequest req) {
		return eDAO.searchJSON(e, req);
	}
}
