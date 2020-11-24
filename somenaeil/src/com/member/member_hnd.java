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
				if(id == null) {
					member data= md.member_read(uid);
					request.getSession().setAttribute("data", data);
					request.getSession().setAttribute("uid", data.getId());
					view= "user_other.jsp";
					System.out.println("member_hnd - <user>case if문 1번째");
				}else if(id.equals(uid)) {
					md.member_read(uid);
					view= "user.jsp";
					System.out.println("member_hnd - <user>case if문 2번째");
				} else if(!id.equals(uid)) {
					member data= md.member_read(uid);
					request.getSession().setAttribute("data", data);
					request.getSession().setAttribute("uid", data.getId());
					view= "user_other.jsp";
					System.out.println("member_hnd - <user>case if문 3번째");
				}
				break;
			case "fl_update" :
				System.out.println("member_hnd - <fl_update>case");
				String follow= request.getParameter("follow");
				String my_id= request.getParameter("id");
				
				member data= md.member_read(uid);

				String other_id= data.getId();
				String other_follow= data.getFollow();
				md.fl_update(my_id, other_id, other_follow, follow);
				
				view= "user_other.jsp";
				// 다시 팔로우 요청한 대상의 user_other페이지로 이동하게 해줘야함
				
				break;
			}
		}
		return view;
	}
}
