<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type = "text/javascript" src = "jQuery.js"></script>
<script>

$(function(){
	
	alert("jQuery진입");
	
	$("button").click(function(){
		
		alert("버튼입력 진입");
		
		let iVal = $("input").val();
		
		//$.getJSON을 이용해 JSON 데이터 받아오기.
		//근데 $.getJSON의 기능이 딸려서, 일부 요청 헤더의 처리를 못한다...
		
		$.ajax({
			url : "https://dapi.kakao.com/v3/search/book",
				data: {query : iVal},
				//아래 beforeSend 속성은, 요청을 보내기 전에 콜백함수를 작동시킨다.
				//beforeSend쪽 내용이 요청헤더를 보내는 쪽이다.
				beforeSend: function(req){
					req.setRequestHeader("Authorization", "KakaoAK 0ad31319314db7770c095cf2a6bcbd63");
				},
				success:function(bookJSON){
					alert(JSON.stringify(bookJSON));
					//이미지나 사진 / 책 제목 - 출판사 / 정가 / 판매가
					$("table").empty();
					
					$.each(bookJSON.documents, function(i, b){
						let img = $("<img>").attr("src", b.thumbnail);
						let td1 = $("<td></td>").append(img);
						let td2 = $("<td></td>").text(b.title + "-" + b.publisher);
						let td3 = $("<td></td>").text(b.price + "-" + "원");
						let td4 = $("<td></td>").text(b.sale_price + "-" + "원");
						
						let tr = $("<tr></tr>").append(td1, td2, td3, td4);
						$("table").append(tr);
						
					})
				}
		});
	});
});

</script>

</head>
<body>

	<input> <button> 찾기 </button>
	<hr>
	<table border = "1"></table>
</body>
</html>