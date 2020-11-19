package com.post;

import java.util.ArrayList;
import java.util.HashMap;

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
	
	/**
	 * 게시글을 찾고 포스트 읽기 페이지로 전환
	 * @author gagip
	 * @return
	 */
	public String postDetail() {
		// 선택한 페이지 번호
		int pageNum = Integer.parseInt(request.getParameter("pageNum"));
		
		// 페이저 번호를 통해 DB에서 해당 포스트를 가지고 온다
		post_dao dao = new post_dao();
		post pt = dao.getPost(pageNum);
		
		// 가져온 post를 request에 전달
		request.setAttribute("post", pt);
		
		return String.format("post.jsp?pageNum=%d", pageNum);
	}
	
	/**
	 * 게시글 리스트를 찾고 해당 URL에 전달
	 * @author gagip
	 * @return
	 */
	public String postList() {
		// 검색 옵션 파라미터 값 불러오기
		String opt = request.getParameter("opt");
		String condition = request.getParameter("condition");
		
		// dao에 보낼 검색 옵션
		HashMap<String, Object> optList = new HashMap<String, Object>();
		optList.put("opt", opt);
		optList.put("condition", condition);
		
		// DB에 접근하여 결과값을 post List에 전달
		post_dao dao = new post_dao();
		ArrayList<post> postList = dao.getPostList(optList);
		
		// 결과 값을 request에 전달
		request.setAttribute("postList", postList);
		
		// 파라미터 URL 작성
		String subURL = "";
		if (opt != null && condition != null) {
			subURL += String.format("opt=%s&condition=%s", opt, condition);
		}
		
		return "index.jsp?" + subURL;
	}
}
