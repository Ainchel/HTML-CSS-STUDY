package com.inchel.oct131.error;

import java.util.List;

public class Errors {

	private List<Error> error;

	public Errors() {
		super();
	}

	public Errors(List<Error> error) {
		super();
		this.error = error;
	}

	public List<Error> getError() {
		return error;
	}

	public void setError(List<Error> error) {
		this.error = error;
	}
	
}
