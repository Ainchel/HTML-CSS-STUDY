package com.inchel.oct131.error;

public class Error {

	private String e_what;
	private String e_where;
	
	public Error() {
		super();
	}
	
	public Error(String e_what, String e_where) {
		super();
		this.e_what = e_what;
		this.e_where = e_where;
	}
	
	public String getE_what() {
		return e_what;
	}
	
	public void setE_what(String e_what) {
		this.e_what = e_what;
	}
	
	public String getE_where() {
		return e_where;
	}
	
	public void setE_where(String e_where) {
		this.e_where = e_where;
	}
	
}
