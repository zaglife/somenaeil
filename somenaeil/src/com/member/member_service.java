package com.member;

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
		
		// 회원가입 테스트를 위한 이메일 인증
		cert= 1;
		
		member_dao md=new member_dao();
		md.member_insert(id, pw, name, nick, email, cert, pimg, comt);
		
		member user= md.member_select(id, pw);
		request.getSession().setAttribute("user", user);
	}
}