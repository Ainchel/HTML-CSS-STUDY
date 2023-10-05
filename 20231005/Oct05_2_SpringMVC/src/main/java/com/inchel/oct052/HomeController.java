package com.inchel.oct052;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//JSP Model 2로... 만들어보기.
// 어제, 스프링으로 만든 프로젝트의 URL은 "http://IP:Port/프로젝트명/컨트롤러파일명" 이라고 했었다.
// 그리고 컨트롤러 파일 명은 Servlet 명이라고 했었다.
// 그렇다면, 컨트롤러를 통해 상황을 판단하고 흐름을 제어해야 하는데... 여기서 doGet과 doPost를 사용했다.
// 결국 컨트롤러 하나에 잘 해봐야 3가지 분기로 작동시킬 수밖에 없어서, 결론적으로 컨트롤러가 많이 필요했다.

// 하지만 Spring에서의 MVC에서는?
// URL 형식이 달라짐에 따라, http://IP:Port/top-level-package/우리 임의대로 지정한 값을 쓸 수 있다.
// 컨트롤러 부분에서는 일반 클래스를 사용하게 될 것이다.
// 그리고, doGet과 doPost 대신 일반 메소드를 사용하게 될 것이다.
// 즉, 컨트롤러 하나에 기존 분기 외에도 더더욱 많은 요청을 처리할 수 있게 된다.
// 즉즉, 예전처럼 서블릿이라는 컨트롤러 여러개를 만들 필요가 없어지게 된다.
// 그것을 가능하게 하기 위해, "이 클래스가 컨트롤러다" 를 가리키는 "@Controller" 어노테이션을 사용한 것.

@Controller
public class HomeController {
	
	//메소드를 통해 페이지를 이동시키기 위해, 아래 @RequestMapping 어노테이션을 사용한다.
	//어노테이션에 패러미터를 넣듯이, 새로 지정할 URL과 접근 방식(GET?POST?등등)을 넣어준다.
	//아래 value는 별도 URL이 아직 없으며, 접근 방식으로는 최초 페이지이므로 GET방식을 사용하겠다는 뜻이다.
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String goGome() { // 스프링에서의 컨트롤러는, 기본적으로 메소드들의 반환형을 String으로 지정한다.
							 // 그 이유는, String return값으로 jsp를 지정할 것이기 떄문이다.
	return "index";
	}
	
	@RequestMapping(value = "/hehehe.test", method = RequestMethod.GET)
	public String goHehehe() {
		
	return "index2";
	}
	
	@RequestMapping(value = "/lalala.test", method = RequestMethod.GET)
	public String goLalala() {
		
	System.out.println("랄랄라~");
	
	return "index";
	}
	
}
