package com.inchel.Sep141.apple;

public class AppleDTO {

	private String a_location;
	private String a_color;
	private String a_taste;
	private int a_price;
	private String a_introduce;
	
	public AppleDTO() {}
	
	public String getLocation() {
		return a_location;
	}
	public void setLocation(String location) {
		this.a_location = location;
	}
	public String getColor() {
		return a_color;
	}
	public void setColor(String color) {
		this.a_color = color;
	}
	public String getTaste() {
		return a_taste;
	}
	public void setTaste(String taste) {
		this.a_taste = taste;
	}
	public int getPrice() {
		return a_price;
	}
	public void setPrice(int price) {
		this.a_price = price;
	}
	public String getIntroduce() {
		return a_introduce;
	}
	public void setIntroduce(String introduce) {
		this.a_introduce = introduce;
	}
	public AppleDTO(String location, String color, String taste, int price, String introduce) {
		super();
		this.a_location = location;
		this.a_color = color;
		this.a_taste = taste;
		this.a_price = price;
		this.a_introduce = introduce;
	}
	
}


//a_location VARCHAR(10 CHAR) PRIMARY KEY,
//a_color VARCHAR(10 CHAR) NOT NULL,
//a_taste VARCHAR(10 CHAR) NOT NULL,
//a_price NUMBER(5) NOT NULL,
//a_introduce VARCHAR(20 CHAR) NOT NULL

