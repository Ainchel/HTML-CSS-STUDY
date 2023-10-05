package com.inchel.oct051;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.inchel.oct051.fruit.Fruit;
import com.inchel.oct051.member.MemberDAO;

@Controller
public class HomeController {
	
	@Autowired
	private Fruit f;
	
	//Servlet-context.xml에 객체가 없지만, @Service어노테이션으로 등록했기 때문에 @Autowired도 사용 가능하다.
	@Autowired
	private MemberDAO mDAO;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		//이 프로젝트를 실행하면, Fruit 클래스 객체를 하나 생성(이름/가격)하는데,
		//Fruit의 속성값은 servlet-context.xml에서 작성하도록 한다.
		//작성한 값을 이 메소드 내에서 가져와 출력시키기.
		
		//servlet-context.xml에서 만든 객체 값을 Autowired로 가져오기.
		//그래서, servlet-context.xml / root-context.xml에서 만든 객체 하나를 받아오는 패턴을 왜 쓰느냐?
		//
		
		System.out.println(f.getName());
		System.out.println(f.getPrice());
		
		mDAO.test();
		
		return "home";
	}
	
}
