
function ValidCheck(){
	
	//location color taste price introduce
	let form = document.getElementById("FORM");
	let inputlocation = form.elements["inputlocation"].value;
	let inputcolor = form.elements["inputcolor"].value;
	let inputtaste = form.elements["inputtaste"].value;
	let inputprice = form.elements["inputprice"].value;
	let inputintroduce = form.elements["inputintroduce"].value;
	
	if(!inputlocation){
		alert("지역 값을 입력하지 않으셨습니다. 다시 입력해 주세요.");
		return false;
	} else if(!inputcolor){
		
	} else if(!inputtaste){
		
	} else if(!inputprice){
		
	} else if(!inputintroduce){
		
	}
	
	if(isNaN(userNum)){
		alert("숫자가 아닌 값을 입력하셨습니다. 세자리 숫자만 입력해 주세요.");
		return false;
	}
	
	if(userNum >= 1000){
		alert("숫자는 12 ~ 987까지의 값을 입력해주세요.");
		return false;
	}
	
	userNum = Number(userNum);
	
	let num100 = Math.floor(userNum / 100);
	userNum -= num100 * 100;
	let num10 = Math.floor(userNum / 10);
	userNum -= num10 * 10;
	let num1 = Math.floor(userNum);
	
	if(num1 == num10 || num1 == num100 || num10 == num100){
		alert("세자리 숫자는 겹치지 않아야 합니다.");
		return false;
	}
	
	return true;
}