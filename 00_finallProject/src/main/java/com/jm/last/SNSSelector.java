package com.jm.last;

public class SNSSelector {
	
	private String search;
	private String c_genderK;
	private String c_countryK;
	private int start;
	private int end;
	
	public SNSSelector() {
		// TODO Auto-generated constructor stub
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public String getC_genderK() {
		return c_genderK;
	}

	public void setC_genderK(String c_genderK) {
		this.c_genderK = c_genderK;
	}

	public String getC_countryK() {
		return c_countryK;
	}

	public void setC_countryK(String c_countryK) {
		this.c_countryK = c_countryK;
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

	public SNSSelector(String search, String c_genderK, String c_countryK, int start, int end) {
		super();
		this.search = search;
		this.c_genderK = c_genderK;
		this.c_countryK = c_countryK;
		this.start = start;
		this.end = end;
	}
	
	
	
	
	
	
	
}
