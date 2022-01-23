package com.jm.last;

public class BlockMember {

 private String	c_user; 
 private String	c_blocker;
 
 public BlockMember() {
	// TODO Auto-generated constructor stub
}

public String getC_user() {
	return c_user;
}

public void setC_user(String c_user) {
	this.c_user = c_user;
}

public String getC_blocker() {
	return c_blocker;
}

public void setC_blocker(String c_blocker) {
	this.c_blocker = c_blocker;
}

public BlockMember(String c_user, String c_blocker) {
	super();
	this.c_user = c_user;
	this.c_blocker = c_blocker;
}

 
 
 
}
