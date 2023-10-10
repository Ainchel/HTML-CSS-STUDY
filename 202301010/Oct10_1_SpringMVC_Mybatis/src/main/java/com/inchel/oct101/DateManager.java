package com.inchel.oct101;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

public class DateManager {

	// <select> 년도에서 해마다 바꾸지말고 받아오자
		public static void getCurYear(HttpServletRequest req) {
			Date now = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
			String curYear = sdf.format(now);
			req.setAttribute("cy", curYear);
		}
	
}
