package com.inchel.Sep112.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
	
	// Java + JSP + CSS + Servlet을 활용하여 가위바위보 게임 페이지를 만들기.
	// 디자인은 알아서. 일단 돌아만 가게? 다만, 가위/바위/보 이미지를 누르면 게임 한판이 진행되게.
	// WAS를 종료할 때까지, 전적은 쌓이게 되고 표시된다. => 매판 진행할 때마다 전적이 보이도록(바뀌도록)
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!request.getParameterNames().hasMoreElements()) { // 요청 파라미터 명이 없다면(==요청 파라미터가 없다면)
			request.getRequestDispatcher("RSPMain.jsp").forward(request, response);
		} 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int mySel = 0;
		int comSel = 0;
		
		String mySelStr = "";
		String comSelStr = "";
		String result = "";
		String myFileString = "";
		String comFileString = "";
		
		if(request.getParameter("SCISSORS") == "") {
			mySel = 1;
			mySelStr = "ジャン";
			myFileString = RSP.fileStringCheck(mySel);
			comSel = (int)(Math.random() * 3) + 1 ;
			comSelStr = RSP.comselName(comSel);
			comFileString = RSP.fileStringCheck(comSel);
			result = RSP.check(mySel, comSel);
			RSP.WinloseCount(result);
		} else if(request.getParameter("ROCK") == "") {
			mySel = 2;
			mySelStr = "ケン";
			myFileString = RSP.fileStringCheck(mySel);
			comSel = (int)(Math.random() * 3) + 1 ;
			comSelStr = RSP.comselName(comSel);
			comFileString = RSP.fileStringCheck(comSel);
			result = RSP.check(mySel, comSel);
			RSP.WinloseCount(result);
		} else if(request.getParameter("PAPER") == "") {
			mySel = 3;
			mySelStr = "ポン";
			myFileString = RSP.fileStringCheck(mySel);
			comSel = (int)(Math.random() * 3) + 1 ;
			comSelStr = RSP.comselName(comSel);
			comFileString = RSP.fileStringCheck(comSel);
			result = RSP.check(mySel, comSel);
			RSP.WinloseCount(result);
		} else if(request.getParameter("RESET") == "") {
			RSP.Reset();
		}
		
		request.setAttribute("MYSELSTR", mySelStr);
		request.setAttribute("COMSELSTR", comSelStr);
		request.setAttribute("RESULT", result);
		request.setAttribute("MYFILESTRING", myFileString);
		request.setAttribute("COMFILESTRING", comFileString);
		
		request.getRequestDispatcher("RSPMain.jsp").forward(request, response);
	}

}
