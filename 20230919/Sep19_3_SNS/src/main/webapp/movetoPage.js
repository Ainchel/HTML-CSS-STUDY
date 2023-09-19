function movetoSignin(){
	location.href= "signInController";
}

function deleteApple(loc){
	confirm(`${loc} 지역의 사과 데이터를 삭제하시겠습니까?`)
	location.href= "AppleDeleteController?deletelocation=" + encodeURI(loc);
}