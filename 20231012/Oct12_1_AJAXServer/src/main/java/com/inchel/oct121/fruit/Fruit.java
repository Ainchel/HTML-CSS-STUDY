package com.inchel.oct121.fruit;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Fruit {

	private String f_name;
	private BigDecimal f_price;
	
	public Fruit() {
		super();
	}
	
	public Fruit(String f_name, BigDecimal f_price) {
		super();
		this.f_name = f_name;
		this.f_price = f_price;
	}
	
	public String getF_name() {
		return f_name;
	}
	
	@XmlElement
	public void setF_name(String f_name) {
		this.f_name = f_name;
	}
	
	public BigDecimal getF_price() {
		return f_price;
	}
	
	@XmlElement
	public void setF_price(BigDecimal f_price) {
		this.f_price = f_price;
	}

}
