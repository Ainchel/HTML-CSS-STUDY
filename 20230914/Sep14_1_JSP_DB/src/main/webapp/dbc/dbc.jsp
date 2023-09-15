<%@page import="com.inchel.db.manager.InchelDBManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		// 기존 : DriverManager.getConnection()을 실행하면, 관련 작업을 그때 전부 해서 Connection을 만들었다
		// 커넥션 풀 : 미리 Connection을 잔뜩 만들어두고, 요청하면 그거 주면 된다. 빠름.
		
		// 설정 - 각 프로젝트의 context.xml에서 한다.
		// Servers - context.xml을 건들면, 워크스페이스 내의 모든 프로젝트에 전부 적용된다.
		// 프로젝트가 다르면?? DB서버가 다를 경우가 있으므로, Servers에서는 건드리지 말자.
				
		// 그러므로, 각 프로젝트에 context.xml을 넣어서 관리하자.
		
		String result = "실패";
	
		Connection con = null;
		try{
			con = InchelDBManager.connect("inchelPool");
			result = "성공";
		} catch(Exception e){
			e.printStackTrace();
		} 
		
		InchelDBManager.close(con, null, null);
		
	%>
	
		<h1> DB연결 </h1>
		<h1> <%=result %> </H1>
</body>
</html>