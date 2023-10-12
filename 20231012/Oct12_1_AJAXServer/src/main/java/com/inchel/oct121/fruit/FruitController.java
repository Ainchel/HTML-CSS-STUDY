package com.inchel.oct121.fruit;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FruitController {

	@Autowired
	private FruitDAO fDAO;
	
	//기존에 쓰던 리퀘스트매핑에 이어, 추가로 속성을 작성한다.
	@RequestMapping(value = "/fruit.getXML", method = RequestMethod.GET, produces = "application/xml; charset=UTF-8")
	public @ResponseBody Fruits getFruitXML(HttpServletRequest req) {
		return fDAO.getXML(req);
	}
	
	@RequestMapping(value = "/fruit.searchXML", method = RequestMethod.GET, produces = "application/xml; charset=UTF-8")
	public @ResponseBody Fruits getSearchXML(Fruit f, HttpServletRequest req) {
		return fDAO.searchXML(f, req);
	}
}
