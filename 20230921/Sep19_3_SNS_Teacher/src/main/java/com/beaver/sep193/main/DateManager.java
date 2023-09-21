package com.beaver.sep193.main;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

// 여기저기서 날짜를 많이 다룰 수 있기 때문에 main쪽에 배치함
public class DateManager {
	
	// <select> 년도에서 해마다 바꾸지말고 받아오자
	public static void getCurYear(HttpServletRequest req) {
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		String curYear = sdf.format(now);
		req.setAttribute("cy", curYear);
	}
}













