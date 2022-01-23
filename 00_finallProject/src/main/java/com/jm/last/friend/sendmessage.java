package com.jm.last.friend;

import java.util.Date;

public class sendmessage {

	
	private int	c_no; 

  private String c_getter;
  private String c_sender; 
	
  private String c_comment;
  
  private Date	c_date;
  
  public sendmessage() {
	// TODO Auto-generated constructor stub
}

public int getC_no() {
	return c_no;
}

public void setC_no(int c_no) {
	this.c_no = c_no;
}

public String getC_getter() {
	return c_getter;
}

public void setC_getter(String c_getter) {
	this.c_getter = c_getter;
}

public String getC_sender() {
	return c_sender;
}

public void setC_sender(String c_sender) {
	this.c_sender = c_sender;
}

public String getC_comment() {
	return c_comment;
}

public void setC_comment(String c_comment) {
	this.c_comment = c_comment;
}

public Date getC_date() {
	return c_date;
}

public void setC_date(Date c_date) {
	this.c_date = c_date;
}

public sendmessage(int c_no, String c_getter, String c_sender, String c_comment, Date c_date) {
	super();
	this.c_no = c_no;
	this.c_getter = c_getter;
	this.c_sender = c_sender;
	this.c_comment = c_comment;
	this.c_date = c_date;
}
  
  
	
}
