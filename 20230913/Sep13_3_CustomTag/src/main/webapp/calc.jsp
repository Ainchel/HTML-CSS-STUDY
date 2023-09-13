<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	여기는 calc<p>
	
	<form action = "CalcController" > <!--name = "calcForm" onsubmit = "return calcCheck();"  -->
		x : <input placeholder = "x" autofocus="autofocus"
				   autocomplete="off" name = "x"> <br>
		y : <input placeholder = "x" autocomplete ="off" name = "y"> <br>
		
		<button> 계산 </button>
	
	</form>

</body>
</html>