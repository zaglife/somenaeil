package com.some;

import javax.servlet.http.HttpServletRequest;

public class some_service {
	private HttpServletRequest request;
	
	public some_service() {}
	public some_service(HttpServletRequest request) {
		this.request= request;
	}
	
	
	// 유저페이지 정보 출력
	public void some_user() {
		String id= request.getParameter("id");
		String nick= request.getParameter("nick");
		String email= request.getParameter("email");
		int cert= Integer.parseInt(request.getParameter("cert"));
		String pimg= request.getParameter("pimg");
		String comt= request.getParameter("comt");
		String follow= request.getParameter("follow");
		String follower= request.getParameter("follower");
		String scrap_list= request.getParameter("scrap_list");
		String like_list= request.getParameter("like_list");
		
		// follow 리스트 분리
		// follower 리스트 분리
		// scrap 리스트 분리
		// like 리스트 분리
		
		// 타입 지정
		// 게시물 4개 이상부터
		// 예를들어 일반 2개, 리뷰 2개, 비율이 5:5 일때는 어떻게 처리 할 것인지 
	}
}
