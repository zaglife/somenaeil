package com.post;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class post_hnd implements post_able {

	@Override
	public String active(HttpServletRequest request, HttpServletResponse response) {
		// TODO 포스트 종류(G,A,Q,R)에 따른 페이지 view

		String part = request.getParameter("part");
		
		post_service ps = new post_service(request);
		String view = null;
		
		if (part==null) {
			view = "index.jsp";
		}
		else {
			switch(part) {
			case "view":
				view = ps.view(); break;
			}
		}
		
		return view;
	}

}
