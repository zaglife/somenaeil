package com.vote;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.post.post_able;

public class vote_hnd implements post_able{

	@Override
	public String active(HttpServletRequest request, HttpServletResponse response) {
		String vote = request.getParameter("vote");
		
		if(vote.equals("true")) {
			vote_service vs = new vote_service(request);
			vs.add();
		}
		return null;
	}

}
