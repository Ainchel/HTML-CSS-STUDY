package com.inchel.oct053.convertunit;

public class ConvertResult {

	private double inputValue;
	private String convertUnit;
	
	public ConvertResult() {
		super();
	}
	
	public ConvertResult(double inputValue, String convertUnit) {
		super();
		this.inputValue = inputValue;
		this.convertUnit = convertUnit;
	}
	
	public double getInputValue() {
		return inputValue;
	}
	
	public void setInputValue(double inputValue) {
		this.inputValue = inputValue;
	}
	
	public String getConvertUnit() {
		return convertUnit;
	}
	
	public void setConvertUnit(String convertUnit) {
		this.convertUnit = convertUnit;
	}
	
}
