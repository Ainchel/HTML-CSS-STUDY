<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<marquee><%=1230 * 877%></marquee>

	HTML : 웹페이지의 제작이 가능하다.
	그런데, HTML만으로는 디자인도 부족하고(못생기고), 이벤트도 좀 부족하다(정적이다).
	
	그러니까 여태 해왔던 WEB 언어들로 역할을 나눠본다면,
	1)HTML : 웹페이지의 뼈대를 만듦.
	2)CSS : 웹페에지의 디자인을 담당.
	3)JavaScript : 부족한 이벤트를 처리.
	
	위 3개로 어느정도 처리가 됐지만, 추가적으로 부족한 게 더 있다.
	1) 파라미터 읽기, 계산, 조건문, 반복문 처리 기능이 부실함.
	1-1) 그래서 나온 것이 Servlet. 클라이언트가 요청하면, HTML과 CSS와 JavaScript를 만들어내서 응답해주는 프로그램.
	1-2) 나온 건 좋은데, 너무 어렵고 복잡하고 작업이 불편했다.
	
	위 문제점을 해결하기 위해 나온 것이 JSP(Java Servlet/Server Page)이다.
	JSP의 작업 형태는 HTML + CSS + JavaScript인데, HTML 안에서 똑같이 사용할 수 있다.
	그리고, 프로그래밍적인 코드가 필요할 때마다 Java 코드를 추가할 수 있다.
	실제 작동은, Tomcat이 우리의 HTML을 Servlet으로 바꿔서 실행해주는 것이다.
	
	그리하여, Servlet과 JSP를 각각 간단히 요약하자면 :
	Servlet : Java 코드 내에서 HTML을 구현하는 것.
	JSP : HTML 코드 내에서 Java를 구현하는 것이다.
	
	<%-- JSP 문법 소개.
	 	1. 스크립트릿(Scriptlet) : JSP에서 Java 코드를 실행할 때 사용하는 블록이다.
		일반적으로 "<% %>" 표시를 쓴다. ex) <%System.out.println("Hello JSP");%>
		
		2. 지시자 : 특별한 지시를 내릴 때 사용하는 블록.
		그 특별한 지시들이란?? page / include / taglib /... 같은 애들을 쓴다.
		<%@ %>를 표시로 사용한다. JSP 만들면 최상단에 뜨는 JAVA문구가 이 표시로 쓰여있다.
		
		3. 표현식 : 어떤 값을 (웹페이지 상에) 출력 결과로 포함하고 싶을때 사용하는 블록이다.
		<%= %> 표시로 사용한다. 진짜 특정 값이나, 변수 이름 등이 올 수 있다.
		Servlet에서의 out.print()와 같은 기능이라고 생각하자.
		숫자, 문자열, 변수 등의 값을 사용 가능하나, 멤버변수는 아래 선언문에서 써야 한다.
		예시) 위의 <%= 1230 * 877%>했던 애.
		
		4. 선언문 : 표현식에서 사용할 Java의 메소드를 작성할 때 사용하는 블록.
		<%! %> 표시로 사용한다.
		Java의 method 선언과 동일하다. (이름, 규칙 등등)

		5. 주석 : 기존 주석과 기능은 같다.
		<%-- \-\-> 형식으로 사용한다. 여기서 \-\-는 --이지만 주석이 닫혀버려서 임시로 적었다.
	--%> 
		

</body>
</html>