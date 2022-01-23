package com.jm.last.information;

import java.util.Date;
import java.util.List;

public class inforboardValue {

	private int    f_no;
	private String f_writter;
	
	
	private String f_categoryK;
	private String f_categoryJ;
	
	private String f_sortK;
	private String f_sortJ;
	
	
	private String f_title;
	private String f_story;;
	private String f_mapinfo1;
	private String f_mapinfo2;
	private String f_mapinfo3;
	private String f_mapinfoName;
	private String f_photo;
	private Date   f_date;
	
	  private List<InforReply> reply;

	
	public List<InforReply> getReply() {
		return reply;
	}

	public void setReply(List<InforReply> reply) {
		this.reply = reply;
	}
/////////////////////////////////////////////////////////
	
	public inforboardValue() {
		// TODO Auto-generated constructor stub
	}

	public int getF_no() {
		return f_no;
	}

	public void setF_no(int f_no) {
		this.f_no = f_no;
	}

	public String getF_writter() {
		return f_writter;
	}

	public void setF_writter(String f_writter) {
		this.f_writter = f_writter;
	}

	public String getF_categoryK() {
		return f_categoryK;
	}

	public void setF_categoryK(String f_categoryK) {
		this.f_categoryK = f_categoryK;
	}

	public String getF_categoryJ() {
		return f_categoryJ;
	}

	public void setF_categoryJ(String f_categoryJ) {
		this.f_categoryJ = f_categoryJ;
	}

	public String getF_sortK() {
		return f_sortK;
	}

	public void setF_sortK(String f_sortK) {
		this.f_sortK = f_sortK;
	}

	public String getF_sortJ() {
		return f_sortJ;
	}

	public void setF_sortJ(String f_sortJ) {
		this.f_sortJ = f_sortJ;
	}

	public String getF_title() {
		return f_title;
	}

	public void setF_title(String f_title) {
		this.f_title = f_title;
	}

	public String getF_story() {
		return f_story;
	}

	public void setF_story(String f_story) {
		this.f_story = f_story;
	}

	public String getF_mapinfo1() {
		return f_mapinfo1;
	}

	public void setF_mapinfo1(String f_mapinfo1) {
		this.f_mapinfo1 = f_mapinfo1;
	}

	public String getF_mapinfo2() {
		return f_mapinfo2;
	}

	public void setF_mapinfo2(String f_mapinfo2) {
		this.f_mapinfo2 = f_mapinfo2;
	}

	public String getF_mapinfo3() {
		return f_mapinfo3;
	}

	public void setF_mapinfo3(String f_mapinfo3) {
		this.f_mapinfo3 = f_mapinfo3;
	}

	public String getF_mapinfoName() {
		return f_mapinfoName;
	}

	public void setF_mapinfoName(String f_mapinfoName) {
		this.f_mapinfoName = f_mapinfoName;
	}

	public String getF_photo() {
		return f_photo;
	}

	public void setF_photo(String f_photo) {
		this.f_photo = f_photo;
	}

	public Date getF_date() {
		return f_date;
	}

	public void setF_date(Date f_date) {
		this.f_date = f_date;
	}

	public inforboardValue(int f_no, String f_writter, String f_categoryK, String f_categoryJ, String f_sortK,
			String f_sortJ, String f_title, String f_story, String f_mapinfo1, String f_mapinfo2, String f_mapinfo3,
			String f_mapinfoName, String f_photo, Date f_date, List<InforReply> reply) {
		super();
		this.f_no = f_no;
		this.f_writter = f_writter;
		this.f_categoryK = f_categoryK;
		this.f_categoryJ = f_categoryJ;
		this.f_sortK = f_sortK;
		this.f_sortJ = f_sortJ;
		this.f_title = f_title;
		this.f_story = f_story;
		this.f_mapinfo1 = f_mapinfo1;
		this.f_mapinfo2 = f_mapinfo2;
		this.f_mapinfo3 = f_mapinfo3;
		this.f_mapinfoName = f_mapinfoName;
		this.f_photo = f_photo;
		this.f_date = f_date;
		this.reply = reply;
	}



	
	
}
