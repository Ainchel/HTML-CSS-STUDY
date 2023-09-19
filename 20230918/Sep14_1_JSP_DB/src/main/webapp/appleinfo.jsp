<%@page import="com.inchel.Sep141.apple.AppleDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type = "text/javascript" src = "deletecheck.js"> </script>

</head>
<body>

	여기는 appleinfo.jsp입니다.
	<p><p>
		
	<%AppleDTO a = (AppleDTO)request.getAttribute("info"); %>

	<form action = "AppleUpdateController" method = "post">
	<div> 지역 : <input name = "updatelocation" value = "<%=a.getLocation()%>" readonly = "true"></div><p>
	<div> 색깔 : <input name = "updatecolor" value = "<%=a.getColor()%>" ></div><p>
	<div> 맛 : <input name = "updatetaste" value = "<%=a.getTaste()%>" ></div><p>
	<div> 가격 : <input name = "updateprice" value = "<%=a.getPrice()%>" ></div><p>
	<div> 설명 : <input name = "updateintroduce" value = "<%=a.getIntroduce()%>" ></div><p>
	<p>
	<div><button> 수정 </button> </div>
	</form>
	
	<button onclick = "deleteApple('${deletelocation}')">
	 삭제
	</button>

</body>
</html>