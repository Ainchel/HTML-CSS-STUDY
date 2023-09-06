function bmiCheck(){
	
	//<div>이름 <input name = "NAME" autofocus = "autofocus"></div> <p>
	//<div>키(cm) <input name = "HEIGHT"></div> <p>
	//<div>몸무게(kg) <input name= "WEIGHT"></div> <p>
	//<div>사진 <input type ="file" name = "FILENAME"></div> <p>
	
	let name = document.form.NAME;
	let height = document.form.HEIGHT;
	let weight = document.form.WEIGHT;
	let fileName = document.form.FILENAME;
	
	//alert(name);
	//alert(height);
	//alert(weight);
	//alert(fileName.value);
	//alert(NUMBER(height));
	
	let characters = " `~1!2@3#4$5%6^7&8*9(0)-_=+\|/*,<.>/?";
	
	if(!name.value){
		alert("이름 란을 입력하지 않았습니다.");
		name.value = "";
		return false;
	}
	
	//" `~1!2@3#4$5%6^7&8*9(0)-_=+\|/*,<.>/?";
	for(let i = 0; i < characters.length; i++){
		if(name.value.indexOf(characters[i]) != -1){
			alert("이름에 숫자 / 특수문자를 넣을 수 없습니다.");
			return false;
		}
	}
	
	if(!height.value){
		alert("키 란을 입력하지 않았습니다.");
		height.value = "";
		return false;
	} else if(height.value <= 0){
		alert("키는 0cm보다 큰 값이어야 합니다.");
		height.value = "";
		return false;
	} else if(isNotNumber(height)){
		alert("키에 숫자가 아닌 값을 입력했습니다.");
		return false;
	}
	
	if(isEmpty(weight)){
		alert("몸무게 란을 입력하지 않았습니다.");
		return false;
	} else if(weight.value <= 0){
		alert("몸무게는 0보다 큰 값이어야 합니다.");
		weight.value = "";
		return false;
	} else if(isNotNumber(weight)){
		alert("몸무게에 숫자가 아닌 값을 입력했습니다.");
		weight.value = "";
		return false;
	}
	
	if(isEmpty(fileName)){
		alert("사진 파일을 첨부하지 않으셨습니다.");
		return false;
	} 
	
	if((isNotType(fileName, "png") && isNotType(fileName, "gif")) &&
			  (isNotType(fileName, "jpg") && isNotType(fileName, "bmp"))){
		alert("지원하지 않는 그림 파일 형식입니다.");
		return false;
	}
	
	alert('asdf');
	
	return true;
}