package com.jm.last.information;

import java.math.BigDecimal;
import java.util.Date;

public class InforReply {

	
	private int sir_no;
	private int sir_c_no;
	private String sir_c_writer;
	private String sir_c_comment;
	private Date sir_date;
	
	public InforReply() {
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

	public InforReply(int sir_no, int sir_c_no, String sir_c_writer, String sir_c_comment, Date sir_date) {
		super();
		this.sir_no = sir_no;
		this.sir_c_no = sir_c_no;
		this.sir_c_writer = sir_c_writer;
		this.sir_c_comment = sir_c_comment;
		this.sir_date = sir_date;
	}

	
	
	
}
