package com.member;

import static com.common.DBUtil.close;
import static com.common.DBUtil.getConnection;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class login_service {
	private  HttpServletRequest request;
	
	public login_service(HttpServletRequest request) {
		this.request= request;
	}
	
	
	/**
	 * 로그인 처리
	 * @author gagip(수정)
	 * @return
	 */
	public String login() {
		HttpSession session = request.getSession();
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		// conn를 DAO에 연결
		Connection conn = getConnection();
		member_dao md = member_dao.getInstance();
		md.setConnection(conn);

		String result = null;
		
		int loginCheck = md.checkLogin(id, pw);	
		// 로그인 성공
		if (loginCheck == 1) {
			member sessionUesr = md.selectMember(id);
			
			session.setAttribute("sessionUser", sessionUesr);
			session.setAttribute("sessionId", sessionUesr.getId());
		}
		// 비밀번호 불일치
		else if (loginCheck == 0) {
			request.setAttribute("fail", "0");
			
			result = "login.jsp";
		}
		// 존재하지 않는 아이디 (-1)
		else {
			request.setAttribute("fail", "-1");
			
			result = "login.jsp";
		}
		
		close(conn);
		return result;
	}
	
	
	/**
	 * 로그인 세션 삭제
	 * @author gagip
	 * @return
	 */
	public String logout() {
		request.getSession().removeAttribute("sessionUser");
		request.getSession().removeAttribute("sessionId");
		
		return null;
	}
}
