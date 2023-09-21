<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table id="loginSuccessTbl">
		<tr>
			<td rowspan="2">
				<img src="img/${sessionScope.loginMember.m_photo }">
			</td>
			<td>${sessionScope.loginMember.m_id }</td>
		</tr>
		<tr>
			<td align="center" colspan="2">${sessionScope.loginMember.m_name } 님</td>
		</tr>
		<tr>
			<td align="center" colspan="2">어서오세요</td>
		</tr>
		<tr>
			<td align="center" colspan="2">
				<button onclick="memberInfoGo();">정보</button>
				<button onclick="logout();">로그아웃</button>
			</td>
		</tr>
	</table>
</body>
</html>















