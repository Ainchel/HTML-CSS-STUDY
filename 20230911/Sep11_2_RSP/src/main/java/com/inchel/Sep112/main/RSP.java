package com.inchel.Sep112.main;

public class RSP {
	
	private static final RSP singleRSP = new RSP();
	
	private RSP() {}
	
	//싱글톤 방식에서, 유일하게 하나만든 객체를 전해받는 방법
	public static RSP getInstance() {
		return singleRSP;
	}
	
	private int winCount = 0;
	private int loseCount = 0;
	
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

	public static String check(int mySel, int comSel) {
		
		if(mySel == 1) {//가위일 때
			//컴이 가위일 때
			if(comSel == 1) return "勝負なし";
			//컴이 바위일 때
			else if(comSel == 2) return "敗北";
			//컴이 보일 때
			else if(comSel == 3) return "勝利"; 
			
		} else if(mySel == 2) { //바위일 때
			//컴이 가위일 때
			if(comSel == 1) return "勝利";

			// 컴이 바위일 때
			else if(comSel == 2) return "勝負なし";
			// 컴이 보일 때
			else if(comSel == 3) return "敗北";
		} else if(mySel == 3) { // 보일 때
			//컴이 가위일 때
			if(comSel == 1) return "敗北";
			// 컴이 바위일 때
			else if(comSel == 2) return "勝利";// 컴이 보일 때
			else if(comSel == 3) return "勝負なし";
		}
		
		return null;
	}
	
	public static String comselName(int comSel) {
		if(comSel == 1) return "ジャン";
		else if(comSel == 2) return "ケン";
		else if(comSel == 3) return "ポン";
		
		return null;
	}
	
	public static void WinloseCount(String result) {
		
		if(result == "勝利") {
			singleRSP.winCount++;
		} else if(result == "敗北") {
			singleRSP.loseCount++;
		}
		
	}
	
	public static String fileStringCheck(int selNum) {
		
		if(selNum == 1) {
			return "Scissors.png";
		} else if(selNum == 2) {
			return "Rock.png";
		} else if(selNum == 3) {
			return "Paper.png";
		}
		
		return null;
	}
	
	public static void Reset() {
		singleRSP.winCount = 0;
		singleRSP.loseCount = 0;
		
		System.out.println(singleRSP.winCount);
		System.out.println(singleRSP.loseCount);
	}
	
	
}
