package com.inchel.oct121.fruit;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // xml에 객체를 등록한 것처럼 처리해주기 위한 어노테이션
public class FruitDAO {

	@Autowired // xml에 있는 객체를 자동으로 받아와주는 어노테이션
	private SqlSession ss;
	
	public void getAllFruit(HttpServletRequest req) {
		
		try {
			
			FruitMapper fm = ss.getMapper(FruitMapper.class);
			
			List<Fruit> fruitList = ss.selectList("getAllFruit");
			
			for(Fruit f : fruitList) {
				System.out.println(f.getF_name());
				System.out.println(f.getF_price());
			}

			req.setAttribute("fruitList", fruitList);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("DB조회 실패");
		}
		
	}
	
	//Spring 여기에서 xml 형태로 데이터를 끌어오는 시스템 : XML AJAX Server라고 한다.
	//현재, 우리는 DB에서의 레코드 하나를 표현할 JavaBean(DTO- Fruit.java)를 가지고 있다.
	//그리고 우리에게 필요한 것은, DB에 있는 과일 테이블의 데이터를 표현할 또 다른 Javabean이다.
	//또한, Spring 상에서 XML 데이터로 변환할 수 있도록, 각각의 JavaBean에(클래스명 위에) @xmlRootElement 어노테이션을 달아줄 것이다.
	//마지막으로, 각 Javabean 별로 있는 Setter들 위에 "@XmlElement" 어노테이션을 달아준다.
	
	public Fruits getXML(HttpServletRequest req) {
		List<Fruit> fruits = ss.getMapper(FruitMapper.class).getAllFruit();
		Fruits fruitss = new Fruits(fruits);
		return fruitss;
	}
	
	public Fruits searchXML(Fruit f, HttpServletRequest req) {
		List<Fruit> fruits = ss.getMapper(FruitMapper.class).getSearchFruit(f);
		Fruits fruitss = new Fruits(fruits);
		return fruitss;
	}
	
}
