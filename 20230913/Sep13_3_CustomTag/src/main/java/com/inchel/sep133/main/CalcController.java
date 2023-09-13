package com.inchel.sep133.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalcController
 */
@WebServlet("/CalcController")
public class CalcController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		if(!request.getParameterNames().hasMoreElements()) {
			request.setAttribute("contentPage", "calc.jsp");
			} else {
			
			Calculator.calculate(request);
				
			int x = Integer.parseInt(request.getParameter("x"));
			int y = Integer.parseInt(request.getParameter("y"));
			
			int sum = x + y;
			int min = x - y;
			int mul = x * y;
			int dev = x / y;
			
			request.setAttribute("sum", sum);
			request.setAttribute("min", min);
			request.setAttribute("mul", mul);
			request.setAttribute("dev", dev);
			request.setAttribute("contentPage", "calcresult.jsp");
		}
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
