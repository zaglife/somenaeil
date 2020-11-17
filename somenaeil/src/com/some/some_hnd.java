package com.some;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class some_hnd implements some_able {
	
	public String active(HttpServletRequest request, HttpServletResponse response) {
		String view= null;
		String part= request.getParameter("part");
		
		String id= request.getParameter("id");
		String pw= request.getParameter("pw");
		
		if(part == null) {
			view= "user.jsp";
		} else if(part.equals("user")) {
			some_dao.member_other(id, pw);
			view= "user.jsp";
		}
		
		return view;
	}

}
