package com.inchel.oct101.test;

import java.util.Date;

public class Test {

	private String t_title;
	private Date t_when;
	
	public Test() {
		super();
	}
	
	public Test(String t_title, Date t_when) {
		super();
		this.t_title = t_title;
		this.t_when = t_when;
	}
	
	public String getT_title() {
		return t_title;
	}
	
	public void setT_title(String t_title) {
		this.t_title = t_title;
	}
	
	public Date getT_when() {
		return t_when;
	}
	
	public void setT_when(Date t_when) {
		this.t_when = t_when;
	}
	
}
