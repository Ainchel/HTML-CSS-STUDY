<%@page import="java.net.URLDecoder"%>
<%@ page import="com.inchel.Sep08.BMIModel2.Guest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- 출력 페이지에서, 싸온 request 보따리를 풀 때 파일명을 decoding 시킨다. -->
	<!-- request.setCharacterEncoding("UTF-8"); << 이거는 페이지에 출력시킬 내용을 UTF-8로 한다는 것이다.  -->
	<!-- 파일명 디코딩은 URLDecoder.decode() << 이거다. request에서 인코딩시킨거 풀어서 출력시켜야 알아듣는다.  -->
	
	<%

	request.setCharacterEncoding("UTF-8");
	
	Guest g = (Guest)request.getAttribute("g");
	
	g.setImage(URLDecoder.decode(g.getImage()));
	
	String name = g.getName();
	String bmi = g.getBmi();
	String result = g.getResult();
	String image = g.getImage();
	
	%>
	
	<h1> 이름 : <%=name %> </h1> <p>
	<h2> bmi 점수 : <%=bmi %></h2> <p>
	<h3> 당신의 체질량 수준은 <%=result %>입니다.</h3>
	
	<img src = "img/<%=image%>">

</body>
</html>