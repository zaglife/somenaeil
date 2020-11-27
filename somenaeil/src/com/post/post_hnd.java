package com.post;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.member.member;
import com.vote.vote_service;

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
			case "post" :
				view = "post_main.jsp"; break;
			case "writer" :
				vote_service vs = new vote_service(request);
				vs.add();
				view = ps.add(); break;
			case "search":
				view = ps.postList(); break;
			case "reply":
				view = ps.writeReply(); break;
			default:
				System.out.println("조건에 부합하는 화면이 존재하지 않습니다");
				view = "index.jsp";
			}
		}
		
		return view;
	}

}
