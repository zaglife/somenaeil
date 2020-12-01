package com.noti;

import static com.common.DBUtil.*;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

public class noti_service {
	private HttpServletRequest request;
	
	public noti_service(HttpServletRequest request) {
		this.request=request;
	}
	
	
	/**
	 * 알람을 보낸다
	 */
	public void sendNoti() {
		String id = (String) request.getSession().getAttribute("sessionId");
		String targetId = request.getParameter("targetId");
		int type = Integer.parseInt(request.getParameter("type"));
		String postNum = request.getParameter("postNum");						// null 체크를 위해 일단 String으로 둠
		
		Connection conn = getConnection();
		noti_dao notiDAO = noti_dao.getInstance();
		notiDAO.setConnection(conn);
		
		if (postNum == null)
			notiDAO.insertNoti(id, targetId, type);
		else {
			notiDAO.insertNoti(id, targetId, type, Integer.parseInt(postNum));
		}
	}
	
	public String getNotiList() {
		String id = (String) request.getSession().getAttribute("sessionId");
		
		if (id == null) {
			request.setAttribute("fail", -1);
			return null;
		}
		
		ArrayList<noti> notiList = new ArrayList<noti>();
		
		Connection conn = getConnection();
		noti_dao notiDAO = noti_dao.getInstance();
		notiDAO.setConnection(conn);
		
		notiList = notiDAO.selectNotiList(id);
		
		request.setAttribute("notiList", notiList);
		
		return "noti.jsp";
	}
}
