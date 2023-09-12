package com.inchel.sep122.main;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NBManager {

	private static final NBManager NBMSingleton = new NBManager();
	
	private NBManager () {}
	
	public static NBManager getInstance() {
		return NBMSingleton;
	}
	
	String comNum = "";

	//중복되지 않는 숫자를 뽑는 방법
	//001 ~ 011 : 안됨.
	//012 ~ 987 : 가능.
	//988 ~ 999 : 안됨.
	
	public String pickAns() {
		int a = new Random().nextInt(976) + 12; // 12 ~ 987까지 뽑기.
		String ans = String.format("%03d", a);
		
		if(ans.charAt(0) == ans.charAt(1)||
		   ans.charAt(0) == ans.charAt(2)||
		   ans.charAt(1) == ans.charAt(2)) {
			return pickAns();
		}
		return ans;
	}
	
	public String createComNum() {
		
			int a = new Random().nextInt(999) + 1;
			int num100 = 0;
			int num10;
			int num1;
			
			if(a >= 100) {
			num100 = a / 100;
			a -= num100 * 100;
			}
			num10 = a / 10;
			a -= num10 * 10;
			num1 = a;
		
			if(num100 == num10 || num100 == num1 || num10 == num1) {
				return createComNum();
			} else {
				return Integer.toString(num100) + Integer.toString(num10) + Integer.toString(num1);
			}
		}
	
	public void doNBGame(HttpServletRequest request, HttpServletResponse response, String comNum) {
		String userNum = request.getParameter("USERNUM");
		if(userNum.length() == 2) {
			userNum = "0" + userNum;
		}
		
		int ballCount = 0;
		int strikeCount = 0;
		String result = "まだ正解ではありません！";
		
		for(int i = 0; i < userNum.length(); i++) {
			for(int j = 0; j < comNum.length(); j++) {
				if(userNum.charAt(i) == comNum.charAt(j)) {
					if(i == j) {
						strikeCount++;
					} else {
						ballCount++;
					}
				}
			}
		}// for end
		
		if(userNum.equals(comNum)) {
			result = "正解です！！！！！";
		}
		
		request.setAttribute("USERNUM", request.getParameter("USERNUM"));
		request.setAttribute("BALLCOUNT", ballCount);
		request.setAttribute("STRIKECOUNT", strikeCount);
		request.setAttribute("RESULT", result);
		
	}//doNBGame end
	
	public void reset() {
		comNum = "";
	}
	
}
