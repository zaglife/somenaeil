package com.noti;

import static com.common.DBUtil.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedList;

import com.member.member_dao;

public class noti_dao {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private static noti_dao instance;
	
	public noti_dao(){}
	
	/**
	 * 싱글턴 패턴
	 * @return
	 */
	public static noti_dao getInstance() {
		if (instance == null)
			instance = new noti_dao();
		return instance;
	}
	
	public void setConnection(Connection conn) {
		this.conn = conn;
	}
	
	
	/**
	 * 해당 유저 알람 DB에 보내기 (INSERT)
	 * @author gagip
	 * @param fromId 보내는 유저 id
	 * @param toId 받는 유저 id
	 * @param type 알람 타입 (1:팔로우; 2:댓글; 3:좋아요; 4:스크랩, 5:dm)
	 */
	public void insertNoti(String fromId, String toId, int type) {
		String sql = "INSERT INTO noti_"+toId+"(num, other_id, noti_type, time) "
					+ "VALUES(?,?,?,sysdate)";
		
		// 자기자신한테 알람 X
		if (fromId.equals(toId)) return;
		
		// 중복된 값이 존재하나 체크 (dm 예외)
		if (checkDuplicate(fromId, toId, type) && type != 5) return;
		
		try {
			conn.setAutoCommit(false);
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, getNum("noti_"+toId, conn));
			pstmt.setString(2, fromId);
			pstmt.setInt(3, type);
			
			if (pstmt.executeUpdate() > 0) {
				commit(conn);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		close(pstmt);
	}
	
	
	/**
	 * 해당 유저 알람 DB에 보내기 (INSERT)
	 * @author gagip
	 * @param fromId 보내는 유저 id
	 * @param toId 받는 유저 id
	 * @param type 알람 타입 (1:팔로우; 2:댓글; 3:좋아요; 4:스크랩)
	 * @param postNum 댓글, 좋아요, 스크랩의 대상 게시글 번호
	 */
	public void insertNoti(String fromId, String toId, int type, int postNum) {
		String sql = "INSERT INTO noti_"+toId+"(num, other_id, noti_type, time, post_num) "
					+ "VALUES(?,?,?,sysdate,?)";
		
		// 자기자신한테 알람 X
		if (fromId.equals(toId)) return;
		
		// 중복된 값이 존재하는지 체크
		if (checkDuplicate(fromId, toId, type, postNum)) return;
		
		try {
			conn.setAutoCommit(false);
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, getNum("noti_"+toId, conn));
			pstmt.setString(2, fromId);
			pstmt.setInt(3, type);
			pstmt.setInt(4, postNum);
			
			if (pstmt.executeUpdate() > 0) {
				commit(conn);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		close(pstmt);
	}
	
	
	/**
	 * 유저 알람 DB에 들어간다 (SELECT)
	 * @author gagip
	 * @param id 알람 DB의 대상인 유저 id
	 * @return 해당 유저의 noti 리스트
	 */
	public ArrayList<noti> selectNotiList(String id) {
		String sql = "SELECT * FROM noti_"+id+" WHERE noti_view='0'"
					+ "ORDER BY num DESC";
		
		ArrayList<noti> notiList = new ArrayList<noti>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				noti noti = new noti();
				noti.setNum(rs.getInt("num"));
				noti.setOtherId(rs.getString("other_id"));
				noti.setTime(rs.getDate("time"));
				noti.setType(rs.getInt("noti_type"));
				noti.setPostNum(rs.getInt("post_num"));
				
				notiList.add(noti);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		close(rs);
		close(pstmt);
		return notiList;
	}
	
	
	/**
	 * 알람을 확인했음을 DB에 업데이트
	 * @author gagip
	 * @param id 유저 id
	 * @param num 유저 noti DB의 인덱스
	 */
	public void updateNoti(String id, int num) {
		String sql = "UPDATE noti_+"+id+" SET noti_view='1' WHERE num=?";
		
		try {
			conn.setAutoCommit(false);
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			if (pstmt.executeUpdate() > 0)
				commit(conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		close(pstmt);
	}
	
	
	/**
	 * 중복된 값이 있나 체크
	 * @param id 해당 유저 id
	 * @param otherId 다른 유저 id
	 * @param type 알림 타입
	 * @return true:중복 행 존재
	 */
	private boolean checkDuplicate(String id, String otherId, int type) {
		String sql = "SELECT * FROM "
					+ "		(SELECT other_id, noti_type, post_num FROM noti_"+id
					+ "		GROUP BY other_id, noti_type, post_num ) p"
					+ "WHERE p.other_id=? AND p.noti_type=?";
		
		// 양쪽 id 값이 존재해야 한다
		if (id == null || otherId == null) return false;
		
		boolean check = false;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, otherId);
			pstmt.setInt(2, type);
			rs = pstmt.executeQuery();
			
			// 중복된 값이 있으면 
			if (rs.next())
				check = true;
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		close(rs);
		close(pstmt);
		return check;
	}
	
	
	/**
	 * 중복된 값이 있나 체크
	 * @param id 해당 유저 id
	 * @param otherId 다른 유저 id
	 * @param type 알림 타입
	 * @param postNum 게시글 번호
	 * @return true:중복 행 존재
	 */
	private boolean checkDuplicate(String id, String otherId, int type, int postNum) {
		String sql = "SELECT * FROM "
					+ "		(SELECT other_id, noti_type, post_num FROM noti_"+id
					+ "		GROUP BY other_id, noti_type, post_num ) p "
					+ "WHERE p.other_id=? AND p.noti_type=? AND p.post_num=?";
		
		// 양쪽 id 값이 존재해야 한다
		if (id == null || otherId == null) return false;
		
		boolean check = false;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, otherId);
			pstmt.setInt(2, type);
			pstmt.setInt(3, postNum);
			rs = pstmt.executeQuery();
			
			// 중복된 값이 있으면 
			if (rs.next())
				check = true;
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		close(rs);
		close(pstmt);
		return check;
	}
}
