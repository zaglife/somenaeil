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
	 * @param optList 검색 옵션들 <String:검색옵션, Object:검색조건>
	 */
	public ArrayList<post> getPostList(HashMap<String, Object> optList) {
		String opt = (String)optList.get("opt");				// 검색 옵션
        String condition = (String)optList.get("condition");	// 검색 조건
		
		ArrayList<post> postList = new ArrayList<post>();
		
		try {
			
			// 검색 옵션 설정 X
			if (opt == null) {
				String sql =  "SELECT ROWNUM as rnum, data.* FROM "	// rnum을 포함한 data를 가지고 와라
							+ "		(SELECT * FROM post "			// num 내림차순으로 정렬된 데이터를 data라고 하자
							+ "			ORDER BY num DESC) data ";
				
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
			}
			// 제목으로 검색
			else if (opt.equals("sTitle")) {
				
			}
			// 내용으로 검색
			else if (opt.equals("sContext")) {	
				
			}
			// 해시태그로 검색
			else if (opt.equals("sHash")) {
				
			}
			// 글쓴이로 검색
			else if (opt.equals("sNick")) {
				
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
	
	
	
	public void add() {
		String sql = "insert into post ";
		
	}
}
