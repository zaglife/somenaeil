package com.post;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import com.member.member;
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
		String path = request.getServletContext().getRealPath("/user_img");
		int size = 10*1024*1024;
		String post_title = null;
		String post_cate = null;
		String[] post_temp = null;
		String post_hash = "";
		String post_content = null;
		String post_context = null;
		String[] fname = new String[5];
		String[] org = new String[5];
		
		
		
		
		String vote_title = null;
		String[] vote_temp = null;
		String vote_items = "";
		int vote_muit = 0;
		int vote_hidden = 0;
		int vote_stat = 0;
		int vote_date = 0;
		String vote_day = null;
		String[] vote_temp2 = null;
		String vote_chk = null;
		
		
		
		
		try {
			MultipartRequest multi = new MultipartRequest(request, path, size, "UTF-8", new DefaultFileRenamePolicy());
			
			post_title = multi.getParameter("title");
			post_cate = multi.getParameter("cate_btn");
			post_content = multi.getParameter("content");
			post_temp = multi.getParameterValues("hash");
			
			if(post_temp != null) {
				for(int i = 0; i < post_temp.length; i++) {
					post_hash += post_temp[i] +",";
				}
				post_hash += post_temp[post_temp.length-1];
			}
			post_context = multi.getParameter("context");
			
			Enumeration em = multi.getFileNames();
			int k = 0;
			while(em.hasMoreElements()) {
				String file = (String)em.nextElement();
				fname[k++] = multi.getFilesystemName(file);
				
			}
			
			vote_chk = multi.getParameter("vote");
			if(vote_chk.equals("use")) {
				vote_title = multi.getParameter("title");
				vote_temp = multi.getParameterValues("items");
				
				if(vote_temp != null) {
					for(int i = 0; i < vote_temp.length; i++) {
						vote_items += vote_temp[i] +",";
					}
					vote_items += vote_temp[vote_temp.length-1];
				}
				vote_temp2 = multi.getParameterValues("choice");
				if(vote_temp2 != null) {
					for(int i = 0; i < vote_temp2.length; i++) {
						if(vote_temp2[i].equals("muit")) 
							vote_muit = 1;
						else if(vote_temp2[i].equals("hidden")) {
							vote_hidden = 1;				
						}else if(vote_temp2[i].equals("stat"))
							vote_stat = 1;
						else if(vote_temp2[i].equals("date")) {
							vote_date = 1;
							vote_day = multi.getParameter("day");
						}
					}
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("이미지 저장 실패");
		}
		
		
		String filename = fname[0] + "," + fname[1] + "," + fname[2] + "," + fname[3] + "," + fname[4];
		
		post_dao pd = new post_dao();
		pd.add(writer, post_title, post_cate, post_context, post_hash, filename);
		
		if(vote_chk.equals("use")) {
			vote_dao vd = new vote_dao();
			vd.add(writer, vote_title, vote_items, vote_muit, vote_stat, vote_hidden, vote_date, vote_day);
		
		}					
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
