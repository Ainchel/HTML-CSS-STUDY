<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel = "stylesheet" type = "text/css" href = "loginboxStyle.css">
</head>
<body>

	<div class="menus">
	<h1> Index </h1>
	<h1> Board </h1>
	</div>

	<jsp:include page = "login.jsp"/>
	
	<div class="includecenter">
	<jsp:include page = "${cp }" />
	</div>
	<!--
	회원가입 필요 정보 : 유효성검사 필요
	ID, 비밀번호, 이름, 핸드폰번호, 생일, 사진
	생일고르는 부분은 셀렉트+옵션으로 정하게끔. 날짜는 그냥 31일로 통일
	
	  -->
</body>
</html>