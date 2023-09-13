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
	<a href = "AController"> A </a>
	<a href = "BController"> B </a>
	<a href = "CController"> C </a>
	</div>
	<hr>
	
	<div>
	  <jsp:include page = "home.jsp">
	</div>
	
</body>
</html>