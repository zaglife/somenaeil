package com.post;

import java.net.URLDecoder;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.member.member;
import com.reply.reply;
import com.reply.reply_dao;

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
		
		// 댓글 가져오기
		reply_dao replyDAO = new reply_dao();
		ArrayList<reply> replyList = replyDAO.getReplyList(pageNum);
		
		// 가져온 post와 댓글들을 request에 전달
		request.setAttribute("post", pt);
		request.setAttribute("replyList", replyList);
		
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
		String content = request.getParameter("content"); // 서버로 보내는 방법1에서쓰임 
		String[] temp = request.getParameterValues("hash");
		String hash = "";
		if(temp != null) {
			for(int i = 0; i < temp.length; i++) {
				hash += temp[i];
			}
			hash += temp[temp.length-1];
		}
		
		String context = request.getParameter("context");

		post_dao pd = new post_dao();
		pd.add(writer, title, cate, context, hash);		
		
		return null;
	}
	
	
	public String writeReply() {
		// 파라미터 불러오기
		String author = request.getParameter("author");
		String context = request.getParameter("context");
		try {
			author = URLDecoder.decode(author, "UTF-8");
			context = URLDecoder.decode(context, "utf-8");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		int post_num = Integer.parseInt(request.getParameter("post_num"));
		
		// 댓글 인스턴스 생성
		reply rep = new reply();
		reply_dao replyDAO = new reply_dao();
		
		// DB 데이터 -> 인스턴스 변수
		rep.setNum(replyDAO.getSeq());
		rep.setPost_num(post_num);
		rep.setAuthor(author);
		rep.setContext(context);
		
		boolean result = replyDAO.insertReply(rep);
		
	
		return "#";		// ajax를 이용할 것이기 때문에 화면 이동 X
	}
}
