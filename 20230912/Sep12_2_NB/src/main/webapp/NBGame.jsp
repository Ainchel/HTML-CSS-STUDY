<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src = "InputValidCheck.js"></script>

</head>
<body>
	
	<div align = "center"><h1>○●○●○●○●○●数字当てゲーム●○●○●○●○●○</h1></div><p>
	<div align = "center"><h2>コンピューターが考えた、12~987の数字を当ててみてください。</h2></div>

	<div align = "center">
	
	<form id = "FORM" action = "HomeController" method = "post" onsubmit="return ValidCheck()">
	 正解は？ <br>
	 <input name = "USERNUM"> <br>
	 <button> 入力した数字で確認！</button>
	 
	 <p>
	 入力した数字 : ${USERNUM}<br>
	 入力した数字で確認した、Strikeの数 : ${STRIKECOUNT} <br>
	 入力した数字で確認した、 Ballの数 : ${BALLCOUNT} <br>
	 結果 : ${RESULT}
	 
	 <p>
	</form>
	
	<form action = "HomeController" method = "post">
		 <button name = "RESET"> コンピューターの考えた数字を変える！ </button>
	</form>
	
	</div>

	<div>
	
	
	
	</div>

</body>
</html>