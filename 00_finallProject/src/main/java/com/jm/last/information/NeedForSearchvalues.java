package com.jm.last.information;

public class NeedForSearchvalues {

	
	private String f_writter;
	private String f_story;
	private String f_title;
	
	private int start;
	private int end;
	
	public NeedForSearchvalues() {
		// TODO Auto-generated constructor stub
	}

	public String getF_writter() {
		return f_writter;
	}

	public void setF_writter(String f_writter) {
		this.f_writter = f_writter;
	}

	public String getF_story() {
		return f_story;
	}

	public void setF_story(String f_story) {
		this.f_story = f_story;
	}

	public String getF_title() {
		return f_title;
	}

	public void setF_title(String f_title) {
		this.f_title = f_title;
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

	public NeedForSearchvalues(String f_writter, String f_story, String f_title, int start, int end) {
		super();
		this.f_writter = f_writter;
		this.f_story = f_story;
		this.f_title = f_title;
		this.start = start;
		this.end = end;
	}
	
	
	
	
	
	
}
