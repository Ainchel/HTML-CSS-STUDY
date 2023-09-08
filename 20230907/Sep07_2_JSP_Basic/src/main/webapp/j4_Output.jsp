<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<!-- 
	JSP로 전송받을 때, Servlet과 같은 구조임을 기억하고 Servlet 다루듯 하면 됨. 아래 참조
	아래 전송 방식은 기본적으로 GET방식임. POST 방식일 경우 요청파라미터 인코딩 처리를 해야된다.		
	잘 모르겠으면 그냥 생각날때마다 해두자. 
	위 1번하고 6번 라인 코드에서 UTF 세팅을 다 해주고 있어서, 이번에는 아무것도 안해도 된다.
	이번 케이스에서, 보내는 값은 인코딩처리 그냥 한다.
	-->
	
	<%
		request.setCharacterEncoding("UTF-8");
	
		String name = request.getParameter("NAME");
		int x = Integer.parseInt(request.getParameter("X"));
		int y = Integer.parseInt(request.getParameter("Y"));
		int z = x + y;
	%>
	
	<div>전송 받은 이름 : <%=name %></div>
	<div><h1>전송 받은 x와 y의 합 :<%=z %> </h1></div>

</body>
</html>