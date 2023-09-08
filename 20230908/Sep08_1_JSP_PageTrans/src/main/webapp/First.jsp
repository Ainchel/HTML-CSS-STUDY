<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type = "text/javascript">

	function gogo(){
		location.href = "Second.jsp?jsX=100&jsY=200";
	}

</script>

</head>
<body>

	<!--
	
	First.jsp에서 두 숫자를 입력했을 때
	Second.jsp에서 각 숫자들을 출력하기.
	
	JSP -> JSP로 데이터를 넘기는 것. 3가지 방법이 있는데, 전부 다 시도해보기.
	
	1) a 태그 사용하기.
	
	-->
	
	<!-- form을 사용한 전송 방법 : GET과 POST 모두 가능 -->
	<form action = "Second.jsp">
	첫 번째 숫자 입력 <input name = "formX">  <p>
	두 번째 숫자 입력 <input name = "formY">  <p>
	
	<button> 전송 </button>
	</form>
	
	<p><p>
	
	<!-- a 태그를 이용한 전송 방법 -->
	
	<hr>
		<a href = "Second.jsp?ahrefX=15&ahrefY=20">&lt;a&gt; 태그로 두 변수로 GET 방식 요청하기
		</a>
	<hr>
	
	<!-- JS로 GET 방식 요청하기-->
	<hr>
	<div onclick = "gogo();"> JavaScript로 GET 방식 요청하기.</div>
	<hr>
	<!-- JavaScript의 location을 이용한 전송 방법 -->

</body>
</html>