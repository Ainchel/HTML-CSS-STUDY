package com.inchel.sep192.member;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberDAO {

	//페이지를 여기저기 다닐 예정인데..., 페이지를 옮길 때마다 로그인이 되어있는지 확인이 되어야 한다.
	
	public static boolean loginCheck(HttpServletRequest req) {
		Member m = (Member)req.getSession().getAttribute("m"); //세션에 저장되어있는 멤버 받아오기
		//로그인이 유지 중이거나, 로그인에 성공했다라면 윗줄 코드(변수 m에)에 값이 있을 것이다.
		
		return(m != null);
	}
	
	//로그인 기능
	public static void login(HttpServletRequest req, HttpServletResponse res) {
		
		try {
			req.setCharacterEncoding("UTF-8");
			String id = req.getParameter("id");
			String pw = req.getParameter("pw");
			
			// 로그인 성공한 유저의 정보는, 사이트 어디에서든지 사용할 수 있어야 한다.
			// 하지만 일정 시간이 지나면, 로그인 상태가 풀리게끔 할 것이다.
			// session 소속의 attribute, 혹은 쿠키를 사용해야 할 것이다.
			// 하지만 cookie는 위험하므로, session을 사용해볼 예정이다.
			
			if(id.equals("help") && pw.equals("me")) {
				Member m = new Member(id, pw);
				req.getSession().setAttribute("m", m);
				req.getSession().setMaxInactiveInterval(10); // 유지시간 10초로 설정
			}
			
			//한번 로그인에 성공했다면, 다음에 이 사이트에 들어왔을 때 <input> 자리에 해당 id값이 남아있었으면 좋겠다.
			//즉, 접속을 끊거나 재부팅을 해도 값이 남아있어야 하므로, cookie를 사용해야 한다.
			
			Cookie c = new Cookie("lastLoginId", id);
			c.setMaxAge(6000); // 600초 == 10분
			res.addCookie(c);
			
		} catch(Exception e) {
			
		}
		
	}
	
	
}
