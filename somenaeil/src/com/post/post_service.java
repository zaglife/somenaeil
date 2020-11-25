package com.post;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import com.member.member;

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
		String cate = request.getParameter("cate");
		String condition = request.getParameter("condition");
		
		// DB에 접근하여 결과값을 post List에 전달
		post_dao dao = new post_dao();
		ArrayList<post> postList = dao.getPostList(cate, condition);
		
		// 결과 값을 request에 전달
		request.setAttribute("postList", postList);
		
		// 파라미터 URL 작성
		String subURL = "";
		if (!subURL.endsWith("?")) subURL += "&";
		subURL += String.format("cate=%s&condition=%s", cate, condition);
		
		
		return "index.jsp?" + subURL;
	}
	
	
	public String add() {
		String writer = ((member)request.getSession().getAttribute("user")).getName();
		String title = request.getParameter("title");
		String cate = request.getParameter("cate_btn");
		String content = request.getParameter("content");
		String[] temp = request.getParameterValues("hash");
		String hash = "";
		
		if(temp != null) {
			for(int i = 0; i < temp.length; i++) {
				hash += temp[i];
			}
			hash += temp[temp.length-1];
		}
		String context = request.getParameter("context");
		String vote_chk = request.getParameter("vote");
		
		post_dao pd = new post_dao();
		
		if(vote_chk.equals("true")) { // vote_chk에 true가 들어가 있을시 실행 (투표를 만들었는지 안만들었는지 확인한다)
			pd.voteadd(); // 확인했을 경우 DB작업하도록 메소드 실행
		}
		pd.add(writer, title, cate, context, hash);		
		
		return null;
	}
}
