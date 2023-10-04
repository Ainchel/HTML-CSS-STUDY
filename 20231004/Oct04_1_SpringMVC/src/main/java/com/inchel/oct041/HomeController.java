package com.inchel.oct041;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		return "home";
		//servlet-context.xml로 가보자.
		//위 파일의 "beans"부분에서, prefix인 "/WEB-INF/views"와 중간 경로인 이 함수 리턴값 "home"에,
		//suffix인 ".jsp"가 합쳐져 /WEB-INF/views/home.jsp라는 view 파일의 경로를 통하여
		//클라이언트에게 응답을 해주는 구조로 되어 있다.
		
		//위 코드에서 사용되는 @ 표시는 "어노테이션" 이라고 하는데, 코드 사이에 주석으로 쓰이면서도 특정 기능을 수행하게끔 만들어진 것이다.
		//기능 1) 코드 작성 시, 문법 에러를 체크하게끔 한다.
		//기능 2) 특정 개발 툴이 코드를 자동으로 생성하게끔 한다. 우리는 이쪽 기능을 많이 사용할 것 같다.
		//기능 3) 코드 실행 시, 특정 기능을 수행하게끔 한다. 우리는 이쪽 기능을 많이 사용할 것 같다.
		
		//어노테이션의 종류 : 자주 사용하는 것들 위주이며, 그 중에서도 2,3,5,6,8번 5개를 가장 많이 사용한다.
		//위 2,3,5,6,8번을 우선적으로 기억해두도록 하자. 
		//1) @Bean : 개발자가 직접 제어할 수 없는, 외부에서 가져온 라이브러리 등을 Bean()으로 만들 때 사용한다.
		//2) @Autowired : 어떤 객체의 속성, setter, 생성자에서 사용하며 사용한 타입에 따라 Bean을 주입한다.
		//3) @Controller : 적용한 클래스를 Spring에서의 "컨트롤러" 로 간주시킬 때 사용한다. View(화면 및 .jsp 등을 담당)를 return시키는 것이 목적이다.
		//4) @RestController : Controller 중에서도, View에 해당하지 않는 xml, json 등을 return시켜준다.
		//					   Spring 4.x.x 버전부터 제공하여, 우리가 지금 사용하는 버전에서는 못쓴다.
		//5) @ResponseBody : 자바 객체를 HTTP의 Body 내용으로 매핑시켜주는 역할을 한다.
		//				 	 RestController는 @Controller와 @ResponseBody를 합쳐 만든다.
		//6) @Service : 비즈니스 로직을 수행하는 Class를 나타낼 때 사용한다.
		//				여기서의 비즈니스 로직(Business Logic)이란, 사용자 눈에는 안보이지만 사용자에게 필요한 결과를 내기 위해 짜여진 코드를 가리킨다.
		//				Ex) DAO에서 만들어냈던 각종 기능들. 유저에게는 보이지 않지만 필요한 결과나 연산을 처리하는데 만들었었다.
		//7) @XmlRootElement / @XmlElement : OXM(Object XML Mapping)에 사용한다.
		//	 OXM이란, 특정 데이터를 XML 형태로 만들어주는 것을 가리키며, 이를 마샬링(Mashalling)이라고 한다.
		//	 반대로, XML을 특정 데이터로 만들어주는 것은 언마샬링(Unmashalling)이라고 한다.
		//8) @RequestMapping : 요청에 따라 어떤 Controller, Method로 처리할 것인지 매핑하기 위해 사용한다.
		// 	 이 파일을 확인해보면, @RequestMapping(value = "/", method = RequestMethod.GET) 라고 되어있다.
		//	 value 값을 통해 요청받을 주소(URL)를 지정하고, method 값을 통해 요청 방식을 지정한다.
		//	  요청 방식으로는 GET,POST,PUT,DELETE,FETCH...등등 있으나, GET 및 POST만으로 전부 가능하다.
		//	 W3C(World Wide Web Consortium)이라는 곳에서 PUT, DELETE, FETCH를 사장시켰다.
		//9) @RequestParam : 요청 파라미터를 설정하는 데 사용한다.
		
	}
	
}
