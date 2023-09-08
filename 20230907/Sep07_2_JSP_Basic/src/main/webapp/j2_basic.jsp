<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%--
		랜덤한 숫자(1~100 사이 정수)를 넣었을 때, 짝인지 홀인지 알려주는 기능 만들기.
		뽑은 숫자와 홀짝 여부를 웹페이지에 출력하기.
		나는 그냥 풀었고, 선생님 풀이는 메소드를 만드는 걸로 하셨다.
	 --%>

	<%!
		public String getOE(int x){
		return (x % 2 == 0) ? "짝수" : "홀수";
	}
	%>
	

	<%
		int randomNum = (int)(Math.random() * 100) + 1;
		String result = "";
		
		if(randomNum % 2 == 1){
		result = "홀수";
		} else {
		result = "짝수";
		}
		
		Random r = new Random();
		int x = r.nextInt(100) + 1;
	%>
	
	<%-- 
	<!--  <h1> 랜덤 숫자 1 ~ 100 뽑기!(근데 자동 생성되는) </h1>
	
	<h2> 뽑은 숫자 : <%=randomNum %></h2>
	
	<h3> 뽑은 숫자는 <%=result%>입니다!!</h3>-->
	--%>
	
	<h1> 뽑은 숫자 : <%=x %></h1>
	<h1> 홀짝 여부 : <%=getOE(x) %></h1>

</body>
</html>