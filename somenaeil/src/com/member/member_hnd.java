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
					String check= ms.fl_check(id, uid);
					
					System.out.println(check);
					
					view= "user_other.jsp";
				} else if(id == null) {
					ms.user_self(uid);
					view= "user_other.jsp";
				}
				break;
			case "fl_update" :
				String follow= request.getParameter("follow");
				String my_id= request.getParameter("id");
				
				ms.follow(id, uid, follow);
				
				if(follow.equals("fl")) {
					request.setAttribute("follow", "no");
					view= "user_other.jsp";
				} else if(follow.equals("no")) {
					request.setAttribute("follow", "fl");
					view= "user_other.jsp";
				}
				
				break;
			}
		}
		return view;
	}
}
