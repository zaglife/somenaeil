package com.post;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

/**
 * SQL DB에 연결하여 저장 및 추출
 * @author gagip
 *
 */
public class post_dao {
	private Connection conn;
	public post_dao(){
		try {
			conn=DriverManager.getConnection("jdbc:apache:commons:dbcp:somenaeil");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("post DB 커넥션 실패");
		}
	}
	
	// 승재: 저장하기
	
	// 찬우: 추출
	/**
	 * 게시글 번호로 해당 게시글 DB 호출
	 * @param num 게시글 번호
	 */
	@SuppressWarnings({ "resource" })
	public post select(int num) {
		String sql = "SELECT num, cate, nick, time, title, hash "
					+ "FROM post "
					+ "WHERE num=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		post pt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				pt = new post(rs.getInt("num"), rs.getString("cate"), rs.getString("nick"),
							rs.getDate("time"), rs.getString("title"), rs.getString("hash"));
				
				// SELECT post detail DB SQL  
				String sql2 = "SELECT position, type, context "
							+ "FROM post_detail "
							+ "WHERE post_num=?"
							+ "ORDER BY position ASC";
				pstmt = conn.prepareStatement(sql2);
				pstmt.setInt(1, pt.getNum());
				rs = pstmt.executeQuery();
				
				// post detail DB를 post 객체에 추가
				ArrayList<Integer> position = new ArrayList<Integer>();
				ArrayList<Integer> type = new ArrayList<Integer>();
				ArrayList<String> context = new ArrayList<String>();
				while(rs.next()) {
					position.add(rs.getInt("position"));
					type.add(rs.getInt("type"));
					context.add(rs.getString("context"));
				}
				pt.setPostContent(position, type, context);
			}
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		// 메모리 종료
		finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return pt;
	}
}
