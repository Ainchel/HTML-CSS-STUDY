<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel = "stylesheet" href = "resources/css/index.css">
<script type = "text/javascript" src = "resources/js/index.js"></script>

</head>
<body>
	jsp는 MVC에서 V(View)에 해당한다.
		JSP : .html이나 .jsp를 사용했었다.
		Spring에서는? .jsp를 사용한다.(권장)
		Spring Boot에서는? .html을 사용한다.(권장)
		
	Spring 내에서 쓰는 자원 파일(css, js, 그림 등등...)은, src/main/webapp/resources에서 관리한다.
	resources 폴더는 webapp 밖에도 있는데, 얘 쓰는거 아님. 위 경로에 있는 폴더 활용

	여기는 index.jsp입니다
	<hr>
	<form action ="calculate.do" method = "post"><br>
	n : <input name = "n"><br>
	x : <input name = "x"><br>
	y : <input name = "y"><br>
	<button> 입력 </button>
	</form>

	<hr>
	<c:if test = "${r != null}"> 계산 결과 : ${r}</c:if>

</body>
</html>