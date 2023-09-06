package com.inchel.sep06.main;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


@WebServlet("/ServletIO")
public class ServletIO extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//필요한 정보(이름, cm키, kg몸무게, 사진)를 보낸다.
		
//		BMI 공식 : 몸무게 / (키*키) 인데, 키는 미터 단위이다.
//		위 공식에서, BMI 값에 따른 분류는 아래에.
//		18.5 미만 : 저체중
//		18.5 ~ 25 : 정상
//		25 ~ 30 : 과체중
//		30 ~ 35 : 경도비만
//		35 ~ 40 : 중등도비만
//		40 ~~ 	: 고도비만
		request.setCharacterEncoding("UTF-8"); // 서버에 데이터를 전달할 때, 내가 주는 값을 UTF-8로 인코딩하라고 한다.
		response.setCharacterEncoding("UTF-8"); // 서버에서 데이터를 받아올 때, 그 데이터가 UTF-8이라고 알려준다.
		
		PrintWriter out = response.getWriter(); // 받아온 데이터 읽어줄 빨대
		String path = request.getServletContext().getRealPath("img");
		System.out.println(path);

		MultipartRequest mr = new MultipartRequest(
		request, path,
		//아래는 허용할 파일의 최대 크기
		10 * 1024 * 1024,
		//요청파라미터의 인코딩 방식을 지정 : 위 주석처리한 인코딩 지정 코드들을 대체함.
		"UTF-8", 
		//업로드하려는 파일 명이 중복될 떄의 처리 방식 지정
		//현재는 중복 시에, 파일명 뒤에 숫자를 붙여나가는 방식으로 간다.
		new DefaultFileRenamePolicy()
		);
		
		String name = mr.getParameter("NAME");
		String height = mr.getParameter("HEIGHT");
		String weight = mr.getParameter("WEIGHT");
		//String fileName = mr.getParameter("FILENAME");
		
		System.out.println(name);
		System.out.println(height);
		System.out.println(weight);
		//System.out.println(fileName);
		
		String uploadFileName = mr.getFilesystemName("FILENAME");
		
		uploadFileName = URLEncoder.encode(uploadFileName, "UTF-8");
		uploadFileName = uploadFileName.replace("+", " ");
		
		double heightM = Double.parseDouble(height) / 100.0;
		double BMI = Double.parseDouble(weight) / (heightM * heightM);
		System.out.printf("BMI : %.2f\n", BMI);
		String result = null;
		
		if(0 <= BMI && BMI < 18.5 ) {
			result = "저체중";
		} else if(18.5 <= BMI && BMI < 25) {
			result = "정상";
		} else if(25 <= BMI && BMI < 30) {
			result = "과체중";
		} else if(30 <= BMI && BMI < 35) {
			result = "경도비만";
		} else if(35 <= BMI && BMI < 40) {
			result = "중등도비만";
		} else if(40 <= BMI) {
			result = "고도비만";
		}
		
		System.out.println(result);
		
		out.print("<html>");
		//아래 코드의 html문 쓸때, meta charset='UTF-8' 요 부분에 띄어쓰기 없게 하자. 띄어쓰면 적용안되는듯.
		out.print("<head><title>BMI 결과</title><meta charset='UTF-8'></head>");
		out.print("<body>");
		
		out.printf("<img src='img/%s'>", uploadFileName);
		
		out.printf("<h1>이것이 당신입니다.</h1>");
		out.printf("당신의 BMI는 %.2f입니다. <p>", BMI);
		out.printf("BMI 기준에 따른 당신의 상태는 %s입니다. <p>", result);
		
		out.print("</body>");
		out.print("</html>");
	}

}
