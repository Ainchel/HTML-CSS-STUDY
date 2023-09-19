<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1> Third </h1>
	
	<hr>
	a : ${param.a } <br>
	b : ${param.b } <br>
	c : ${cc } <br>
	<!-- 세션에서 값을 받아오는 방법 -->
	d : ${sessionScope.d } <br>
	<hr>
	<%
		//아래 include를 사용할 때, 잘못되면 무한루프가 자꾸 돈다.
		//include가 잘못되었을 때, 혹은 없는 페이지를 include했을 때 무한루프가 발생한다.
		//
		
	%>
	<jsp:include page = "${baby }"/>
	

</body>
</html>