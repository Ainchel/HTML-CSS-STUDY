<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1 align = "center"> 데이터 등록</h1><p>
	
	<form action = "AppleDBController" id = "FORM">
	지역 <input name = "inputlocation">  <br>
	색 <input name = "inputcolor"> <br>
	맛 <input name = "inputtaste"> <br>
	가격 <input name = "inputprice"> 		   <br>
	소개 <input name = "inputintroduce"> 	   <br>
	<button> 데이터 등록! </button>
	</form>
</body>
</html>