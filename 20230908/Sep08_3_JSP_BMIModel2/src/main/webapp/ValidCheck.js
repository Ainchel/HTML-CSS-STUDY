//데이터에 문제가 있을 때 true로 반환시키고, 없다면 false로 반환시키는 유형이라면?

// 1)<input> 으로 받아오는 값에 아무 값도 넣지 않았다면 true, 뭔가 넣었다면 false로 만들기.

function isEmpty(input){
	return(!input.value); // input에 들어온 값이 없다면(false일 때, !이므로 true) true 처리.
}

//<input> 으로 받아오는 값에 한글이나 특수문자 등이 적혀있다면 true(문제있음), 문제없다면 false 반환

function containsAnother(input){

	//아래 문자열의 내용물이 들어가있지 않다면 true(문제있음) 반환시킬 예정.
	let pass = "1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ@_.";

	let iv = input.value;
	for(let i = 0; i < iv.length; i++){
		if(pass.indexOf(iv[i]) == -1){ //문자열을 검사해서, 위 pass에 해당하는 문자 내용이 없다면(-1이라면)
			return pass;
		}
	}
}

//<input> 으로 받아온 글자의 수를 넣었을 때, 글자수보다 적으면 true, 이상이면 false
function atLeastLetter(input, len){
	return (input.value.length < len);
}

//<input>으로 두 값을 넣었을 때, 두 값이 다르면 true로.

function NotEqualPW(input1, input2){
	return (input1.value !== input2.value);
}

//<input>으로 입력받은 값에, 지정한 문자열세트가 없다면 true로.
function notContain(input, passSet){
	let iv = input.value;
		for(let i = 0; i < passSet.length; i++){
			if(iv.indexOf(passSet[i]) != -1){
			return true;
			}
		}
}

//<input>으로 입력받은 값에, 숫자가 아닌 값이 있으면 true로.
function isNotNumber(input){
	return isNaN(input.value);
}

//<input>으로 입력받은 값에, 확장자명이 없다면 true로.
function isNotType(input, type){ // 확장자들 리스트 : gif, png, jpg, jpeg, ........
	alert("in isNotType");
	type = "." + type; //확장자명인 . 그냥 미리 붙여버리기.
	return (input.value.indexOf(type) == -1);
}