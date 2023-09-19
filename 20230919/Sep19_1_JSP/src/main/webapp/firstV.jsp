<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type = "text/javascript">

function gogo(){
	location.href = "SecondC?a=20&b=200";
}

</script>

</head>
<body>

	<%
	 // 사용자가 어떤 액션을 했을 때, 결과를 보여주는 View.
	 // 이런 액션을 했을 때, 이동하는 것을 "요청" 이라고 한다.
	 // 요청 방법 1) <a>태그를 사용 : 이 태그가 적용된 부분을 눌러 GET 방식의 요청하기.
	 // 요청 방법 2) js를 사용 : 이벤트를 추가하여 GET방식으로 요청. JS에서 form을 만들면 POST방식도 가능하다.
	 // 요청 방법 3) html에서의 form태그 + button태그 사용 : 버튼을 클릭했을 GET/POST방식으로 요청.
	
	 // 흐름 정리 : FirstC를 실행한다.
	 // FirstC에서 firstV로 포워딩(.forward~~~메소드)
	 // firstV에서 a와 b값을 가지고(아래 버튼들 참조) SecondC로 요청을 넣는다.
	%>

	<h1> First </h1>
	d : ${sessionScope.d } <br>
	e : ${cookie.e.value } <br>
	
	<a href = "SecondC?a=10&b=20"> SecondC로 이동 </a>
	<hr>
	<div onclick = "gogogo();">SecondC로!! </div>
	<hr>
	<form action = "SecondC">
	<input name = "a"> <br>
	<input name = "b"> <br>
	<button> SecondC로 </button>
	
	</form>
	
</body>
</html>