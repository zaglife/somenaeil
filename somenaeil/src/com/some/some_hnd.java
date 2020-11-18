package com.some;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.member.member;
import com.member.member_dao;

public class some_hnd implements some_able {
	
	public String active(HttpServletRequest request, HttpServletResponse response) {
		String view= null;
		String part= request.getParameter("part");
		
		String id= request.getParameter("id");
		String pw= request.getParameter("pw");
		member_dao md = new member_dao();
		member other = null;
		if(part == null) {
			view= "user.jsp";
		} else if(part.equals("user")) {
			other = md.select_member(id);
			view= "user.jsp";
		}
		
		return view;
	}

}
