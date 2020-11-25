package com.member;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.User;

import com.main.main_able;

public class member_hnd implements main_able{

	public String active(HttpServletRequest request, HttpServletResponse response) {
		
		String part=request.getParameter("part");
		
		member_service ms= new member_service(request);
		member_dao md= new member_dao();
		
		String uid= request.getParameter("uid");
		String id= (String)request.getSession().getAttribute("id");
		
		
		String view= null;
		
		if(part == null) {
			view= "join.jsp";
		} else {
			switch(part) {
			case "join" :
				ms.join();
				view= "index.jsp";
				break;
			case "info" :
				request.setAttribute("pg", "join_edit.jsp");
				break;
			case "update" :
				ms.update();
				view= "user.jsp";
				break;
			case "user" :
				if(id.equals(uid)) {
					ms.user_self(id);
					view= "user.jsp";
				} else if(!id.equals(uid)) {
					ms.user_other(id, uid);
					view= "user_other.jsp";
				} else if(id == null) {
					ms.user_self(uid);
					
					member data= md.member_read(uid);
					request.getSession().setAttribute("data", data);
					request.getSession().setAttribute("uid", data.getId());
					view= "user_other.jsp";
				}
				break;
			case "fl_update" :

				ms.user_other(id, uid);
				
				String follow= request.getParameter("follow");
				String my_id= request.getParameter("id");

				member data= md.member_read(uid);
				String other_id= data.getId();
				String other_follow= data.getFollow();
				md.fl_update(my_id, other_id, other_follow, follow);
				
				if(follow.equals("fl")) {
					System.out.println("fl");
				} else if(follow.equals("no")) {
					System.out.println("no");
				}
				
				view= "user_other.jsp";
				// 다시 팔로우 요청한 대상의 user_other페이지로 이동하게 해줘야함
				
				break;
			}
		}
		return view;
	}
}
