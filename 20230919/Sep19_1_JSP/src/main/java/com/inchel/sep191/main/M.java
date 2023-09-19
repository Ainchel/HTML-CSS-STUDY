package com.inchel.sep191.main;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// request를 통해 주고받는 값에 대해.
// parameter(a, b)
// attribute(cc)
// 요청을 할 수 있다면 위 값들을 사용할 수 있다.
// 새로운 요청이 생긴다면, 해당 값은 사용할 수 없다.
// First에서, Third까지 값을 살려서 보낼 필요가 있다면?? "session" 을 사용한다.

// HTTP 프로토콜의 특성이자 약점에 대해서.
// 1) Connectionless : 사용자가 요청을 한 뒤에 응답을 받았다면, 해당 연결이 끊어진다.
// 2) Stateless : 통신(요청->응답)이 다 끝나면, 상태를 끊어버린다.

// 위 약점을 보완하기 위해, 쿠키 / 세션이라는 것을 사용할 예정이다.

// 쿠키(Cookie) : 사용자의 상태와 관련된 정보를 컴퓨터에 저장했다가 나중에 참조하는데 사용한다.
//				 사용자가 따로 요청을 하지 않아도, 브라우저가 요청을 하면 자동적으로 서버에 전송을 해준다.
//				 쿠키가 유지되는 시간을 정해놓으면, 브라우저 종료 여부와 관계없이 유지할 수 있다.
//				 => ID/비번 저장하기, 쇼핑몰의 장바구니, 팝업창(오늘하루 보지 않기)... 등에서 사용한다.

// 쿠키는 모델에서 만든 값이어야 한다. 내부적으로는 String타입으로 되어 있다.
// 쿠키의 기본 유지시간은 약 하루(24시간)으로 되어 있다.
// 쿠키는 사용자의 컴퓨터에 저장된다. 요새는 암호화해서 저장한다고 한다.
// 그럼에도 자주 사용하는 것은 보안상 위험하다. 그러므로 노출 시 위험한 정보는 쿠키로 저장하지 않는다.!!!

// 쿠키 값 읽기
// Java : 현재 사용자 컴퓨터에 만들어져 있는 쿠키, 그 중에서도 이 프로젝트의 쿠키를 찾아야 한다.
// JSP(EL형식) : ${cookie.이름.value} 방식으로 접근한다.

// 세션(Session) : 쿠키를 기반으로 동작하지만, 사용자의 정보를 컴퓨터가 아닌 Server에서 관리한다.
// 세션에 들어가있는 정보에 접근하기 위해서는, 세션이라는 이름의 빨대(값을 받아와주는 객체)가 필요하다.
// 접속시간을 설정할 수 있으며, 일정시간동안 응답이 없다면 정보를 삭제한다.
// 쿠키보다는 보안 면에서 좋으나, 메모리 사용량이 크다.
// 세션을 이용하여 사이트를 운영한다면, 동접자가 많을 때 서버에 과부하 + 성능 저하 수순으로 발생할 수 있다.

// session 소속의 Attribute(request쪽 아님)는 M에서 만든다.
// Object 데이터타입이며, 연결만 잘 되어 있으면 어디서든지 사용이 가능하다.
// 유지 시간의 경우, 기본 30분이며 별도로 설정도 가능하다.
// 위 시간 동안 아무런 요청도 하지 않는다면 자동으로 끊긴다.

// 쿠키의 경우, 정해놓은 시간이 완료되거나 쿠키를 삭제하기 전까지 유지된다.
// 세션의 경우, 만료되는 시간을 지정할 수 있으나, 브라우저를 종료할 경우 값이 즉시 삭제된다.

// -parameter : GET방식으로 받았을 떄와, POST방식으로 받았을 때 차이가 있다.
// 1) GET : 주소에 파라미터명=값&파라미터명=$값... 형식으로 다 표시가 된다.
// 2) POST : 내부적으로 파라미터를 전달한다.(컨트롤러 주소에 파라미터명=값 등이 노출되지 않는다.)

// V에서 만든 값이 있다면
// String or String[] : request 소속이다.

// 값 읽기 : 
// 1) Java : request.getParameter("파라미터명");
// 2) JSP(EL 방식) : ${param.파라미터명}

// request 소속의 Attribute : Model(java로 만든)에서 만든 값. Object 데이터형이며, request 소속이다.
// 값 읽기
// 1) Java : request.getAttribute("어트리뷰트명");
// 2) JSP(EL 방식) : ${어트리뷰트명}
// 위 데이터를 보여줄 파일 하나로 더 생성한다.(secondV)
public class M {

	public static void makeSecondData(HttpServletRequest req, HttpServletResponse res) {
		int c = 3000;
		req.setAttribute("cc", c);
		
		int d = 40000;
		HttpSession hs = req.getSession(); // 사용자와 서버 간의 연결상태를 확인해주는 빨대 생성
		hs.setMaxInactiveInterval(15); // session의 유지시간을 15초로 설정.
		hs.setAttribute("d", d); // request가 아닌, session 소속의 attribute를 설정
		
		String e = "500000";
		Cookie ck = new Cookie("e", e);// 쿠키 객체를 생성할 때, 키-밸류 형식으로 이름과 값을 지정해준다.
		ck.setMaxAge(15); // 쿠키의 유지시간을 15초(사용자 컴퓨터에 파일 형태로 저장)로 설정한다.
		res.addCookie(ck); // 응답 객체에 쿠키를 추가해준다.(res는 rep)
	}

	public static void printSecondDataNew(HttpServletRequest req) {
		
		try {
			
			HttpSession hs = req.getSession();
			int d = (Integer)hs.getAttribute("d");
			System.out.println(d);
			
		} catch(Exception e){
			
		}
		
		// 이 프로젝트, naver, daum, youtube.......등등의 사이트를 이용한다면, 사용자 컴퓨터에 쿠키가 있을 것이다.
		
		Cookie[] cks = req.getCookies(); // 저장된 쿠키들을 받아오는 배열을 선언
		
		for(Cookie ck : cks) {
			if(ck.getName().equals("e")) { // 쿠키의 이름이 e인 값이 있다면
				System.out.println(ck.getValue());
			}
		}
		
	}
	
	
	public static void printSecondData(HttpServletRequest req) {
		
		int a = Integer.parseInt(req.getParameter("a"));
		int b = Integer.parseInt(req.getParameter("b"));
		int c = (Integer)req.getAttribute("cc");
		System.out.println("a : " + a);
		System.out.println("b : " + b);
		System.out.println("c : " + c);
	}
	
}
