<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!--form으로 전달받은 데이터 처리하기-->
	
	<!-- 웹 언어 상에서의 자료형들 이름 유형
		1) Parameter
		html인 다른 페이지에서 넘겨받은 값들이며, request에 저장된다.
		String 혹은 String[]형으로 저장되며, 필요할 경우 형변환을 해주면 된다.
		
		2) attribute
		java에서 만들어낸 값이며, request에 저장된다.
		각 값들은 Object(객체)형으로 저장된다.
	-->
	
	<!--페이지 간 이동에 대하여.
		우리가 first => second로 이동할 때의 경우 : 사용자가 뭔가 액션을 해서 넘어옴.
		액션들 ? form, <a href>, js의 location.href으로 request(요청)를 하고, 응답을 받은 상태.
		
	-->
	
	<%
		request.setCharacterEncoding("UTF-8");
	
		int formX = -999999;
		int formY = -999999;
			
		try{
		formX = Integer.parseInt(request.getParameter("formX"));
		formY = Integer.parseInt(request.getParameter("formY"));
		} catch(Exception e){
			
		}
		
		/* JSP에서 만든 값을 JSP에서 넘기려면?? 3가지 방법과는 다른 방법을 사용해야 한다.*/
		
		//아래 코드도 Third.jsp로 이동시켜주는 코드??
		//RequestDispatcher : 클라이언트(사용자)로부터 들어온 요청을 원하는 쪽으로 넘기는 함수. 
		//이렇게 넘어갈 때, request.setAttribute(key, value) 메소드를 통해 집어넣은 데이터를 가지고 가서 처리할 수 있다.
		//여기 Second.jsp에서 아래 함수를 쓰면, second => third로 바로 넘어가버린다.
		
		//여기서 redirect와 RequestDispatcher 내 두 메소드(forward, include)의 차이에 대한 설명.
		//1) redirect : response.sendRedirect("Third.jsp")와 같이 사용하여, 중간에 URL을 가로채서 중간 행동 없이 바로 넘어간다.
		
		//2) forward : 자동으로 페이지를 이동시키지만, redirect와는 다르게 값을 넘겨받은 채로 이동하여, 받은 데이터를 다음 페이지에서 처리할 수 있다.
		//그래서 First에서 Second로 요청을했으나, Second 내 forward를 통해서 Third로 곧바로 이동한 것이다. (데이터를 가지고)
		
		//3) include : RequestDispatcher 내 메소드. Second 속에 Third를 포함시키는 감각
		//다만, 위치 조절이 불가능하여, 항상 포함되는 페이지(Third)가 위에 와버린다. 그래서 사용은 비추...
		//나중에 위치 조절이 가능한 include를 사용할 것이므로, 이 파일 당장에서는 forward를 사용하는 쪽으로.
		RequestDispatcher rd = request.getRequestDispatcher("Third.jsp");
		
		int formZ = formX + formY;
		String str = "가렵맛있";
		Random r = new Random();
		
		request.setAttribute("formZ", formZ); // 다른 페이지로 넘길 값을 이렇게 등록한다.
		request.setAttribute("str", str);
		request.setAttribute("r", r);

		//rd.forward(request, response); // First에서 이 페이지(Second)로 넘어온 후, 자동으로 Third로 넘겨버림.		
		rd.include(request, response);	 // 이 함수를 만나 Third로 넘어가 처리한 데이터를 이 페이지(Second)에 포함시켜 출력.
		
	%>
	
	<h1> Second </h1>
	
	<h2> form으로 전달받은 두 수 : <%=formX %>와 <%=formY %> 입니다. </h2>
	
	<%
		int jsX = -999999;
		int jsY = -999999;
		
		try{
		jsX = Integer.parseInt(request.getParameter("jsX"));
		jsY = Integer.parseInt(request.getParameter("jsY"));
		} catch(Exception e){
			
		}
	%>
	
	<h2> JS로 전달받은 두 수 : <%=jsX %> 와 <%=jsY %> 입니다.</h2>
	
	<%
		int hrefX = -999999;
		int hrefY = -999999;
	%>
</body>
</html>