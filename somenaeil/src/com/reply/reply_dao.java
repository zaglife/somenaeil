package com.reply;

import static com.common.DBUtil.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.post.post_dao;

/**
 * reply DB와 연결하는 클래스
 * @author gagip
 */
public class reply_dao {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private static reply_dao instance;
	
	public reply_dao() {}
	
	/**
	 * 싱글턴 패턴
	 * @return
	 */
	public static reply_dao getInstance() {
		if (instance == null)
			instance = new reply_dao();
		return instance;
	}
	
	public void setConnection(Connection conn) {
		this.conn = conn;
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
			pstmt.setInt(1, getNum("reply", conn));
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
		
		close(pstmt);
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
		
		close(rs);
		close(pstmt);
		return list;
	}
}
