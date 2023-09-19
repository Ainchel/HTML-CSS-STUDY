
function ValidCheck(){
	
	let form = document.getElementById("FORM");
	let signInID = form.elements["signinid"].value;
	let signInPW = form.elements["signinpw"].value;
	let signInName = form.elements["signinname"].value;
	let signInPhoneNumber = form.elements["signinphonenumber"].value;
	let signInFileName = form.elements["uploadfile"].value;
	let engRegex = /^[a-zA-Z]*$/;
	let korRegex = /^[가-힣]*$/;
	let idRegex = /^[a-zA-Z1-9]*$/;
	let numberRegex = /^[0-9]*$/;
	
	if(!signInID){
		alert("ID를 입력하지 않으셨습니다. 다시 입력해 주세요.");
		return false;
	}
	
	if(!signInPW){
		alert("비밀번호를 입력하지 않으셨습니다. 다시 입력해 주세요.");
		return false;
	}
	
	if(!signInName){
		alert("이름을 입력하지 않으셨습니다. 다시 입력해 주세요.");
		return false;
	}
	
	if(!signInPhoneNumber){
		alert("전화번호를 입력하지 않으셨습니다. 다시 입력해 주세요.");
		return false;
	}
	
	if(!signInFileName){
		alert("파일을 첨부하지 않으셨습니다. 파일을 첨부해 주세요.");
		return false;
	}
	
	if(signInID.length < 2){
		alert("ID는 2~12글자로 작성하셔야 합니다.");
		return false;
	}
	
	if(signInPW.length < 4){
		alert("비밀번호는 4~12글자로 작성하셔야 합니다.");
		return false;
	}
	
	if(signInName.length < 2){
		alert("이름은 2~12글자로 작성하셔야 합니다.");
		return false;
	}
	
	if(signInPhoneNumber.length != 11){
		alert("전화번호는 -제외 11글자로 작성하셔야 합니다.");
		return false;
	}
	
	if(!idRegex.test(signInID)){
		alert("ID는 영어 및 숫자로만 작성되어야 합니다.");
		return false;
	}
	
	if(korRegex.test(signInName) == false && engRegex.test(signInName) == false){
		alert("이름은 한글로만, 또는 영어로만 입력되어야 합니다.");
		return false;
	}
	
	if(!numberRegex.test(signInPhoneNumber)){
		alert("전화번호는 숫자로만 작성되어야 합니다.");
		return false;
	}
	
	if(signInPhoneNumber[0] != "0" || signInPhoneNumber[1] != "1" || signInPhoneNumber[2] != "0"){
		alert("전화번호 앞 세자리는 반드시 010이어야 합니다.");
		return false;
	}
	
	return true;
}