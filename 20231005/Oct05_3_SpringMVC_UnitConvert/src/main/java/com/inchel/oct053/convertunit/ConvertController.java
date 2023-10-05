package com.inchel.oct053.convertunit;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ConvertController {

	@Autowired
	private ConvertDAO cDAO;
	
	@RequestMapping(value = "/unit.convert", method = RequestMethod.GET)
	public String goOutput(ConvertResult cr, HttpServletRequest req) {
		
	cDAO.convert(cr, req);
		
	return "output";
	}
	
}
