<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- <link rel = "stylesheet" href="css/style.css"> -->

<script type = "text/javascript" src = "js/ValidCheck.js"></script>

</head>
<body>

	<header><h2> 제목 </h2></header>
	
	<main>
	<div>
	<jsp:include page = "${cp}" />
	</div>
	</main>
	
	<nav>
	<div> <a href = "AppleDBController"> AppleDB </a> </div>
	<div> <a href = "A"> Banana</a> </div>
	<div> <a href = "B"> Coconut</a> </div>
	<div> <a href = "DBCController"> DB연결</a> </div>
	</nav>
	
</body>
</html>