<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri ="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

		<!-- 
			MyBatis를 활용해서, 전체 과일 데이터를 가격순으로 정렬 후 이름 - 가격 형태로 출력
			ex) 귤 - 2800원
		-->

		여기는 index.jsp입니다. <p><p><p>

		<c:forEach var = "f" items = "${fruitList }">
		${f.f_name} - 
		<fmt:formatNumber value = "${f.f_price }" type = "currency" currencySymbol="₩"/>
		
		<br>
		</c:forEach>
		
		<hr>

</body>
</html>