<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type = "text/javascript" src = "resources/jQuery.js"></script>
<script>

$(function(){
	alert("index2.jsp 실행");
	
	//.ajax 써서 json 데이터 받아오기. 방식은 어제 xml때와 비슷하다.
	
	/* $.ajax({
		url: "error.getJSON",
		success: function(zxc){
			//alert(zxc); // 쿼리문 성공했을 시, json형식의 오브젝트를 결과값으로 받아옴.
			//JavaScript 객체는, 문자열 그대로 변환이 가능하다고 한다.
			alert(JSON.stringify(zxc)); // 위 오브젝트 타입을 String으로 바꿔서 출력
		}
	}) */
	
	//다른 방식의 ajax를 이용한 json 받아오기. 보다 간단한 방법
	//$.getJSON()이라는 기능을 활용. 파라미터가 2개 들어간다.
	//$.getJSON("요청주소?파라미터=값&...", 값을 받아오는 데 성공하면 작동시킬 콜백 함수)
	
	$.getJSON("error.getJSON", function(result){
		//alert(JSON.stringify(result));
		//let ar = result; // JSON 내 "error" 라는 이름의 객체(배열)을 받아옴.
		//alert(ar[0].e_where); // error 배열 내 0번 인덱스의 e_where 멤버인 "DAO" 출력.
		//alert(result);
		//jQuery의 반복문을 사용하여, JSON 내 데이터들을 아래 테이블에 붙여보자.
		 $.each(result.error, function(i, e){
			let newtr = $("<tr></tr>");
			$("#errorTbl").append(newtr);
			
			let newtd1 = $("<td></td>").text(e.e_what);
			let newtd2 = $("<td></td>").text(e.e_where);
			
			newtr.append(newtd1, newtd2);
		});
			
	});
			//버튼을 클릭했을 때, input에 입력한 내용이 e_what 값으로 테이블에 있으면 해당 데이터를 table에 넣기.	
	$("button").click(function(){
		let iVal = $("input").val();
		// alert(iVal);
	
		$.getJSON("error.searchJSON?e_what=" + iVal, function(zxc){
			// alert(zxc);
			$("table").empty();
			 $.each(zxc.error, function(i, e){
				 alert(e);
 					let newtr = $("<tr></tr>");
					$("#errorTbl").append(newtr);
					
					let newtd1 = $("<td></td>").text(e.e_what);
					let newtd2 = $("<td></td>").text(e.e_where);
					
					newtr.append(newtd1, newtd2);
 			});
	});
});
});
</script>

</head>
<body>
	<table border = "1" id = "errorTbl"></table>
	<hr>
	<input id = "searchinput" name = "e_what"> <button id = "searchbtn"> e_what 검색 </button>
</body>
</html>