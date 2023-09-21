function signupCheck() {
	let m_id = document.signupForm.m_id;
	let m_pw = document.signupForm.m_pw;
	let m_pwchk = document.signupForm.m_pwchk;
	let m_name = document.signupForm.m_name;
	let m_phone = document.signupForm.m_phone;
	let m_photo = document.signupForm.m_photo;
	
	if (isEmpty(m_id) || containsAnother(m_id)) {
		alert("Please Fill in ID Properly.");
		m_id.value = "";
		m_id.focus();
		return false;
	} else if (isEmpty(m_pw) || notEqualPw(m_pw, m_pwchk)) {
		alert("Please Fill in Password Properly.");
		m_pw.value = "";
		m_pwchk.value = "";
		m_pw.focus();
		return false;
	} else if(isEmpty(m_name)) {
		alert("Please Fill in Name Properly.");
		m_name.value = "";
		m_name.focus();
		return false;
	} else if (isEmpty(m_phone) || isNotNumber(m_phone)) {
		alert("Please Fill in Phone Number Properly.");
		m_phone.value = "";
		m_phone.focus();
		return false;
	} else if (isEmpty(m_photo) || (isNotType(m_photo, "png")
		&& isNotType(m_photo, "gif") && isNotType(m_photo, "jpg")
		&& isNotType(m_photo, "bmp") && isNotType(m_photo, "jpeg"))) {
		alert("Please Fill in Photo Properly.");
		m_photo.value = "";
		m_photo.focus();
		return false;
	}
	return true;
}


function loginCheck() {
	let m_id = document.loginForm.m_id;
	let m_pw = document.loginForm.m_pw;
	
	if (isEmpty(m_id) || containsAnother(m_id)) {
		alert("Please Fill in ID Properly.");
		m_id.value = "";
		m_id.focus();
		return false;
	} else if (isEmpty(m_pw) || notEqualPw(m_pw, m_pwchk)) {
		alert("Please Fill in Password Properly.");
		m_pw.value = "";
		m_pwchk.value = "";
		m_pw.focus();
		return false;
	}
	return true;
}

function updateCheck() {
	let m_id = document.signupForm.m_id;
	let m_pw = document.signupForm.m_pw;
	let m_pwchk = document.signupForm.m_pwchk;
	let m_name = document.signupForm.m_name;
	let m_phone = document.signupForm.m_phone;
	let m_photo = document.signupForm.m_photo;
	
	if (isEmpty(m_id) || containsAnother(m_id)) {
		alert("Please Fill in ID Properly.");
		m_id.value = "";
		m_id.focus();
		return false;
	} else if (isEmpty(m_pw) || notEqualPw(m_pw, m_pwchk)) {
		alert("Please Fill in Password Properly.");
		m_pw.value = "";
		m_pwchk.value = "";
		m_pw.focus();
		return false;
	} else if(isEmpty(m_name)) {
		alert("Please Fill in Name Properly.");
		m_name.value = "";
		m_name.focus();
		return false;
	} else if (isEmpty(m_phone) || isNotNumber(m_phone)) {
		alert("Please Fill in Phone Number Properly.");
		m_phone.value = "";
		m_phone.focus();
		return false;
	} 
	// 사진 같은 경우에는 DAO에서 처리할거라 유효성검사 안할 것!
	return true;	
}









