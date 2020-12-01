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
	
	
	public void insertNoti(String fromId, String toId, int type) {
		String sql = "INSERT INTO noti_"+toId+"(num, other_id, noti_type, time) "
					+ "VALUES(?,?,?,sysdate)";
		
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
	
	public void insertNoti(String fromId, String toId, int type, int postNum) {
		String sql = "INSERT INTO noti_"+toId+"(num, other_id, noti_type, time, post_num) "
					+ "VALUES(?,?,?,sysdate,?)";
		
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
	}
	
	/**
	 * 중복 제거
	 */
}
