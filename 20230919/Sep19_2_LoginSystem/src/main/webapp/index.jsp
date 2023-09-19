<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action = "LoginController" method = "post">
		ID <input name = "id" value = "${cookie.lastLoginId.value }"> <p> 
		PW <input name = "pw"> <p>
		<button> 로그인 </button>
	</form>

</body>
</html>