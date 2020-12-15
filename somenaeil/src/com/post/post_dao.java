package com.post;

import static com.common.DBUtil.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.member.member_dao;



// TODO post 스크랩 활성화
// TODO post 방문조회수, 좋아요 늘리기

/**
 * SQL DB에 연결하여 저장 및 추출
 * @author gagip
 */
public class post_dao {
	private Connection conn;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	private static post_dao instance;
	
	public post_dao() {
		try {
			conn = DriverManager.getConnection("jdbc:apache:commons:dbcp:some");
		} catch(SQLException e){
			e.printStackTrace();
			System.out.println("post_dao - post DB 커넥션 실패");
		}
	}

	/**
	 * 싱글턴 패턴
	 * @author gagip
	 * @return
	 */
	public static post_dao getInstance() {
		if (instance == null)
			instance = new post_dao();
		return instance;
	}
	
	public void setConnection(Connection conn) {
		this.conn = conn;
	}
	
	
	/**
	 * 게시글 번호로 해당 게시글 DB 호출 (SELECT)
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
				pt = new post();
				// 부가적인 정보 추가
				pt.setNum(rs.getInt("num"));
				pt.setId(rs.getString("id"));
				pt.setNick(rs.getString("nick"));
				pt.setCate(rs.getString("cate"));
				pt.setTime(rs.getDate("time"));
				pt.setTitle(rs.getString("title"));
				pt.setContent(rs.getString("content"));
				pt.setHash(rs.getString("hash"));
				pt.setView_cnt(rs.getInt("view_cnt"));
				pt.setScrap_cnt(rs.getInt("scrap_cnt"));
				pt.setLike_cnt(rs.getInt("like_cnt"));
			}
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		close(rs);
		close(pstmt);
		return pt;
	}
	
	
	/**
	 * 해당 유저가 쓴 게시글 다 불러오기 (SELECT)
	 * @author gagip
	 * @param userId 유저 아이디
	 * @return
	 */
	public ArrayList<post> getPostList(String userId) {
		String sql = "SELECT * FROM post WHERE id=?"
					+ "ORDER BY num DESC";
		
		ArrayList<post> userPostList = new ArrayList<post>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				post post = new post();
				// 부가적인 정보 추가
				post.setNum(rs.getInt("num"));
				post.setId(rs.getString("id"));
				post.setNick(rs.getString("nick"));
				post.setCate(rs.getString("cate"));
				post.setTime(rs.getDate("time"));
				post.setTitle(rs.getString("title"));
				post.setContent(rs.getString("content"));
				post.setHash(rs.getString("hash"));
				post.setLike_cnt(rs.getInt("like_cnt"));
				post.setScrap_cnt(rs.getInt("scrap_cnt"));
				post.setView_cnt(rs.getInt("view_cnt"));
				
				userPostList.add(post);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		close(rs);
		close(pstmt);
		return userPostList;
	}
	
	/**
	 * 검색결과에 따른 post List 호출
	 * @author gagip
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
						+ "				OR content LIKE ? "
						+ "				OR hash LIKE ?)"			
						+ "			ORDER BY num DESC) data ";		// 검색에 만족하는 데이터를 data라고 하자
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "%"+cate+"%");
				pstmt.setString(2, "%"+condition+"%");
				pstmt.setString(3, "%"+condition+"%");
				pstmt.setString(4, "%"+condition+"%");
				rs = pstmt.executeQuery();
			}
			// TODO 유저 검색
			// DB 결과를 post에 넣은 뒤, list에 추가
			while (rs.next()) {
				post post = new post();
				post.setNum(rs.getInt("num"));
				post.setId(rs.getString("id"));
				post.setNick(rs.getString("nick"));
				post.setCate(rs.getString("cate"));
				post.setTime(rs.getDate("time"));
				post.setTitle(rs.getString("title"));
				post.setContent(rs.getString("content"));
				post.setHash(rs.getString("hash"));
				post.setLike_cnt(rs.getInt("like_cnt"));
				post.setScrap_cnt(rs.getInt("scrap_cnt"));
				post.setView_cnt(rs.getInt("view_cnt"));
				postList.add(post);
			}
		} catch (Exception e) {
			System.out.println("게시글 리스트 호출 실패");
			e.printStackTrace();
		}
		
		close(rs);
		close(pstmt);
		return postList;
	}
	
	
	// post DB에 연결 작업
	public void add(	String id,
						String nick,
						String cate,
						String title,
						String content,
						String hash) {
		String sql = "insert into post(";
		sql+= "num, id, nick, cate, title, content, hash, ";
		sql+= "view_cnt, scrap_cnt, like_cnt) ";
		sql+= "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try(PreparedStatement pt = conn.prepareStatement(sql)){
			pt.setInt(1, getNum("post", conn));
			pt.setString(2, id);
			pt.setString(3, nick);
			pt.setString(4, cate);
			pt.setString(5, title);
			pt.setString(6, content);
			pt.setString(7, hash);
			pt.setInt(8, 0);
			pt.setInt(9, 0);
			pt.setInt(10, 0);
			pt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("글쓰기 DB저장 오류");
		}
	}
	
	
	/**
	 * 조회수 증가
	 * @author gagip
	 * @param postNum 게시글번호
	 * @return
	 */
    public boolean updateViewCount(int postNum) {
    	String sql = "UPDATE post SET view_cnt=view_cnt+1 "
    				+ "WHERE num=?";
    	
        boolean result = false;
        
        try {
            // 자동 커밋을 false로 한다.
            conn.setAutoCommit(false);
            
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, postNum);
            
            int flag = pstmt.executeUpdate();
            if(flag > 0){
                result = true;
                conn.commit(); // 완료시 커밋
            }    
        } catch (Exception e) {
            try {
                conn.rollback(); // 오류시 롤백
            } catch (SQLException sqle) {
                sqle.printStackTrace();
            }
            throw new RuntimeException(e.getMessage());
        }
        
        close(pstmt);
        return result;
    }
    
    
    /**
     * 좋아요 수 증가
     * @author gagip
     * @param postNum
     * @return
     */
    public boolean updateLikeCount(int postNum) {
    	String sql = "UPDATE post SET like_cnt=like_cnt+1 "
    				+ "WHERE num=?";
    	
        boolean result = false;
        
        try {
            // 자동 커밋을 false로 한다.
            conn.setAutoCommit(false);
            
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, postNum);
            
            int flag = pstmt.executeUpdate();
            if(flag > 0){
                result = true;
                conn.commit(); // 완료시 커밋
            }    
        } catch (Exception e) {
            try {
                conn.rollback(); // 오류시 롤백
            } catch (SQLException sqle) {
                sqle.printStackTrace();
            }
            throw new RuntimeException(e.getMessage());
        }
        
        close(pstmt);
        return result;
    }
    
    
    /**
     * 스크랩 수 증가
     * @author gagip
     * @param postNum
     * @return
     */
    public boolean updateScrapCount(int postNum) {
    	String sql = "UPDATE post SET scrap_cnt=scrap_cnt+1 "
    				+ "WHERE num=?";
    	
        boolean result = false;
        
        try {
            // 자동 커밋을 false로 한다.
            conn.setAutoCommit(false);
            
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, postNum);
            
            int flag = pstmt.executeUpdate();
            if(flag > 0){
                result = true;
                conn.commit(); // 완료시 커밋
            }    
        } catch (Exception e) {
            try {
                conn.rollback(); // 오류시 롤백
            } catch (SQLException sqle) {
                sqle.printStackTrace();
            }
            throw new RuntimeException(e.getMessage());
        }
        
        close(pstmt);
        return result;
    }
}
