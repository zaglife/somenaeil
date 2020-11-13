package com.member;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;

public class member_service {
	private  HttpServletRequest request;

	public member_service() {}
	public member_service(HttpServletRequest request) { 
		this.request= request;
	}
	
	public String login() {
			String id= request.getParameter("id");
			String pw= request.getParameter("pw");
			member_dao md= new member_dao();
			member user= md.member_select(id, pw);
			
			request.getSession().setAttribute("user", user);
			if(user == null)
				return "fail";
			
			return null;
	}
	
	public void join() {
		
		String id= request.getParameter("id");
		String pw= request.getParameter("pw");
		String name= request.getParameter("name");
		String nick= request.getParameter("nick");
		String email= request.getParameter("email");
		int cert= Integer.parseInt(request.getParameter("cert"));
		String pimg= request.getParameter("pimg");
		String comt= request.getParameter("comt");
		
		// 이메일 주소 뒷부분 추가
		email+= "@";
		
		member_dao md=new member_dao();
		md.member_insert(id, pw, name, nick, email, cert, pimg, comt);
	}
}