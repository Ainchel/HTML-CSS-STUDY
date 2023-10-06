<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	여기는 index.jsp입니다.
	
	${r }
	<form action = "student.reg">
		이름 : <input name = "s_name"><p>
		별명 : <input name = "s_nickname"><p>
		<button> 등록 </button>
	</form>
	<hr>
	
	이름과 별명 목록<br><br><br>
	
	<c:forEach var="student" items="${list }">
	
	${student.s_name } : ${student.s_nickname } <br>
	
	</c:forEach>

</body>
</html>