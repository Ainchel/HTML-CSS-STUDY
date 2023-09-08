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

	<% 
		//다른 parameter를 읽어오기(paramter는 html에서 만든 데이터)
		int a = Integer.parseInt(request.getParameter("formX"));
	
		//위 코드를 조금 풀어서 써보자. 자료형 변환 흐름을 중심으로.
		String bbb = request.getParameter("formY"); // String형 데이터.
		Integer bb = Integer.parseInt(bbb); 	// String -> Integer로 형변환
		int b = bb.intValue();					// Integer => int로 형변환
		
		//다른 Attribute를 읽어오기(Attribute는 html 속 java에서 만든 데이터.)
		Object zzz = request.getAttribute("formZ");	//어트리뷰트 받아올 때에는 request.getAttribute를 사용
		Integer zz = (Integer)zzz;				//Object -> Integer로 변환
		int z = zz.intValue();					//Integer => int로 변환
		
		String str = (String)request.getAttribute("str");
		Random r = (Random)request.getAttribute("r");
	%>
	
	<h1>Third</h1>
	a : <%=a %> <br>
	b : <%=b %> <br>
	z : <%=z %> <br>
	str : <%=str %> <br>
	r : <%=r.nextInt(100) + 1 %> <br>


</body>
</html>