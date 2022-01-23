package com.jm.last.friend;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

public class TokenMaker {

	
	public static void makeToken(HttpServletRequest req) {
		
		Date d =new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:SS");
		String token = sdf.format(d);
		
		req.setAttribute("token", token);
		
	}
	
	
}
