package com.inchel.Sep08.BMIModel2;

public class Guest {
	private String name = "";
	private double height = 0.0;
	private double weight = 0.0;
	private String image = "";
	private String bmi;
	private String result;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getBmi() {
		return bmi;
	}
	public void setBmi(String bmi) {
		this.bmi = bmi;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
	public Guest(String name, double height, double weight, String image, String bmi, String result) {
		this.name = name;
		this.height = height;
		this.weight = weight;
		this.image = image;
		this.bmi = bmi;
		this.result = result;
	}
	
}
