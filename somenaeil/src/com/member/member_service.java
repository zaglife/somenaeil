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
	
	public void user_self(String uid) {
		member_dao md= new member_dao();
		
		String id= (String)request.getSession().getAttribute("id");
		
//		member user= md.member_read(uid);
		member other= md.member_read(uid);
		
		request.setAttribute("other", other);	// 타겟 유저 멤버 객체
		
		String[] other_fl= other.getFollow().split(":");
		String[] other_flw= other.getFollower().split(":");
		for(int i=0; i< other_flw.length; i++) {
			if(other_flw[i].equals(id)) {
				request.setAttribute("follow", "yy");
				break;
			}
			//나랑  팔로워 임
		}
		request.setAttribute("other_fl", other_fl);		// 타겟 유저 팔로우 리스트 배열
		request.setAttribute("other_flw", other_flw);	// 타겟 유저 팔로워 리스트 배열
		
		ArrayList<member> fl_list= md.follow_other(other_fl);
		ArrayList<member> flw_list= md.follower_other(other_flw);
	
		request.setAttribute("fl_list", fl_list);	// 팔로우 어레이리스트 객체
		request.setAttribute("flw_list", flw_list);	// 팔로워 어레이리스트 객체
	}
	
	
	// 우선 사용 안하는 메소드
	public void user_other(String id, String uid) {
		member_dao md= new member_dao();
		member user= md.member_read(id);
		member other= md.member_read(uid);
		
		request.setAttribute("user", user);		// 로그인 유저 멤버 객체
		request.setAttribute("other", other);	// 타겟 유저 멤버 객체
		
		String[] other_fl= other.getFollow().split(":");
		String[] other_flw= other.getFollower().split(":");
		
		request.setAttribute("other_fl", other_fl);		// 타겟 유저 팔로우 리스트 배열
		request.setAttribute("other_flw", other_flw);	// 타겟 유저 팔로워 리스트 배열
		
		ArrayList<member> fl_list= md.follow_other(other_fl);
		ArrayList<member> flw_list= md.follower_other(other_flw);
		
		request.setAttribute("fl_list", fl_list);	// 팔로우 어레이리스트 객체
		request.setAttribute("flw_list", flw_list);	// 팔로워 어레이리스트 객체
	}

	public void fl_check(String id, String uid) {
		// 재료 넣기
		String s = request.getParameter("ss");
		// 요리 도구 넣기
		member_dao md= new member_dao();
		member user= md.member_read(id);
		member other= md.member_read(uid);

		String[] other_flw= other.getFollower().split(":");
		
		String result = null;
		
		for(int i=0; i<other_flw.length; i++) {
			if(other_flw[i].equals(user.getId())) result = "fl";
		}
		if (result == null) result = "no"; 
		
		request.setAttribute("follow", result);
	}
	
	
	
	public void follow(String id, String uid, String follow) {
		user_other(id, uid);
		
		member_dao md= new member_dao();
		
		member user= md.member_read(id);
		String user_follow= user.getFollow();
		
		member other= md.member_read(uid);
		String other_follower= other.getFollower();
		
		md.fl_update(id, uid, user_follow, other_follower, follow);
		fl_check(id, uid);
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