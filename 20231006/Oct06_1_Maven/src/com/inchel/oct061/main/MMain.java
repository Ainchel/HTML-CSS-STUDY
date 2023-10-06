package com.inchel.oct061.main;

import org.xmlpull.v1.XmlPullParser;

import com.beaver.http.client.BeaverHttpClient;

//Java 다들 많이 쓰고 있다.
//개발자들은 자기들이 만든 결과물들을 공유하는 문화가 있었다.
//다만, 소스(코드)를 그대로 공유하지는 않았으며 .jar로 만들어 공유하게 되었다.
//.jar(라이브러리) 파일을 자동으로 관리해주는 시스템이 있는데, 이걸 Maven이라고 한다.

//Maven 중앙 저장소가 저런 .jar들을 관리해주는 중앙 시스템과 같다.
//하지만 Maven 중앙 저장소에도 없는 경우가 있을 것인데, 이 때에는 로컬 저장소(내 컴퓨터)를 활용한다.
//즉, 내가 만들었던 것들을 .jar로 뽑아서 쓸 수도 있다는 뜻.
//로컬 Maven 저장소 위치 : C\사용자\사용자이름\.m2\repository이다.
//스프링 사용 중, 라이브러리에 뭔가 이상이 생겼다면 위 폴더를 지우는 걸로 해결할수 있다.
//================================================================

//우리가 예전에 사용하던 .jar파일을 Maven 로컬 저장소에 등록시켜 보자.
//먼저 Maven 프로젝트로 변환을 해야 하는데, 프로젝트 우클릭 후 - Configure - Convert to Maven Project를 진행하면된다.

//메이븐을 통해 jar 파일 임포트하기
//1)프로젝트 우클릭 - import - import를 누른 후, "install or deploy ~~~~ " 클릭
//2) artifact file 부분에 browse - 사용할 jar 파일 선택
//3) Group id, Artifact id, 버전, packaging(jar) 등등 선택한 후 finish를 고르자.

//================================================================

//로컬 저장소에 있는 jar를 이 프로젝트로 끌어와보기
// pom.xml => Dependencies 탭 클릭 => Add 버튼 클릭
// => Artifact Id로 검색 후 선택.
//================================================================
//메이븐 라이브러리를 읽어오지 못할 때에는?? 빠르게 IDE를 종료 후, 로컬 저장소를 지우고 => 재시작


public class MMain {

	public static void main(String[] args) {
		
		//위에서 가져온 "BHC" 라이브러리가 잘 적용되었는지 확인하기 위해, "BeaverHttpClient" 자동완성 되는지 확인해보기
		BeaverHttpClient bhc;
		XmlPullParser asd;
	}
}
