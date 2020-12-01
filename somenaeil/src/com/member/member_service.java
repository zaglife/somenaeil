package com.member;


import static com.common.DBUtil.*;

import java.net.URLDecoder;
import java.sql.Connection;
import java.util.ArrayList;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.noti.noti_dao;
import com.post.post;
import com.post.post_dao;

public class member_service {
	private  HttpServletRequest request;

	public member_service(HttpServletRequest request) { 
		this.request= request;
	}
	
	public String login() {
		HttpSession session = request.getSession();
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		// conn 연결 후 해당 연결
		Connection conn = getConnection();
		member_dao md = member_dao.getInstance();
		md.setConnection(conn);

		int loginCheck = md.checkLogin(id, pw);	
		String result = null;
		
		// 로그인 성공
		if (loginCheck == 1) {
			member sessionUesr = md.selectMember(id);
			
			session.setAttribute("sessionUser", sessionUesr);
			session.setAttribute("sessionId", sessionUesr.getId());
		}
		else if (loginCheck == 0) {
			request.setAttribute("fail", "0");
			
			result = "login.jsp";
		}
		else {
			request.setAttribute("fail", "-1");
			
			result = "login.jsp";
		}
		
		
		close(conn);
		return result;
	}
	
	/**
	 * 로그인 세션 삭제
	 * @return
	 */
	public String logout() {
		request.getSession().removeAttribute("sessionUser");
		request.getSession().removeAttribute("sessionId");
		
		return null;
	}
	
	public String join() {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String nick = request.getParameter("nick");
		String email = request.getParameter("email");
		String addr = request.getParameter("addr");
		int cert = Integer.parseInt(request.getParameter("cert"));
		String pimg= request.getParameter("pimg");
		String comt= request.getParameter("comt");
		
		// 이메일 주소 뒷부분 추가
		email+= "@"+addr;
		// 회원가입 테스트를 위한 이메일 인증
		cert= 1;
		
		// DB 세팅
		Connection conn = getConnection();
		member_dao md = member_dao.getInstance();
		md.setConnection(conn);
		
		// 회원가입
		md.insertMember(id, pw, name, nick, email, cert, pimg, comt);
				
		close(conn);
		return "login.jsp";
	}
	
	public String user() {
		
		String userId = request.getParameter("userId");
		String sessionId = (String) request.getSession().getAttribute("sessionId");
		String cate = request.getParameter("cate");
		
		member user = null;
		ArrayList<member> followList = null;
		ArrayList<member> followerList = null;
		ArrayList<post> postList = null;
		String isFollow = null;
		
		Connection conn = getConnection();
		member_dao memberDAO = member_dao.getInstance();
		memberDAO.setConnection(conn);
		// 해당 유저가 쓴 포스트도 가져온다
		post_dao postDAO = post_dao.getInstance();
		postDAO.setConnection(conn);
		
		user = memberDAO.selectMember(userId);
		if (user != null) {
			String follow = user.getFollow();
			String follower = user.getFollower();
			
			// 팔로우 리스트 추출
			if (follow != null)
				followList = memberDAO.selectMemberList(follow.split(":"));
			// 팔로워 리스트 추출
			if (follower != null)
				followerList = memberDAO.selectMemberList(follower.split(":"));
			
			isFollow = memberDAO.isFollow(sessionId, userId);
			
			// 포스트 리스트 추출
			postList = postDAO.getPostList(userId);
			
			if (cate != null)
				postList = (ArrayList<post>) postList.stream()
										.filter(x -> x.getCate().equals(cate))
										.collect(Collectors.toList());
		}
		
		request.setAttribute("user", user);
		request.setAttribute("followList", followList);
		request.setAttribute("followerList", followerList);
		request.setAttribute("postList", postList);
		request.setAttribute("isFollow", isFollow);
		
		close(conn);
		return String.format("user.jsp?part=user&userId=%s", userId);
	}
	
	public boolean update() {
		String id = request.getParameter("id");
		String pw = request.getParameter("newPw");
		String nick = request.getParameter("nick");
		String email = request.getParameter("email");
		email += "@"+request.getParameter("addr");
		int cert = Integer.parseInt(request.getParameter("cert"));
		String pimg = request.getParameter("pimg");
		String comt = request.getParameter("comt");
		
		boolean pwCheck = false;
		boolean updateCheck = false;
		
		Connection conn = getConnection();
		member_dao memberDAO = member_dao.getInstance();
		memberDAO.setConnection(conn);
		
		// DB 업데이트
		if (pw != "")
			pwCheck = memberDAO.updateMember(id, pw);
		updateCheck = memberDAO.updateMember(id, nick, email, cert, pimg, comt);
		
		// 업데이트 후 user 객체를 업데이트하기 위해 새로 로드
		member user = memberDAO.selectMember(id);
		
		if (updateCheck) {
			request.getSession().setAttribute("user", user);	// 새로 갱신
		}
		else {
			request.setAttribute("fail", -1);
		}

		close(conn);
		return updateCheck;
	}
	
	
	public void follow() {
		String userId = request.getParameter("userId");
		String targetId = request.getParameter("targetId");
		
		Connection conn = getConnection();
		member_dao memberDAO = member_dao.getInstance();
		memberDAO.setConnection(conn);
		noti_dao notiDAO = noti_dao.getInstance();
		notiDAO.setConnection(conn);
		
		
		String userFollow = memberDAO.selectMember(userId).getFollow();
		String targetFollower = memberDAO.selectMember(targetId).getFollower();
		
		// my와 target의 관계
		String isFollow = memberDAO.isFollow(userId, targetId);
		// my와 target와 관계 업데이트
		boolean check = memberDAO.updateFollow(userId, targetId, 
							userFollow, targetFollower, isFollow);
		
		
		if (!check)
			request.setAttribute("fail", -1);
		else
			notiDAO.insertNoti(userId, targetId, 1);
		
		close(conn);
	}
}