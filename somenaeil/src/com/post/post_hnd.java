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
			case "postDetail":
				view = ps.postDetail(); break;
			case "postList":
				view = ps.postList(); break;
			case "writer" :
				view =ps.add(); break;
			default:
				System.out.println("조건에 부합하는 화면이 존재하지 않습니다");
				view = "index.jsp";
			}
		}
		
		return view;
	}

}
