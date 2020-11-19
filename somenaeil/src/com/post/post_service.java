package com.post;

import javax.servlet.http.HttpServletRequest;

/**
 * 요청한 post 데이터를 클라이언트에게 반환
 * @author gagip
 *
 */
public class post_service {
	private HttpServletRequest request;
	
	public post_service(HttpServletRequest request) {
		this.request=request;
	}
	
	public String view() {
		// 선택한 페이지 번호
		int pageNum = Integer.parseInt(request.getParameter("pageNum"));
		
		// 페이저 번호를 통해 DB에서 해당 포스트를 가지고 온다
		post_dao dao = new post_dao();
		post pt = dao.select(pageNum);
		
		// 글 저장
		request.setAttribute("post", pt);
		
		return String.format("post.jsp?pageNum=%d", pageNum);
	}
}
