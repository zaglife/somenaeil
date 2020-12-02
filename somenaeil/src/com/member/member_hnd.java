package com.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.main.main_able;

public class member_hnd implements main_able{

	public String active(HttpServletRequest request, HttpServletResponse response) {
		
		String part=request.getParameter("part");
		String view = null;
		
		member_service ms = new member_service(request);

		if (part == null) {
			String userId = request.getParameter("userId");
			if(userId != null) {
				view = ms.user();
			} else {
				view = ms.joinCheck();
			}
		}
		else {
			switch (part) {
			case "join":
				ms.join();
				break;
			case "info":
				// join_edit
				break;
			case "update":
				// 회원정보 수정
				if (ms.update())
					view = null;
				else
					view = "join_edit.jsp";
				break;
			case "user":
				view = ms.user();
				break;
			case "follow":
				ms.follow();
			default:
				break;
			}
		}
		return view;
	}
}
