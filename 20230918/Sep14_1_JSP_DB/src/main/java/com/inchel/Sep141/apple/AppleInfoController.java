package com.inchel.Sep141.apple;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AppleInfoController")
public class AppleInfoController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		if(AppleDB.getAppledb().getAppleInfo(request)) {
		request.setAttribute("cp", "appleinfo.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
		} else {
		request.setAttribute("cp", "appleoutput.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
