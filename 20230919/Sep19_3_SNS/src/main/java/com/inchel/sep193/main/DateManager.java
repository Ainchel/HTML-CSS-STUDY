package com.inchel.sep193.main;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

//날짜는 여기저기서 다룰 수있으므로 main 패키지에 대입.
public class DateManager {

	//<select>에서 연도를 쓸 때 100년씩 갖고올건데, 해마다 직접 바꾸지 말고 받아오게끔 해보자.
	public static void getCurYear(HttpServletRequest req) {
		Date now = new Date(); // 현재 시각을 받아온 객체 생성
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy"); // 연도값만 가져올 SimpleDateFormat 객체 생성
		String curYear = sdf.format(now); // 현재시각을 sdf 폼에 맞게 집어넣기
		req.setAttribute("cy", curYear);
	}
	
}
