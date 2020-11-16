package com.post;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class post_hnd implements post_able {

	@Override
	public String active(HttpServletRequest request, HttpServletResponse response) {
		// TODO 포스트 종류(G,A,Q,R)에 따른 페이지 view
		String part = request.getParameter("part");
		
		if(part.equals("g") && part.equals("a") && part.equals("q") && part.equals("r") ) {
			return "post_main.jsp";
		}
		
		return null;
	}

}
