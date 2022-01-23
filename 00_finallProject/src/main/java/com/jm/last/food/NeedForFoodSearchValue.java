package com.jm.last.food;

public class NeedForFoodSearchValue {

	
	private String f_name;
	private String f_kind;
	
	private int start;
	private int end;
	
	public NeedForFoodSearchValue() {
		// TODO Auto-generated constructor stub
	}

	public String getF_name() {
		return f_name;
	}

	public void setF_name(String f_name) {
		this.f_name = f_name;
	}

	public String getF_kind() {
		return f_kind;
	}

	public void setF_kind(String f_kind) {
		this.f_kind = f_kind;
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

	public NeedForFoodSearchValue(String f_name, String f_kind, int start, int end) {
		super();
		this.f_name = f_name;
		this.f_kind = f_kind;
		this.start = start;
		this.end = end;
	}
	
	
	
	
}
