package com.inchel.Sep141.apple;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AppleUpdateController")
public class AppleUpdateController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("애플업데이트 doPost 진입");
		
		AppleDB.getAppledb().getPageCount(request);
		AppleDB.getAppledb().updateAppleDB(request);
		AppleDB.getAppledb().getAppleDB(request);
		request.setAttribute("cp", "appleoutput.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
