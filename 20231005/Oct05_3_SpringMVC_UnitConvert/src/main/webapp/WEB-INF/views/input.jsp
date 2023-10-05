<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 단위 변환 페이지 만들기. -->
	<!-- form 안에 숫자를 입력할 input을 하나 만든다. -->
	<!-- 그 후, select 태그를 통해 입력받은 숫자를 다양한 단위로 변환해본다. -->
	<!-- cm -> inch로, 제곱미터 -> 평으로, 섭씨 -> 화씨로, 시속마일 -> 시속km로 -->
	<!-- 4개 중 하나를 select로 고르고 버튼을 누르면 변환된 값으로 출력시켜준다. -->
	<!-- 버튼을 누르면 unit.convert URL을 통해  -->
	<!-- 결과는 output.jsp에서 출력 -->
	
	<form action = "unit.convert">
		숫자를 입력하세요 : <input name = "inputValue"> <br><br>
		변환할 단위를 선택하세요. <br> <br>
		<select name = "convertUnit">
			<!--길이 단위 변환 : 빨강  -->
			<!--넓이 단위 변환 : 초록  -->
			<!--온도 단위 변환 : 파랑  -->
			<!--속도 단위 변환 : 핑크  -->
			<option value = "lengthconvert"> 길이(cm -> inch)</option>
			<option value = "widthconvert"> 넓이(제곱미터 -> 평)</option>
			<option value = "temperatureconvert"> 온도(섭씨 -> 화씨)</option>
			<option value = "speedconvert"> 속도(시속마일 -> 시속km)</option>
		
		</select> <br>
		
		<button> 변환 </button>
	</form>
</body>
</html>