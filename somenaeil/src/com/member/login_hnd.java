package com.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.main.main_able;

public class login_hnd implements main_able{
	
	public String active(HttpServletRequest request, HttpServletResponse response) {
		
		String part = request.getParameter("part");
		String view = null;
		
		login_service ls = new login_service(request);
		
		if(part == null) {
			view= "login.jsp";
		}else {
			switch(part) {
			case "login" :
				view = ls.login();
				break;
			case "logout" :
				view = ls.logout();
				break;
			}
		}
		
		return view;
	}
}
