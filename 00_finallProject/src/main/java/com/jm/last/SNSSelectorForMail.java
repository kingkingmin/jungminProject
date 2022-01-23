package com.jm.last;

public class SNSSelectorForMail {
	
	
	private String c_getter;
	private int start;
	private int end;
	
	public SNSSelectorForMail() {
		// TODO Auto-generated constructor stub
	}

	public String getC_getter() {
		return c_getter;
	}

	public void setC_getter(String c_getter) {
		this.c_getter = c_getter;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public SNSSelectorForMail(String c_getter, int start, int end) {
		super();
		this.c_getter = c_getter;
		this.start = start;
		this.end = end;
	}

	
	
	
	
}
