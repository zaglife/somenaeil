package com.member;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.User;

import com.main.main_able;

public class member_hnd implements main_able{

	public String active(HttpServletRequest request, HttpServletResponse response) {
		
		String part=request.getParameter("part");
		String follow= request.getParameter("follow");
		
		member_service ms= new member_service(request);
		member_dao md= new member_dao();
		
		String uid= request.getParameter("uid");
		String id= (String)request.getSession().getAttribute("id");

		String view= null;
		
		System.out.println("멤버 핸들러 part= "+part);
		if(part == null) {
			view= "index.jsp";
			if(uid!=null) {
				ms.user_self(uid);
				follow= "no";
				System.out.println("멤버 핸들러 part가 널일때 uid가 널이 아닐때 = "+part);
				request.setAttribute("follow", follow);	// 비로그인시, 팔로우 버튼 클릭했을때 로그인 팝업
				view="user_other.jsp";
			}
		} else {
			switch(part) {
			case "join" :
				ms.join();
				view= "index.jsp";
				break;
			case "info" :
				request.setAttribute("pg", "join_edit.jsp");
				break;
			case "update" : // 회원정보 수정
				ms.update();
				view= "user.jsp";
				break;
			case "user" :
				if(id.equals(uid)) {				// 로그인 유저가 자신 게시물 진입시
					ms.user_self(id);
//					ms.user_other(id, uid);
					view= "user.jsp";
				} else if(!id.equals(uid)) {		// 로그인 유저가 타겟 게시물 진입시
					
					System.out.println("멤버 핸들러");
					System.out.println("uid= "+uid+" / id= "+id);
					
					ms.user_self(uid);
					view= "user_other.jsp";
				}
				break;
			case "fl_update" : // 팔로우 업데이트
				ms.follow(id, uid, follow);
				
				System.out.println("멤버 핸들러");
				System.out.println("uid= "+uid+" / id= "+id+" / follow= "+follow);
				
//				String fc= ms.fl_check(id, uid);
				
//				if(follow == "fl") {
//					System.out.println("멤버 핸들러 if 진입");
//					view= "user_other.jsp";
//				} else if(follow != "no") {
//					System.out.println("멤버 핸들러 else if 진입");
//					view= "user_other.jsp";
//				}
				view= "user_other.jsp";
				
				break;
			}
		}
		return view;
	}
}
