<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel = "stylesheet" type = "text/css" href = "menuStyle.css">
</head>
<body>

	<hr>
	<div id = "Menus">
	<a href = "HomeController"> Home </a>
	<a href = "CalcController"> 사칙연산 </a> <!-- 새로운 페이지 입장 후, 그 페이지에서 BTN으로 GET방식으로 보내기 -> 사칙연산 -> -->
	<a href = "JSTLCController"> JSTL-Core </a>
	<a href = "JSTLFController"> JSTL-Format </a>
	</div>
	<hr>
	
	  <jsp:include page = "${contentPage }"/>
	
</body>
</html>