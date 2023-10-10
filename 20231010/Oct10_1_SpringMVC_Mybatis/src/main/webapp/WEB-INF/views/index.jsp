<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
	<title>Home</title>
</head>
<body>

	<h1> 시험 결과 DB입/출력 예제 </h1><br>
	
	<h2> 결과 : ${r }</h2>
	
	<form action = "test.reg">
	과목명 : <input name = "t_title"><br><br>
	연 : 
	<select name = "t_y">
	<c:forEach var="y" begin="${cy }" end="${cy+10 }" step="1">
	<option>${y }</option>
	</c:forEach>
	</select>&nbsp;년&nbsp;&nbsp;
	
	월 : 
	<select name = "t_m">
	<c:forEach var="m" begin="1" end="12" step="1">
	<option>${m }</option>
	</c:forEach>
	</select>&nbsp;월&nbsp;&nbsp;

	일 : 
	<select name = "t_d">
	<c:forEach var="d" begin="1" end="31" step="1">
	<option>${d }</option>
	</c:forEach>
	</select>&nbsp;일&nbsp;&nbsp;
	
	<br><br>
	
	<button> DB에 데이터 등록 </button>
	</form>
	<hr>
	
	<c:forEach var = "t" items = "${tests }">
		${t.t_title } : <fmt:formatDate value = "${t.t_when }" type = "date" dateStyle = "long" /><p>
	
	</c:forEach>

</body>
</html>
