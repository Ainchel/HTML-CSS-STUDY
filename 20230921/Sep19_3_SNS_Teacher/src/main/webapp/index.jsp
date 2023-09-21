<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/BeaverValidCheck.js"></script>
<script type="text/javascript" src="js/memberCheck.js"></script>
<script type="text/javascript" src="js/go.js"></script>
<link rel="stylesheet" href="css/index.css">
<link rel="stylesheet" href="css/member.css">
<link rel="stylesheet" href="css/signup.css">
</head>
<body>
	<table id="siteTitleTbl">
		<tr> <!-- 홈으로 가는 버튼 -->
			<td id="siteTitle" align="center"><a href="HomeController">SNS MODE</a></td>
		</tr>
		<tr> <!-- 아직 없는 빈 버튼  -->
			<td id="siteMenu" align="center"><a href="#">Board</a></td>
		</tr>
	</table>
	<table id="siteContentTbl">
		<tr> <!-- 화면 중앙에 콘텐츠 페이지 include하여 출력  -->
			<td id="siteContent" align="center"><jsp:include page="${cp }" /></td>
		</tr>	
	</table>
	<table id="siteLoginTbl">
		<tr>
			<td> <!-- 화면 우측에 로그인 페이지 include하여 출력  -->
				<jsp:include page="${lp }"/><span id="dbResult">${r }</span>
			</td>
		</tr>
	</table>
</body>
</html>




