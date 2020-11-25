package com.reply;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * reply DB와 연결하는 클래스
 * @author gagip
 */
public class reply_dao {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public reply_dao(){
		try {
			conn=DriverManager.getConnection("jdbc:apache:commons:dbcp:somenaeil");
		} catch(SQLException e){
			e.printStackTrace();
			System.out.println("member_dao - member DB 커넥션 실패");
		}
	} 
	
	/**
	 * 시퀀스 가져오기
	 * @author gagip
	 */
	public int getSeq() {
		int result = 1;
		
		try {
			String sql = "SELECT reply_seq.NEXTVAL FROM DUAL";
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if (rs.next()) result = rs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		close();
		return result;
	}
	
	
	/**
	 * 댓글 삽입
	 * @author gagip
	 * @param rep 작성할 댓글 Bean
	 * @return 커밋 성공시 true 반환
	 */
	public boolean insertReply(reply rep) {
		boolean result = false;
		
		try {
			// 자동 커밋 off
			conn.setAutoCommit(false);
			
			String sql = "INSERT INTO reply"
						+ "		(num, post_num, author, time, parent, context)"
						+ "		VALUES(?,?,?,sysdate,?,?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rep.getNum());
			pstmt.setInt(2, rep.getPost_num());
			pstmt.setString(3, rep.getAuthor());
			pstmt.setInt(4, rep.getParent());
			pstmt.setString(5, rep.getContext());
			
			// 완료시 커밋
			if (pstmt.executeUpdate() > 0) {
				result = true;
				conn.commit();
			}
		} catch (Exception e) {
			try {
				conn.rollback(); // 롤백
			} catch (SQLException sqle) {
				sqle.printStackTrace();
			}
			e.printStackTrace();
			System.out.println("댓글 작성 오류");
		}
		
		close();
		return result;
	}
	
	
	/**
	 * 해당 게시글에 있는 댓글 리스트 가져오기
	 * @author gagip
	 * @param post_num	댓글들을 가져올 게시글 번호
	 * @return reply DB에서 가져온 댓글 리스트
	 */
	public ArrayList<reply> getReplyList(int post_num) {
		ArrayList<reply> list = new ArrayList<reply>();
		
		try {
			String sql = "SELECT LEVEL, num, post_num, author, time, parent, context "
						+ "FROM reply "
						+ "WHERE post_num=? "
						+ "START WITH parent=0 "
						+ "CONNECT BY PRIOR num=parent";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, post_num);
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				reply rep = new reply();
				rep.setLevel(rs.getInt("LEVEL"));
				rep.setNum(rs.getInt("num"));
				rep.setPost_num(rs.getInt("post_num"));
				rep.setAuthor(rs.getString("author"));
				rep.setTime(rs.getDate("time"));
				rep.setParent(rs.getInt("parent"));
				rep.setContext(rs.getString("context"));
				list.add(rep);
			}
			
		} catch (Exception e) {
				e.printStackTrace();
			}
		
		close();
		return list;
	}
	
	
	/**
	 * DB에 사용한 자원 메모리 해제
	 * @author gagip
	 */
	private void close() {
		try {
			if (rs != null) { rs.close(); rs = null; }
			if (pstmt != null) { pstmt.close(); pstmt = null; }
		} catch (Exception e) {
			System.out.println("메모리 해제 오류");
			e.printStackTrace();
		}
	}
}
