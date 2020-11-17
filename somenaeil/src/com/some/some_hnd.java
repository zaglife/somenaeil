package com.some;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class some_hnd implements some_able {
	
	public String active(HttpServletRequest request, HttpServletResponse response) {
		
		String part= request.getParameter("part");
		
		some_service ss= new some_service(request);
		String view= null;
		
		if(part == null) {
			view= "user.jsp";
		} else if(part != null) {
			int followNum= ss.follow_num();
			int followerNum= ss.follower_num();
			view= "user.jsp";
		}
		
		return view;
	}

}
