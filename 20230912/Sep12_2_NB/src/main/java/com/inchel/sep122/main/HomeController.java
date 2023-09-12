package com.inchel.sep122.main;

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
			request.getRequestDispatcher("NBGame.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			NBManager nbm = NBManager.getInstance();
			if(nbm.comNum == "") {
			nbm.comNum = nbm.createComNum();
			}
			
			if(request.getParameter("USERNUM") != null) {
			nbm.doNBGame(request, response, nbm.comNum);
			}
			
			if(request.getParameter("RESET") == "") {
				nbm.reset();
			}
			
			request.getRequestDispatcher("NBGame.jsp").forward(request, response);
	}

}
