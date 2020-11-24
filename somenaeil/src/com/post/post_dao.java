package com.post;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;


/**
 * SQL DB에 연결하여 저장 및 추출
 * @author gagip
 *
 */
public class post_dao {
	private Connection conn;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public post_dao(){
		try {
			conn=DriverManager.getConnection("jdbc:apache:commons:dbcp:somenaeil");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("post DB 커넥션 실패");
		}
	}

	
	// 승재: 저장하기
	
	/**
	 * 게시글 번호로 해당 게시글 DB 호출
	 * @author gagip
	 * @param num 게시글 번호
	 */
	@SuppressWarnings({ "resource" })
	public post getPost(int num) {
		String sql = "SELECT *"
					+ "FROM post "
					+ "WHERE num=?";
		post pt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				pt = new post(rs.getInt("num"), rs.getString("cate"), rs.getString("nick"),
							rs.getDate("time"), rs.getString("title"), rs.getString("context"),
							rs.getString("hash"));
				// 부가적인 정보 추가
				pt.setLike_cnt(rs.getInt("like_cnt"));
				pt.setScrap_cnt(rs.getInt("scrap_cnt"));
				pt.setView_cnt(rs.getInt("view_cnt"));
			}
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		close();
		return pt;
	}
	
	
	// TODO post List 호출
	
	/**
	 * 검색결과에 따른 post List 호출
	 * @param cate 게시글 카테고리 (G, R, Q)
	 * @param condition 검색 키워드
	 */
	public ArrayList<post> getPostList(String cate, String condition) {
		cate = cate != null ? cate : "";
		
		ArrayList<post> postList = new ArrayList<post>();
		
		try {
			
			// 검색 키워드 존재하지 않으므로 전체 리스트 보여주기
			if (condition == null) {
				String sql =  "SELECT ROWNUM as rnum, data.* FROM "	// rnum을 포함한 data를 가지고 와라
							+ "		(SELECT * FROM post "			// num 내림차순으로 정렬된 데이터를 data라고 하자
							+ "			ORDER BY num DESC) data "
							+ "WHERE cate LIKE ?";					// 게시글 카테고리
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "%"+cate+"%");
				rs = pstmt.executeQuery();
			}
			// 검색 키워드 존재
			else {
				String sql =  "SELECT ROWNUM as rnum, data.* FROM "	// rnum을 포함한 data를 가지고 와라
						+ "		(SELECT * FROM post "
						+ "			WHERE cate LIKE ? "
						+ "			AND (title LIKE ? "
						+ "				OR context LIKE ? "
						+ "				OR hash LIKE ?)"			
						+ "			ORDER BY num DESC) data ";		// 검색에 만족하는 데이터를 data라고 하자
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "%"+cate+"%");
				pstmt.setString(2, "%"+condition+"%");
				pstmt.setString(3, "%"+condition+"%");
				pstmt.setString(4, "%"+condition+"%");
				rs = pstmt.executeQuery();
			}
			// DB 결과를 post에 넣은 뒤, list에 추가
			while (rs.next()) {
				post pt = new post();
				pt.setNum(rs.getInt("num"));
				pt.setCate(rs.getString("cate"));
				pt.setNick(rs.getString("nick"));
				pt.setTime(rs.getDate("time"));
				pt.setTitle(rs.getString("title"));
				pt.setContext(rs.getString("context"));
				pt.setHash(rs.getString("hash"));
				
				postList.add(pt);
			}
		} catch (Exception e) {
			System.out.println("게시글 리스트 호출 실패");
			e.printStackTrace();
		}
		close();
		return postList;
	}
	
	
	// TODO post 방문조회수 늘리기
	
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
	
	
	// post DB에 연결 작업
	public void add(String writer, String title, String cate, String content, String hash) {
		String sql = "insert into post(num, cate, nick, view_cnt, scrap_cnt, time, hash, title, context, like_cnt) values(?,?,?,?,?,sysdate,?,?,?,?)";
		System.out.println(sql);
		try(PreparedStatement pt = conn.prepareStatement(sql)){
			pt.setInt(1, mytag.db_lib.get_num("post", conn));
			pt.setString(2, cate);
			pt.setString(3, writer);
			pt.setInt(4, 0);
			pt.setInt(5, 0);			
			pt.setString(6,hash);
			pt.setString(7,title);
			pt.setString(8,content);
			pt.setInt(9,0);
			pt.executeUpdate();
			System.out.println("저장성공");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("글쓰기 DB저장 오류");
		}
	}
	
	
	// vote DB에 연결작업 
	public void voteadd() {
		
	}
	
}
