<%@page import="com.inchel.Sep141.apple.AppleDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix= "c" uri= "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix= "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<hr>

	여기는 AppleDB <br>
	DB 연결 결과 : ${result}<p><p>
	
	<%
		ArrayList<AppleDTO> aList = (ArrayList<AppleDTO>)request.getAttribute("alist");
		for(int i = 0; i < aList.size(); i++){%>
		<div> 지역 : <%=aList.get(i).getLocation() %> 가격 : <%=aList.get(i).getPrice() %></div> <p><p>
		
	<% 	
		}
	%>
	
	<hr>
	
	<jsp:include page = "pages.jsp" />
	
	<hr>
	<div> <a href = "appleregister.jsp"> 데이터 등록 페이지로 이동 </a> </div>
	
	<hr>


</body>
</html>