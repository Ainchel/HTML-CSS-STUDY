package com.beaver.sep193.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beaver.sep193.member.MemberDAO;

@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//로그인 체크 - 현재 세션에 로그인 객체(DTO인Member객체)가 있는지 확인하고, 결과에 따라 lp(로그인 페이지) 값을 바꿔준다.
		MemberDAO.loginCheck(request);
		//cp(콘텐츠 페이지) 설정하고 index.jsp로 이동
		request.setAttribute("cp", "home.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
