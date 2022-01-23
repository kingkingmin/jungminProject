package com.jm.last.information;

public class NeedForSearchvaluesVerK2 {

	
 private String	f_categoryK;
 private String	f_sortK;
 
 private int start;
 private int end;
	
	public String getF_categoryK() {
		return f_categoryK;
	}
	public void setF_categoryK(String f_categoryK) {
		this.f_categoryK = f_categoryK;
	}
	public String getF_sortK() {
		return f_sortK;
	}
	public void setF_sortK(String f_sortK) {
		this.f_sortK = f_sortK;
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
	public NeedForSearchvaluesVerK2(String f_categoryK, String f_sortK, int start, int end) {
		super();
		this.f_categoryK = f_categoryK;
		this.f_sortK = f_sortK;
		this.start = start;
		this.end = end;
	}
	
	
	
	
	
}
