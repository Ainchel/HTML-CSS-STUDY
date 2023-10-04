package com.inchel.oct042;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.inchel.oct042.dog.Dog;
import com.inchel.oct42.book.Book;

@Controller
public class HomeController {
	
	// Spring : Java에서 IoC로 DI해주는 Framework.
	// 현재까지의 Java 사용 : 객체를 .java에서 만들어왔다.
	// 그렇다면, 객체를 외부파일(.xml)에서 만든 후, .java에 불러서 사용하게끔 할 수 있을까?
	// IoC란? 제어의 역전(Inversion of Control)이라는, 디자인 패턴 중 하나를 가리킨다.
	// 이는 프로그램의 제어 흐름을 직접 제어하지 않고, 외부에서 관리하는 것을 말한다.
	
	// DI란? 의존성 주입(Dependency Injection)이라는, 위 IoC를 수행하는 방법 중 하나를 가리킨다.
	// 아래의 코드(xml에서 만든 객체를 받아오는 코드)를 참조하자.
	// xml에서 객체를 만들고 속성을 넣은 후, 해당 값들을 java에서 가져다 쓰는 방식이 바로 DI이다.
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		// 강아지 객체를 하나 만들어서, 이름 및 나이 정보를 담은 syso로 출력하게끔 만들어보자.
		
//		Dog dog = new Dog("싯대", 3);
//		System.out.println(dog.getName());
//		System.out.println(dog.getAge());
		
		//oct042beans.xml에서 만든 객체의 값을 불러와보기.
		//AbstractApplicationContext : xml에서 만든 bean의 객체를 생성하고 관리하는 기능을 가진다.
		
		//객체를 생성할 때, 패러미터 값으로 String Bean Configuration File의 이름을 적어준다.
		AbstractApplicationContext aac =
				new ClassPathXmlApplicationContext("oct042beans.xml");
		
		//aac가 없어지면, aac를 통해 등록해놓은 객체들을 전부 제거해준다.
		aac.registerShutdownHook();
		
		//id가 d인 강아지 객체를 불러와보자.
		
		Dog d = aac.getBean("d", Dog.class); // xml에서, Dog라는 이름의 class인 객체 d를 불러와라.
		System.out.println(d);
		
		Dog d2 = aac.getBean("d2", Dog.class);
		System.out.println(d2.getName());
		System.out.println(d2.getAge());
		System.out.println("----------------------------");
		
		Dog d3 = aac.getBean("d3", Dog.class);
		System.out.println(d3.getName());
		System.out.println(d3.getAge());
		System.out.println("-----------------------------");
		
		//아래에 책 객체를 2개(이름/가격 형식) 만드는데, 각각 다른 방식으로 만들고 값을 받아와보자.
		Book b = aac.getBean("b", Book.class);
		System.out.println(b.getName());
		System.out.println(b.getPrice());
		System.out.println("----------------------------");
		
		Book b2 = aac.getBean("b2", Book.class);
		System.out.println(b2.getName());
		System.out.println(b2.getPrice());
		System.out.println("----------------------------");
		
		// aac 없애기
		aac.close();
		
		return "home";
	}
	
}
