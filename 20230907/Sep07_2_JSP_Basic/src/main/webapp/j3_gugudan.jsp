<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
	table {
	float: left;
	margin-right: 10px;
	}
</style>

</head>
<body>

	<!-- 페이지를 실행하면, 2단부터 9단까지 각 테이블에 출력되게끔 만들어보기.-->

	<!--
	for(int i = 2; i <= 9; i++{
		System.out.println(i + "단");
		for(int j = 1; j <= 9; j++){
		System.out.println(i + "*" j + "=" i * j);
		}
	}
	-->
<table border = "1">
			
	<%
		for(int i = 2; i <= 9; i++){
	%>
	<tr>
		
		<th><%=i %> 단</th>
			
	</tr>
			<%
				for(int j = 1; j <= 9; j++){
			%>
			<tr>
				<td> <%=i %> * <%=j %> = <%=i * j %></td>
			</tr>
			<%
				} // j의 for문 닫기.
			%>
		
		<%
			}
		%>
</table>
</body>
</html>