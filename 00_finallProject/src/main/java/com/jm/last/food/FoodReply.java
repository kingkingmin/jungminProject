package com.jm.last.food;

import java.util.Date;

public class FoodReply {

	private int sir_no;
	private int sir_c_no;
	
	private double	sir_c_star;
	private String sir_c_writer;
	private String sir_c_comment;
	private Date sir_date;
	
	public FoodReply() {
		// TODO Auto-generated constructor stub
	}

	public int getSir_no() {
		return sir_no;
	}

	public void setSir_no(int sir_no) {
		this.sir_no = sir_no;
	}

	public int getSir_c_no() {
		return sir_c_no;
	}

	public void setSir_c_no(int sir_c_no) {
		this.sir_c_no = sir_c_no;
	}

	public double getSir_c_star() {
		return sir_c_star;
	}

	public void setSir_c_star(double sir_c_star) {
		this.sir_c_star = sir_c_star;
	}

	public String getSir_c_writer() {
		return sir_c_writer;
	}

	public void setSir_c_writer(String sir_c_writer) {
		this.sir_c_writer = sir_c_writer;
	}

	public String getSir_c_comment() {
		return sir_c_comment;
	}

	public void setSir_c_comment(String sir_c_comment) {
		this.sir_c_comment = sir_c_comment;
	}

	public Date getSir_date() {
		return sir_date;
	}

	public void setSir_date(Date sir_date) {
		this.sir_date = sir_date;
	}

	public FoodReply(int sir_no, int sir_c_no, double sir_c_star, String sir_c_writer, String sir_c_comment,
			Date sir_date) {
		super();
		this.sir_no = sir_no;
		this.sir_c_no = sir_c_no;
		this.sir_c_star = sir_c_star;
		this.sir_c_writer = sir_c_writer;
		this.sir_c_comment = sir_c_comment;
		this.sir_date = sir_date;
	}
	
	
	
	
}
