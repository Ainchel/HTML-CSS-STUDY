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
	//alert('jquery test');
	
	//AJAX (Asynchronous Javascript And XML)
	// : 자바스크립트(중에서도 jQuery)를 통해서 서버에 데이터를 요청하는 것을 말한다.
	
	$("#btn").click(function(){
		//AJAX 진행
		$.ajax({ // 이거 함수 아니고 객체이다!
			url: "fruit.getXML", //url 속성에, value값으로 실제 이동할 URL을 적는다.(Controller에 설정한 요청주소)
			success: function(asd){ // 요청에 성공하면, 여기 적은 함수를 실행시킬 것이다.
				alert(asd); //이 실행의 결과물은 xml 문서라는 것이 확인된다. 즉 이걸 가져왔다는 것.
				
				//DOM 객체를 하나하나 불러올 때마다, 아래 콜백함수를 실행시킨다.
				$(asd).find("fruit").each(function(i, f){
					alert(i + ") " + f);
				//이 중에서, 우리가 원하는 데이터를 하나만 뽑아보자.
				let f_name = $(f).find("f_name").text(); // 각 결과물 f객체 내의 "f_name" 값을 가져온다.
				let f_price = $(f).find("f_price").text();
				alert(f_name + "] " + f_price);
				
				}); //.each end
				
			} //success: end
			
		}); //ajax end
		
	});
	
	// fruit.getXML에 요청해서, 나오는 모든 데이터를 가지고 테이블에 채워라.
	
	$.ajax({
		url: "fruit.getXML",
		success: function(result){
				//find함수에서 "" 따옴표 빼먹지 말기...
			$(result).find("fruit").each(function(i, f){
			
				let f_name = $(f).find("f_name").text();
				let f_price = $(f).find("f_price").text();
				
				let newtr = $("<tr></tr>");
				//아래 HTML에 있는 id 속성값 가져올 떄, # 빼먹지 말기...
				$("#fruitTbl").append(newtr);
				
				let nameDOM = $("<td></td>").text(f_name);
				let priceDOM = $("<td></td>").text(f_price);
				
				newtr.append(nameDOM, priceDOM);
				
			});
		}
	});
	
	$("#searchbtn").click(function(){
		
		//alert("searchbtn 진입");
		
		let frVal = $("#searchinput").val();
		//alert(frVal);
		
		$.ajax({
			
			//url: "fruit.searchXML?f_price" = frVal, // 요청 주소에 파라미터 걸어버리면 됨. 이걸 왜 몰랐찌???
			url: "fruit.searchXML",
			data:{f_price : frVal},
			success:function(result){
			//	alert(result);
				$("#fruitTbl").empty();
				$(result).find("fruit").each(function(i, f){
					let f_name = $(f).find("f_name").text();
					let f_price = $(f).find("f_price").text();
					
					let nameTd = $("<td></td>").text(f_name);
					let priceTd = $("<td></td>").text(f_price);
					
					let tr = $("<tr></tr>").append(nameTd, priceTd);
					
					$("#fruitTbl").append(tr);
					
				});
			}
		
		});
		
	});
	
	$("#searchinput").keyup(function(e){ // input 활성화 상태에서 키를 뗐을 때
		
		if(e.keyCode == 13){ // 그 뗀 키가 ENTER 키라면
			$("#searchbtn").trigger("click"); // click을 한 것과 같은 trigger를 발동시켜라.
											  // click을 했다면? 위에 onclick이 발동될 것이다.
		}
		
	});
	
	//input에 숫자를 입력받아서 검색 버튼을 누르면
	//입력받은 숫자 이하의 가격인 과일들의 이름, 가격 데이터를 테이블에 올려주기.
	
});

</script>

</head>
<body>
	<table id = "fruitTbl" border = "1"></table>
	<input id = "searchinput"> <button id = "searchbtn" >검색</button>
	
	<hr>
	<button id = "btn">버튼</button>
</body>
</html>