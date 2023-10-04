package com.inchel.oct043;

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

import com.inchel.oct043.human.Human;

@Controller
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		AbstractApplicationContext aac = 
				new ClassPathXmlApplicationContext("oct043beans.xml");
		aac.registerShutdownHook();
		
		Human h1 = aac.getBean("h1", Human.class);
		System.out.println(h1.getName());
		System.out.println(h1.getAge());

		for(String nn : h1.getNickname()) {
			System.out.println(nn);
		}
		
		for(String f : h1.getFriend()) {
			System.out.println(f);
		}
		
		System.out.println(h1.getFamily().get("아버지"));
		System.out.println(h1.getFamily().get("어머니"));
		System.out.println(h1.getFamily().get("동생"));
		
		System.out.println(h1.getPet().getName());
		System.out.println(h1.getPet().getAge());
		
		System.out.println(h1.getPet2().getName());
		System.out.println(h1.getPet2().getAge());
		System.out.println("--------------------------");
		
		System.out.println(h1.getPet3().getName());
		System.out.println(h1.getPet3().getAge());
		System.out.println("--------------------------");
		
		System.out.println(h1.getPet4().getName());
		System.out.println(h1.getPet4().getAge());
		System.out.println("--------------------------");
		
		System.out.println(h1.getPet5().getName());
		System.out.println(h1.getPet5().getAge());
		System.out.println("--------------------------");
		
		aac.close();
		
		return "home";
	}
	
}
