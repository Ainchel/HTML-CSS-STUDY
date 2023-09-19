package com.inchel.sep191.main;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//우리가 controller를 쓰는 이유
// JSP 환경에서 상황판단을 하기에는 어려운 부분이 많았다. 복잡하고.
// 요청 방식이 GET방식인지? POST인지? 그래서 Servlet을 시작 기점으로 많이 잡았었다.
// Controllr는 계산/처리가 필요할 때에는 Model로 보냈었고, 보여줘야한다면 View로 보내는 흐름제어를 담당하고 있었다.

@WebServlet("/FirstC") // 이 줄의 어노테이션을 통해, FirstC를 톰캣에 등록했었다.
					   // 그레서 저 어노테이션과, 클래스명을 잘 일치시켜주어야 한다.

//서블릿에 메인메소드는 없다. 톰캣이 main을 가지고 있고, 아래 클래스 객체를 만들어서 알아서 해준다.
//이전 프로젝트는 시작 부분에서, 생성자를 만들어 사과총갯수를 받아오는 등의 코드를 작성했었다.
public class FirstC extends HttpServlet {
	
	public FirstC() {
		super();
	}
	
	//웹사이트의 페이지 전환 : Controller를 거쳐서 Model로 건너가 데이터 작업 => V로 포워딩하는 방식을 사용했었다.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//사이트에 처음 들어오면 그냥 doGet을 먼저 실행한다.
		//FirstC서블릿에 요청파라미터가 없다면, Get방식으로 실행한다.
		
		if(!request.getParameterNames().hasMoreElements()) { // 요청파라미터가 없다면
			// 아래 jsp로, 지금 일어난 요청을 제보해주는 객체 rd 선언
			RequestDispatcher rd = request.getRequestDispatcher("firstV.jsp");
			rd.forward(request, response); // firstV.jsp를 포워딩해준다.
		}

	}

	//웹사이트의 페이지 전환
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		
	}

}
