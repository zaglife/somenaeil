package com.member;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
		request.getSession().setAttribute("id", user.getId());
		

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
		String addr= request.getParameter("addr");
		int cert= Integer.parseInt(request.getParameter("cert"));
		String pimg= request.getParameter("pimg");
		String comt= request.getParameter("comt");
		
		// 이메일 주소 뒷부분 추가
		email+= "@"+addr;
		// 회원가입 테스트를 위한 이메일 인증
		cert= 1;
		
		member_dao md=new member_dao();
		md.member_insert(id, pw, name, nick, email, cert, pimg, comt);
		member user= md.member_select(id, pw);
		request.getSession().setAttribute("user", user);
	}
	
	public void update() {
		String pw= request.getParameter("pw");
		String nick= request.getParameter("nick");
		String email= request.getParameter("email");
		String addr= request.getParameter("addr");
		// 회원가입 테스트를 위한 이메일 인증
		int cert= 1;
		String pimg= request.getParameter("pimg");
		String comt= request.getParameter("comt");
		
		String id= ((member)request.getSession().getAttribute("user")).getId();
		
		// 이메일 주소 뒷부분 추가
		email+= "@"+addr;
		
		
		member_dao md=new member_dao();
		member user= md.member_update(id, pw, nick, email, cert, pimg, comt);
		
		request.getSession().setAttribute("user", user);
	}
	
	/**
	 * 해당 유저의 팔로우 리스트를 추출
	 * @return 해당 유저의 팔로우 리스트
	 */
	public ArrayList<member> follow_list(String id) {
		member_dao md= new member_dao();
		// 내 데이터
		member my= md.member_read(id);
		// 내 데이터의 팔로우 리스트 추출 및 가공
		String[] follow_list = my.getFollow().split(":");
		// 해당 팔로우들의 데이터리스트 리턴
		ArrayList<member> fl = md.follow_other(follow_list);
		
		

		System.out.println("member_service - fl.size = "+fl.size());
		
		return fl;
	}
	
	public ArrayList<member> follower_list(String id) {
		member_dao md= new member_dao();
		// 내 데이터
		member my= md.member_read(id);
		// 내 데이터의 팔로우 리스트 추출 및 가공
		String[] follower_list = my.getFollower().split(":");
		// 해당 팔로우들의 데이터리스트 리턴
		ArrayList<member> flw = md.follower_other(follower_list);
		
		return flw;
	}
}