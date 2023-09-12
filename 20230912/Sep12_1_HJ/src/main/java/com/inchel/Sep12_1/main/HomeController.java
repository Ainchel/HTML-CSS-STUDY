package com.inchel.Sep12_1.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!request.getParameterNames().hasMoreElements()) {
			request.getRequestDispatcher("OEGame.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OddEvenManager OEManager = OddEvenManager.getInstance();
		if(request.getParameter("RESET") == "") {
		OEManager.reset(request, response);
		} else if(request.getParameter("ODD") == "" ||
				  request.getParameter("EVEN") == "") {
		OEManager.doGame(request, response);
		}
	}
}
