<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 		<table id="signupTbl">
		 <form action="MemberInfoController" method="post" enctype="multipart/form-data"
	 		name="updateForm" onsubmit="return updateCheck();">
 			<tr>
 				<td>
 					<input value="${sessionScope.loginMember.m_id }"
 					name="m_id" placeholder="ID" autofocus="autofocus"
 					autocomplete="off" maxlength="10">
 				</td>
 			</tr>
 			<tr>
 				<td>
 					<input value="${sessionScope.loginMember.m_pw }"
 					name="m_pw" placeholder="PW" type="password"
 					autocomplete="off" maxlength="12">
 				</td>
 			</tr>
 			<tr>
 				<td>
 					<input value="${sessionScope.loginMember.m_pw }" 
 					name="m_pwchk" placeholder="PW Check" type="password"
 					autocomplete="off" maxlength="12">
 				</td>
 			</tr>
 			<tr>
 				<td>
 					<input value="${sessionScope.loginMember.m_name }"
 					name="m_name" placeholder="Name"
 					autocomplete="off" maxlength="10">
 				</td>
 			</tr>
 			<tr>
 				<td>
 					<input value="${sessionScope.loginMember.m_phone }"
 					name="m_phone" placeholder="Phone Number"
 					autocomplete="off" maxlength="11">
 				</td>
 			</tr>
 			<tr>
 				<td>
					생년월일<br>
					<select name="m_y">
						<option>
							<fmt:formatDate 
							value="${sessionScope.loginMember.m_birthday }" pattern="yyyy"/>
						</option>
						<c:forEach var="y" begin="${cy - 100 }" end="${cy }" step="1">
							<option>${y }</option>
						</c:forEach>
					</select>&nbsp;년&nbsp;&nbsp;
					<select name="m_m">
						<option>
							<fmt:formatDate 
							value="${sessionScope.loginMember.m_birthday }" pattern="M"/>
						</option>
						<c:forEach var="m" begin="1" end="12">
							<option>${m }</option>
						</c:forEach>
					</select>&nbsp;월&nbsp;&nbsp;
					<select name="m_d">
						<option>
							<fmt:formatDate 
							value="${sessionScope.loginMember.m_birthday }" pattern="d"/>
						</option>
						<c:forEach var="d" begin="1" end="31">
							<option>${d }</option>
						</c:forEach>
					</select>&nbsp;일&nbsp;&nbsp;
 				</td>
 			</tr>
 			<tr>
 				<td>
 					사진<br>
 					<img src="img/${sessionScope.loginMember.m_photo }" id="memberUpdatePhoto"><br>
 					<input type="file" name="m_photo"><!-- input file : 읽기 전용이라 기본값 X -->
 				</td>
 			</tr>
 			<tr>
 				<td align="center">
 					<button>정보수정</button>
	 	</form>
 					<button onclick="bye();">회원탈퇴</button>
 				</td>
 			</tr>
 		</table>
</body>
</html>













