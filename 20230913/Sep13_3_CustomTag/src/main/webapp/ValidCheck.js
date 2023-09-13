function calcCheck(){
	
	let x = document.calcForm.x;
	let y = document.calcform.y;
	
	if (!x || isNaN(x)
		|| !y || isNaN(y)){
			alert("잘못된 값이 들어갔습니다.");
			x = "";
			y = "";
			
		}
	
	
}