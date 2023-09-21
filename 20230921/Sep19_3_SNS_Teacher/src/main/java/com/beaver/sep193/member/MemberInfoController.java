package com.beaver.sep193.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beaver.sep193.main.DateManager;

@WebServlet("/MemberInfoController")
public class MemberInfoController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (MemberDAO.loginCheck(request)) {
			DateManager.getCurYear(request);
			request.setAttribute("cp", "member/info.jsp");
		} else {
			request.setAttribute("cp", "home.jsp");
		}
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//회원정보 페이지에서 수정버튼 누른 후 데이터 입력하고 수정 눌렀다면
		if(MemberDAO.loginCheck(request)) { // 로그인된 상태라면
			//수정 페이지에서 전달받은 데이터로 업데이트 진행
			MemberDAO.update(request);
			DateManager.getCurYear(request); // 현재 날짜 받아오기
			request.setAttribute("cp", "member/info.jsp"); //수정된 정보로 로그인된 페이지 출력
		} else { // 로그인된 상태가 아니라면
			request.setAttribute("cp", "home.jsp"); // 그냥 홈으로 이동
		}
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

}









