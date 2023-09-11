<%@page import="com.inchel.Sep112.main.RSP"%>
<%@page import="com.inchel.Sep112.main.HomeController"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1 align = "center">★☆★☆★☆じゃんけんーぽい！！ゲーム☆★☆★☆★</h1> <p>

<h2 align = "center">じゃん、けん、ぽんのどっちか1つを選んでください！</h2>

<form action = "HomeController" method = "post">

<div align = "center">
	<button name = "SCISSORS">
	 <img src = "Scissors.png" width ="200" height = "200">
	 <br> ジャン 
	 </button>
	 
	 <button name = "ROCK">
	 <img src = "Rock.png" width = "200" height = "200">
	 <br> ケン
	 </button>
	 
	 <button name = "PAPER">
	 <img src = "Paper.png" width = "200" height = "200">
	 <br> ポン
	 </button>
</div>

	 <p><p><p>
	 
	 <div align = "center">
	 
	 <h1 align = "center"> 結果 </h1>
	 
	 <%RSP rsp = RSP.getInstance();%>
	 
	 あなたが出したもの : <%=request.getAttribute("MYSELSTR") %> <br>
	 相手がだしたもの : <%=request.getAttribute("COMSELSTR") %> <br>
	 
	 <br> <img src = "<%=request.getAttribute("MYFILESTRING") %>" width = "300" height = "300"></img> 
	 VS 
	 <img src = "<%=request.getAttribute("COMFILESTRING") %>" width = "300" height = "300"></img>
	 <p>
	 勝負結果 : <%=request.getAttribute("RESULT") %> <br>
	 
	 勝った回数 : <%=rsp.getWinCount()%> <br>
	 負けた回数 : <%=rsp.getLoseCount()%> <br>
	 
	 <button name = "RESET"> 戦績初期化 </button>
	 
	 </div> 
	 </form>

</body>
</html>