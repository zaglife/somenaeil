package com.some;

import javax.servlet.http.HttpServletRequest;

public class some_service {
	private HttpServletRequest request;
	
	public some_service() {}
	public some_service(HttpServletRequest request) {
		this.request= request;
	}
	
	public void some_user() {
		String id= request.getParameter("id");
		String nick= request.getParameter("nick");
		String email= request.getParameter("email");
		int cert= (Integer.parseInt(request.getParameter("cert")));
		String pimg= request.getParameter("pimg");
		String comt= request.getParameter("comt");
		String follow= request.getParameter("follow");
		String follower= request.getParameter("follower");
		String scrap_list= request.getParameter("scrap_list");
		String like_list= request.getParameter("like_list");
	}
}
