package com.inchel.Sep08.BMIModel2;

import java.io.IOException;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.time.format.FormatStyle;

import javax.servlet.http.HttpServletRequest;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
public class Doctor {

	public static void CalculateBMI(HttpServletRequest request) throws SecurityException, IOException{
		
		//여기서, 파일명을 request에 싸서 내보낼 때 인코딩 시킨다.
		
		String path = request.getServletContext().getRealPath("img");
		System.out.println(path);
		
		//파일 업로드
		MultipartRequest mr = new MultipartRequest(
		request, path, 10*1024*1024, "UTF-8", new DefaultFileRenamePolicy()		
		);
		
		//NAME HEIGHT WEIGHT IMAGE
		String name = mr.getParameter("NAME");
		double height = Double.parseDouble(mr.getParameter("HEIGHT"));
		System.out.println(height);
		double weight = Double.parseDouble(mr.getParameter("WEIGHT"));
		System.out.println(weight);
		String image = mr.getFilesystemName("IMAGE");
		
		image = URLEncoder.encode(image, "UTF-8"); // 파일 이름 request에 넣을 때 인코딩
		
		double bmiresult = weight / ((height / 100) * (height / 100));
		
		DecimalFormat format = new DecimalFormat("0.00");
		String bmi = format.format(bmiresult);
		
		String result = null;
		 
		if(bmiresult < 18.5) {
			result = "저체중";
		} else if (bmiresult < 25) {
			result = "정상";
		} else if (bmiresult < 30 ) {
			result = "과체중";
		} else if (bmiresult < 35) {
			result = "경도비만";
		} else if (bmiresult < 40) {
			result = "중등도비만";
		} else if (40 <= bmiresult) {
			result = "고도비만";
		}
		
		Guest g = new Guest(name, height, weight, image, bmi, result);
		request.setAttribute("g", g);
	}
	
}
