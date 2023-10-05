package com.inchel.oct051.fruit;

//객체를 여러개 등록해서 사용하려면, 어제처럼 Sprint Beans Configuration file에 여러개 넣는게 좋다.
//만일 그렇지 않고 싱글톤 방식으로, 객체를 하나만 만들어서 쓰고 싶다면?
//root-context.xml이나, servlet-context.xml에 만드는 것이 좋다.

//그래서, 위 두 xml에 객체를 만들려면?
//1. root-context.xml : xml에서 만든 객체가 톰캣 위에 달아둔 프로젝트들 전체에 영향을 준다.
//2. servlet-context.xml : xml에서 만든 객체가 현재 프로젝트에만 영향을 준다.
//이번에는 servlet-context.xml에 객체를 등록할 예정이다.

public class Fruit {

	private String name;
	private int price;
	
	public Fruit() {
		super();
	}
	
	public Fruit(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
}
