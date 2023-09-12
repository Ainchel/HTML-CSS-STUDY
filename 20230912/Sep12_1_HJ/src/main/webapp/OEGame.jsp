<%@page import="com.inchel.Sep12_1.main.OddEvenManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div align = "center"><h1>-=-=-=-=-=-=-=-=-=-= 홀짝 게임=-=-=-=-=-=-=-=-=-=-</h1></div>

	<div align = "center"><h2>컴퓨터가 가진 동전은 홀수일까요, 짝수일까요? 아래 이미지를 클릭하여 선택해 보세요.</h2></div>

	<form action = "HomeController" method = "post">
	<div align = "center" >
	<button name = "ODD">
	<img src = "oddImage_.jpg" width = "400" height = "400">
	<br>홀수
	</button>
	
	<button name = "EVEN">
	<img src = "evenImage.jpg" width = "400" height = "400">
	<br>짝수
	</button>
	 </div>
	
	 <p>
	 
	 <%OddEvenManager OEM = OddEvenManager.getInstance();
	 	if(OEM.isGameOn()){%>
		<div align = "center">
		컴퓨터가 뽑은 동전의 개수 : ${COMSEL} 개 <br>
		당신의 선택 : ${MYSEL}  <br>
		결과 : ${RESULT} <br>
		전적 : ${PLAYCOUNT} 전 ${WINCOUNT} 승 ${LOSECOUNT} 패
		승률 : ${WINRATESTR}%
	<p>
		
		 <button name ="RESET"> 전적 리셋 </button>
		</div>
	 <%
	 	}
	 %>
	 
	  </form>

</body>
</html>