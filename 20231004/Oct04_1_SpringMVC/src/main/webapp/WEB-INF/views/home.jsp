<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>
<!-- 홈페이지 실행 시 뜨는 화면은 여기 home.jsp 쪽이 나온다. 여기 읽어오는 방법은 이따가 설명 -->
<!-- JSP에서는, "http://IP:Port/ProjectName/FileName" 형식으로 표시됐다.  -->
<!-- 현재 Spring 환경에서는, "http://IP:Port/top-level package의 마지막(.의맨오른쪽)이름" 형식으로 표시된다. -->
<!-- 혹은, 임의로 지정할 수도 있다. -->

<!-- 만약 탑 레벨 패키지(top-level package)의 이름이 같으면, 프로젝트가 달라도 주소가 같아질 수 있으므로 주의하자. -->
<!-- 그러므로, 탑 레벨 패키지는 이름이 중복되지 않게 해야 한다. -->

<!-- 스프링 환경에서의 웹페이지 실행은, 프로젝트 자체를 선택한 후 ctrl + f11 => run on server 순으로 진행한다. -->

<!-- 스프링 등장 배경 정리 -->
<!-- 스프링 환경 이전에서, 애플리케이션을 구현할 때에는 EJB(Enterprise JavaBeans)를 사용했다. -->
<!-- 그리고 EJB가 점점 발전하면서 속도가 느려지고 복잡해지게 되었다. 이때를 겨울에 비유하고 있었다. -->
<!-- 그래서 EJB를 사용하지 않고 새로운 걸 사용하게 되었고, 겨울이 지나게 되어 Spring이라는 이름을 짓게 되었다. -->
<!-- 스프링 또한, Java 문법을 사용하여 기능을 구현하는 것이라 하여, 간단하고 진입장벽이 낮다고 한다. -->
<!-- POJO : Plain Old Java Object. 자바의 기본인 객체지향 설계로 돌아가자. 를 중요한 캐치프레이즈로 보는듯. -->

<!-- Spring Framework : 없어도 웹 구현을 못하진 않으나(예전 jsp-Servlet 방식으로 해도 문제없다.), 기본적 뼈대를 제공. -->
<!-- 위 뼈대를 이용해서, 기능 구현에만 집중함으로써 빠르게 웹을 개발할 수 있게끔 해주는 것이 Framework이다. -->
<!-- Framework와 비교되는 대상이 바로 Library이다. -->
<!-- Library : 프로그램 구현에 필요한 기능들을 모아놓은 것이다. 필요할 때 여기저기서 다운받고 찾아다 쓴다. -->
<!-- 그래서, Framework vs Library? -->
<!-- Framework : 정해진 양식 안의 도구를 개발자가 사용할 수 있게 하는 것이다. -->
<!-- Library : 사용자가 필요할 때 호출해서 쓸 수 있는 도구 모음이다. -->

<!-- Spring Framework의 구조 : 크게 4가지 정도만 정리하며, 나머지는 굳이 안봐도 된다. -->
<!-- 1)Java Resources(폴더) : java, resources 2개의 영역으로 나뉜다. -->
<!-- 1-1)src/main/java : 우리가 사용할 Java코드를 여기에 작성한다. -->
<!-- 1-2)src/main/resources : 나중에 배울 MyBatis(XML의 일종), DB(SQL) 등등의 자원을 관리한다. -->

<!-- 2) WEB-INF(폴더) : 웹 상의 중요한 파일이 노출되지 않게 하기 위한 폴더이다. -->
<!-- 2-1) 경로 : src/main/webapp/WEB-INF -->
<!-- META-INF 폴더는 자바에서 한 설정 관련 파일을 저장하는 폴더인데, 그냥 알아만 두자. -->
<!-- 2-2) WEB-INF/spring/root-context.xml : 워크스페이스 전체 설정이 담긴 파일.  -->
<!-- 2-3) WEB-INF/spring/appServlet/servlet-context.xml : 이 프로젝트 한정의 설정이 담긴 파일. -->
<!-- 따라서, 우리는 해당 프로젝트의 설정들만 건드릴 것이므로 servlet-context.xml를 사용한다. -->
<!-- 2-4) WEB-INF/spring/views(폴더) : MVC의 View에 해당하는, 유저 눈에 보이는.jsp, .html 등의 파일을 담는 곳이다. -->
<!-- 2-5) WEB-INF/web.xml : 프로그램 실행 시 함께 따라가는 설정들을 모아둔 파일이다. -->
<!-- 2-5-1) 클라이언트의 요청을 처리하는 [DispatcherServlet],
			웹 어플리케이션의 단위 설정을 불러오는 [ConttextLoaderListener],
			클라이언트의 요청을 DispatcherServlet으로 보내기 전에 거치는 [Filter]로 나뉜다. -->
			
<!-- 3)pom.xml : 필요한 라이브러리들을 maven의 중앙저장소에서 가져오는 역할을 하는 파일이다. -->

</body>
</html>
