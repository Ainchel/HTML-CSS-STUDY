package com.inchel.Sep12_1.main;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OddEvenManager {

	private int playCount = 0;
	private int winCount = 0;
	private int loseCount = 0;
	private int comSel = 0;
	private String mySel = "";
	private String result = "";
	boolean isGameOn = false;
	private Double winRate = 0.0;
	private String winRateStr = "";
	
	private static final OddEvenManager OESingleton = new OddEvenManager();
	
	private OddEvenManager() {}
	
	public static OddEvenManager getInstance() {
		return OESingleton;
	}
	
	public void doGame(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		isGameOn = true;
		playCount++;
		
		if(request.getParameter("ODD") == "") {
			comSel = (int)(Math.random() * 10) + 1;
			mySel = "홀";
			if(comSel % 2 == 0) { // 짝수일 때
				result = "패";
				loseCount++;
			} else {
				result = "승";
				winCount++;
			}
		} else if(request.getParameter("EVEN") == "") {
			comSel = (int)(Math.random() * 10) + 1;
			mySel = "짝";
			if(comSel % 2 == 0) { // 짝수일 때
				result = "승";
				winCount++;
			} else {
				result = "패";
				loseCount++;
			}
		}
		
		winRate = ((double)winCount/playCount) * 100.0;
		winRateStr = String.format("%.2f", winRate);
		
		request.setAttribute("PLAYCOUNT", playCount);
		request.setAttribute("WINCOUNT", winCount);
		request.setAttribute("LOSECOUNT", loseCount);
		request.setAttribute("COMSEL", comSel);
		request.setAttribute("MYSEL", mySel);
		request.setAttribute("RESULT", result);
		request.setAttribute("WINRATESTR", winRateStr);
		
		request.getRequestDispatcher("OEGame.jsp").forward(request, response);
	}
	
	public void reset(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("RESET") == "") {
			playCount = 0;
			winCount = 0;
			loseCount = 0;
			winRateStr = "0.0";
		}
		
		request.getRequestDispatcher("OEGame.jsp").forward(request, response);
		isGameOn = false;
	}

	public int getWinCount() {
		return winCount;
	}

	public void setWinCount(int winCount) {
		this.winCount = winCount;
	}

	public int getLoseCount() {
		return loseCount;
	}

	public void setLoseCount(int loseCount) {
		this.loseCount = loseCount;
	}

	public int getComSel() {
		return comSel;
	}

	public void setComSel(int comSel) {
		this.comSel = comSel;
	}

	public String getMySel() {
		return mySel;
	}

	public void setMySel(String mySel) {
		this.mySel = mySel;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public int getPlayCount() {
		return playCount;
	}

	public void setPlayCount(int playCount) {
		this.playCount = playCount;
	}

	public boolean isGameOn() {
		return isGameOn;
	}

	public void setGameOn(boolean isGameOn) {
		this.isGameOn = isGameOn;
	}

	public Double getWinRate() {
		return winRate;
	}

	public void setWinRate(Double winRate) {
		this.winRate = winRate;
	}

	public String getWinRateStr() {
		return winRateStr;
	}

	public void setWinRateStr(String winRateStr) {
		this.winRateStr = winRateStr;
	}
	
}
