<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import="javax.servlet.http.HttpServletRequest"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type = "text/javascript" src = "validcheck.js"> </script>

</head>
<body>
	  회원 가입<p>
		
	  <form id ="FORM" action = "signInResultController" onsubmit = "return ValidCheck()" enctype="multipart/form-data">
	  <input name = "signinid" placeholder = "ID(영어+숫자 혼합 2~12자)" maxlength = 12> <p>
	  <input name = "signinpw" placeholder = "비밀번호(4~12자)" maxlength = 12> <p>
	  <input name = "signinname" placeholder = "이름(한글or영어, 2~12자)" maxlength = 12> <p>
	  <input name = "signinphonenumber" placeholder = "전화번호(-없이11자)" maxlength = 11> <p>
  
  	  <%int year = Integer.parseInt((String)(request.getAttribute("cy")));%>
  	
  	  태어난 해
	  <select name = "birthyear" >
	  <%for(int i = 0; i < 100; i++){%>
	  <option value =<%=year-i%>><%=year-i%></option>
	  <% } %>
	  </select> <p>
	  
	  태어난 달
	  <select name = "birthmonth"> 
	  <%for(int i = 1; i <= 12; i++ ){%>
	  <option value = <%=i %>> <%=i %> </option>
	  <% } %>
	  </select> <p>
	  
	  태어난 일
	  <select name = "birthday"> 
	  <%for(int i = 1; i <= 31; i++){%>
	  <option value = <%=i %>> <%=i %> </option>
	  <% } %>
	  </select>  <p>
	  
	  사진 첨부<br>
	  <input type = "file" name = "uploadfile"> <p>
	  
	  <button> 회원 가입 </button>
	  
	  </form>
	  
</body>
</html>