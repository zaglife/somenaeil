package com.post;

import static com.common.DBUtil.*;
import java.net.URLDecoder;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import com.member.member;
import com.member.member_dao;

import com.noti.noti_dao;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.reply.reply;
import com.reply.reply_dao;
import com.vote.vote_dao;

/**
 * 요청한 post 데이터를 클라이언트에게 반환
 * @author gagip
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
		// 페이저 번호를 통해 DB에서 해당 포스트를 가지고 온다
		int pageNum = Integer.parseInt(request.getParameter("pageNum"));
		
		// 커넥션 및 DB 연결
		Connection conn = getConnection();
		post_dao postDAO = post_dao.getInstance();
		postDAO.setConnection(conn);
		
		// 포스트 가져오기
		post pt = postDAO.getPost(pageNum);
		postDAO.updateViewCount(pageNum);		// 조회수 1 증가
		
		// 댓글 가져오기
		reply_dao replyDAO = reply_dao.getInstance();
		replyDAO.setConnection(conn);
		ArrayList<reply> replyList = replyDAO.getReplyList(pageNum);
		
		// member pimg
		member_dao memberDAO = member_dao.getInstance();
		memberDAO.setConnection(conn);
		String pimg = memberDAO.selectMember(pt.getId()).getPimg();
		
		
		// 가져온 post와 댓글들을 request에 전달
		request.setAttribute("post", pt);
		request.setAttribute("replyList", replyList);
		request.setAttribute("pimg", pimg);
		
		return String.format("post.jsp?pageNum=%d", pageNum);
	}
	
	/**
	 * 게시글 리스트를 찾고 해당 URL에 전달
	 * @author gagip
	 * @return
	 */
	public String postList() {
		// 카테고리 및 검색값 불러오기
		String cate = request.getParameter("cate");
		String condition = request.getParameter("condition");
		
		// DB에 접근하여 결과값을 post List에 전달
		Connection conn = getConnection();
		post_dao postDAO = post_dao.getInstance();
		postDAO.setConnection(conn);
		
		ArrayList<post> postList = new ArrayList<post>();
		postList = postDAO.getPostList(cate, condition);
		
		// 결과 값을 request에 전달
		request.setAttribute("postList", postList);
		
		// 파라미터 URL 작성
		String subURL = "";
		if (!subURL.endsWith("?")) subURL += "&";
		subURL += String.format("cate=%s&condition=%s", cate, condition);
		
		
		return "index.jsp?" + subURL;
	}
	
	/**
	 * 포스트를 DB에 저장
	 * @return
	 */
	public String post_insert() {
		// post DB에 들어갈 변수 선언
		String id = ((member)request.getSession().getAttribute("sessionUser")).getId();
		String nick = ((member)request.getSession().getAttribute("sessionUser")).getNick();
		String title = request.getParameter("title");
		String cate = request.getParameter("cate_btn");
		String content = request.getParameter("content");
		
		String[] hash_temp = request.getParameterValues("hash");
		String hash = "";
		
		if(hash_temp != null) {
			for(int i = 0; i < hash_temp.length; i++) {
				hash += hash_temp[i] +",";
			}
			hash += hash_temp[hash_temp.length-1];
		}

		post_dao pd = new post_dao();
		pd.add(id, nick, cate, title, content, hash);

		return null; // DB에 저장만하면되니까 null
	}
	
	
	/**
	 * 댓글 쓰기
	 * @author gagip
	 * @return
	 */
	public String writeReply() {
		// 파라미터 불러오기
		String replyWriterId = request.getParameter("replyWriterId");
		String replyWriterNick = request.getParameter("replyWriterNick");
		String postWriterId = request.getParameter("postWriterId");
		String content = request.getParameter("content");
		int post_num = Integer.parseInt(request.getParameter("post_num"));
		
		// 한글 인코딩
		try {
			replyWriterNick = URLDecoder.decode(replyWriterNick, "UTF-8");
			content = URLDecoder.decode(content, "UTF-8");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		// 글쓴이가 존재하지 않다면 종료
		if (replyWriterId == null || replyWriterId == "")
			return String.format("read.post?part=postDetail&pageNum=%d#", post_num);
		
		// 댓글 DAO 인스턴스 생성
		Connection conn = getConnection();
		reply_dao replyDAO = reply_dao.getInstance();
		replyDAO.setConnection(conn);
		reply rep = new reply();
		
		
		// DB 데이터 -> 인스턴스 변수
		rep.setPost_num(post_num);
		rep.setId(replyWriterId);
		rep.setNick(replyWriterNick);
		rep.setContent(content);
		
		boolean result = replyDAO.insertReply(rep);
		
		
		// 댓글 작성 성공 -> 알람 보내기
		if (result) {
			noti_dao notiDAO = noti_dao.getInstance();
			notiDAO.setConnection(conn);
			
			notiDAO.insertNoti(replyWriterId, postWriterId, 2, post_num);
		}
		
		return String.format("read.post?part=postDetail&pageNum=%d#", post_num);
	}
}
