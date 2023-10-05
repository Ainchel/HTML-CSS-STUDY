package com.inchel.oct052.calc;

//예전부터 강조했지만, 요청파라미터와 해당 데이터를 받아오는 클래스의 필드는 이름을 같게 하는 것이 좋다.
//+@로 DB의 데이터 명까지.

//Spring 환경에서는, 요청파라미터의 이름과 필드의 이름이 값다면 값을 알아서 Javabean(DTO) 객체에 넣어준다.

public class CalcResult {

	private String n;
	private int x;
	private int y;
	
	public CalcResult() {
		super();
	}
	
	public CalcResult(String n, int x, int y) {
		super();
		this.n = n;
		this.x = x;
		this.y = y;
	}
	
	public String getN() {
		return n;
	}
	
	public void setN(String n) {
		this.n = n;
	}
	
	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
}
