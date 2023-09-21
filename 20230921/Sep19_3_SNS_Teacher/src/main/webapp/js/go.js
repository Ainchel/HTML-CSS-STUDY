function signupGo() {
	location.href = "SignupController";
}

function logout() {
	let really = confirm("리얼루다가 ?");
	if (really) {
		location.href = "LoginController";
	}
}

function memberInfoGo() {
	location.href= "MemberInfoController";
}

function bye(){
	let t = prompt("정말로 탈퇴하시겠습니까? Y/N");
	if(t == "Y"){
		location.href= "MemberDeleteController";
	}
}

