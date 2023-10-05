<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type = "text.css">
	.lengthconvert{
	color: red;
	}

	.widthconvert{
	color: green;
	}

	.temperatureconvert{
	color: blue;
	}

	.speedconvert{
	color: pink;
	}

</style>

</head>
<body>

		<!--h1 태그에 변환 결과라고 글자로 표현  -->
		<!--변환 전 입력한 값과 단위, 변환 후의 값과 단위를 페이지에 각각 출력  -->
		<!--h1 태그의 색상을, 어느 단위 변환을 선택했는지에 따라 다르게 적용시킨다. -->
		<!--길이 단위 변환 : 빨강  -->
		<!--넓이 단위 변환 : 초록  -->
		<!--온도 단위 변환 : 파랑  -->
		<!--속도 단위 변환 : 핑크  -->
		
		<h1 class = "${c }">여기는 output.jsp입니다.</h1>
		
		내가 선택한 변환 : ${c }<br><br>
		결과값 : ${r }

</body>
</html>