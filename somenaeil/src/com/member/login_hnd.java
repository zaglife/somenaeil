package com.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.main.main_able;

public class login_hnd implements main_able{
	public String active(HttpServletRequest request, HttpServletResponse response) {
		
		String part= request.getParameter("part");
		System.out.println("login_hnd - part= "+part);
		if(part == null) {
			// 로그인 되어있는 경우
			if(request.getSession().getAttribute("user")!=null) {
				request.getSession().removeAttribute("user");
				return null;
			}
			
			// 로그인이 안되어있는 경우
			return "login.jsp";
		} else {
			member_service ms= new member_service(request);
			
			if(ms.login() == null) {
				return "index.jsp";
			}else {
				request.getSession().setAttribute("fail", true);
				return "login.jsp";
			}
		}
	}
}
