package com.post;

import java.io.IOException;
import java.io.PrintWriter;

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
			case "search":
				view = ps.postList(); break;
			case "reply":
				boolean result = ps.writeReply(); 
				// 정상적으로 댓글 작성이 되면 화면에 1을 전달
				// Ajax에서 전달된 값을 받고 화면 리로드
				// 때문에 자바에서 화면 전환할 필요 없음
				if (result) {
					response.setContentType("text/html;charset=UTF-8");
					PrintWriter out;
					try {
						out = response.getWriter();
						out.println("1");
						out.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				break;
			default:
				System.out.println("조건에 부합하는 화면이 존재하지 않습니다");
				view = "index.jsp";
			}
		}
		
		return view;
	}

}
