package com.inchel.sep133.main;

import javax.servlet.http.HttpServletRequest;

public class Calculator {
	public static void calculate(HttpServletRequest request) {
		
		int x = Integer.parseInt(request.getParameter("x"));
		int y = Integer.parseInt(request.getParameter("y"));
		
		int add = x+y;
		int substract = x-y;
		int multiply = x*y;
		double devide = x / (double)y;
		String devide2 = String.format("%.2f", devide);
		
		request.setAttribute("a", add);
		request.setAttribute("s", substract);
		request.setAttribute("m", multiply);
		request.setAttribute("d", devide2);
		
	}
	
	
}
