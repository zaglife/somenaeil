package com.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.main.main_able;

public class member_hnd implements main_able{

	public String active(HttpServletRequest request,
			HttpServletResponse response) {
		
		String part=request.getParameter("part");
		if(part==null){
			return "join.jsp";
		}else {
			member_service ms=new member_service(request);
			ms.join();
		}
			
		return null;
	}
}
