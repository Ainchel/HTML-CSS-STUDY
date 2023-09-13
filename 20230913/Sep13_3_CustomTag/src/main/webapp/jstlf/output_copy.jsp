<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <!--  fmt : 문자열 / 숫자 / 날짜 형태를 포맷팅 -->
  <fmt:formatNumber value="${a }" type="number" /> <!-- 숫자 세 자리 콤마 -->
  <hr>
  <fmt:formatNumber value="${a }" type="currency" currencySymbol="$" /> <!-- 화폐 원 표시 --> 
  <hr>
  <fmt:formatNumber value="${b }" type="percent" /> <!--퍼센트(소수점 반올림) -->
  <hr>	
  <fmt:formatNumber value="${c }" pattern="#.00" /> <!--소수점 둘째까지 반올림) -->
  <hr>
  
  <!-- 
  		Date 속성
  		:type = "date/time/both"
  		1.date
  		  dateStyle = "short / long"
  		  
  		2.time
  		  timeStyle = "short / long"
  		  
  		3.both
  		  dateStyle = "short / long"
  		  timeStyle = "short / long"
  		      
   -->
  
  <fmt:formatDate value="${d }" type="both" dateStyle="long" timeStyle="short"/>
  <!-- 패턴 -->
  <fmt:formatDate value="${d }" pattern="yyyy-MM-dd E a hh"/> <br>

  
</body>
</html>