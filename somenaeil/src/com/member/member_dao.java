package com.member;

import static com.common.DBUtil.*;

import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import com.cs.cs;
import com.dm.dm;
import com.noti.noti;

// TODO member delete (회원탈퇴)

public class member_dao {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private static member_dao instance;
	
	public member_dao(){
		try {
			conn = DriverManager.getConnection("jdbc:apache:commons:dbcp:somenaeil");
		} catch(SQLException e){
			e.printStackTrace();
			System.out.println("member_dao - member DB 커넥션 실패");
		}
	}
	
	/**
	 * 싱글턴 패턴
	 * @return
	 */
	public static member_dao getInstance() {
		if (instance == null)
			instance = new member_dao();
		return instance;
	}
	
	public void setConnection(Connection conn) {
		this.conn = conn;
	}
	
	/**
	 * 로그인 체크 여부
	 * @author gagip
	 * @param id 사용자 아이디
	 * @param pw 사용자 비밀번호
	 * @return 1:로그인성공, 0:비밀번호불일치, -1:존재하지않는아이디
	 */
	public int checkLogin(String id, String pw) {
		String sql = "SELECT pw FROM member WHERE id=?";
		
		String dbPW = null;			// DB에 있는 비밀번호
		int result = -1;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				dbPW = rs.getString(1);
				
				if(dbPW.equals(pw))
					result = 1;		// 아이디 & 비밀번호 일치
				else
					result = 0;		// 비밀번호 불일치
			}
			else {
				result = -1;		// 존재하지 않는 아이디
			}
		} catch (Exception e) {
			System.out.println("checkLogin 오류");
			e.printStackTrace();
		}
		
		close(rs);
		close(pstmt);
		return result;
	}
	
	/**
	 * Memeber DB에서 해당 유저 데이터 읽기 (SELECT)
	 * @author gagip(수정)
	 * @param id 아이디
	 * @return 해당 id를 가진 유저 데이터 리턴
	 */
	public member selectMember(String id) {
		String sql= "SELECT * FROM member WHERE id=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				member user= new member(
					rs.getString("id"),
					rs.getString("name"),
					rs.getString("nick"),
					rs.getString("email"),
					rs.getInt("cert"),
					rs.getString("pimg"),
					rs.getString("comt"),
					rs.getString("follow"),
					rs.getString("follower"),
					rs.getString("scrap_list"),
					rs.getString("like_list"));
				
				return user;
			}
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("member_dao - MEMBER 데이터 추출 실패");
		}
		
		close(rs);
		close(pstmt);
		return null;
	}
	
	
	/**
	 * Member DB 데이터 추가 (INSERT)
	 * @author gagip(수정)
	 * @param id 아이디
	 * @param pw 비밀번호
	 * @param name 이름
	 * @param nick 닉네임
	 * @param email 메일
	 * @param cert  인증
	 * @param pimg 프로필 이미지
	 * @param comt 한 줄 소개
	 */
	public void insertMember(String id, String pw, String name, String nick,
							String email, int cert, String pimg, String comt) {
		
		String sql= "INSERT INTO member(num, id, pw, name, nick, email, cert, pimg, comt) "
					+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			// 자동 커밋을 false로
			conn.setAutoCommit(false);
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, getNum("member", conn));
			pstmt.setString(2, id);
			pstmt.setString(3, pw);
			pstmt.setString(4, name);
			pstmt.setString(5, nick);
			pstmt.setString(6, email);
			pstmt.setInt(7, cert);
			pstmt.setString(8, pimg);
			pstmt.setString(9, comt);	

			// 쿼리 실행
			// 온전히 실행이 된 경우 
			if (pstmt.executeUpdate() > 0) {
				// 회원가입 후 noti, dm 테이블 입력
				createUserTable(id);
				
				// 최종 커밋
				commit(conn);
			}


			
		} catch (Exception e) {
			System.out.println("member_dao - 회원가입 sql 입력 실패");
			e.printStackTrace();
		} 
		
		close(pstmt);
	}
	
	
	/**
	 * Member 데이터 수정 (UPDATE)
	 * @author gagip(수정)
	 * @param id 아이디
	 * @param pw 비밀번호
	 * @param nick 닉네임
	 * @param email 이메일
	 * @param cert 인증
	 * @param pimg 프로필 사진
	 * @param comt 안줄
	 * @return
	 */
	public boolean updateMember(String id, String nick, String email, 
								int cert, String pimg, String comt) {
		String sql = "UPDATE member SET nick=?, email=?, cert=?, pimg=?, comt=? "
					+ "WHERE id=?";
		boolean result = false;
		
		try	{
			// 자동 커밋 off
			conn.setAutoCommit(false);
			
			// sql 값 매핑
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, nick);
			pstmt.setString(2, email);
			pstmt.setInt(3, cert);
			pstmt.setString(4, pimg);
			pstmt.setString(5, comt);
			pstmt.setString(6, id);
			
			if (pstmt.executeUpdate() > 0) {
				commit(conn);
				result = true;
			}
		} catch(SQLException e) {
			e.printStackTrace();
			System.out.println("member_dao - 회원정보수정 실패");
		}
		
		close(pstmt);
		return result;
	}


	public boolean updateMember(String id, String pw) {
		String sql = "UPDATE member SET pw=? "
				+ "WHERE id=?";
	boolean result = false;
	
	try	{
		// 자동 커밋 off
		conn.setAutoCommit(false);
		
		// sql 값 매핑
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, pw);
		pstmt.setString(2, id);
		
		if (pstmt.executeUpdate() > 0) {
			commit(conn);
			result = true;
		}
	} catch(SQLException e) {
		e.printStackTrace();
		System.out.println("member_dao - 회원정보수정 실패");
	}
	
	close(pstmt);
	return result;
	}
	
	/**
	 * 유저 이름을 가진 DB 생성 (CREATE)
	 * @author gagip(수정)
	 * @param id 고유한 이름의 db가 저장되어야 하므로 nick보단 id
	 */
	public void createUserTable(String id) {
		String sql = "CREATE TABLE noti_"+id+"("
					+ "num NUMBER(4) NOT NULL PRIMARY KEY,"
					+ "other_id VARCHAR2(20) NOT NULL,"
					+ "noti_type NUMBER(1) NOT NULL,"
					+ "time DATE DEFAULT SYSDATE,"
					+ "post_num NUMBER(6),"
					+ "noti_view CHAR(1) DEFAULT 0)";
				
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate(); 	// CREATE 구문에서는 -1을 반환
			
			// TODO 중복 예외 처리 (또는 js에서 조건 제한)
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("member_dao - 유저별 noti테이블 생성 실패");
		}
		
		close(pstmt);
	}
	
	
	/**
	 * id 리스트에 만족하는 MemberList 추출
	 * @author gagip(수정)
	 * @param idList id 리스트
	 * @return 해당 id를 가진 Member 리스트
	 */
	public ArrayList<member> selectMemberList(String[] idList) {
		ArrayList<member> memberList = new ArrayList<member>();
		
		// java에서 array를 DB에 보내기에 한계가 있기 때문에 스트림과 포맷팅을 이용
		String sql = String.format("SELECT * FROM member WHERE id IN (%s)", 
									Stream.of(idList)
									.map(x -> "'"+x+"'")					// x를 문자열('x')로 변환
									.collect(Collectors.joining(",")));		// 값들 사이에 반점(,)
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				member member = new member(
						rs.getString("id"),
						rs.getString("name"),
						rs.getString("nick"),
						rs.getString("email"),
						rs.getInt("cert"),
						rs.getString("pimg"),
						rs.getString("comt"),
						rs.getString("follow"),
						rs.getString("follower"),
						rs.getString("scrap_list"),
						rs.getString("like_list"));
				
				memberList.add(member);
			}
		} catch(SQLException e) {
			e.printStackTrace();
			System.out.println("member_dao - <팔로우 리스트> 다른 유저 정보 불러오기 실패");
		}
		
		close(rs);
		close(pstmt);
		return memberList;
	}
	
	
	/**
	 * 해당 유저와 어떤 관계인지 확인
	 * @author gagip
	 * @param myId 자신 아이디
	 * @param targetId 상대방 아이디
	 * @return
	 */
	public String isFollow(String myId, String targetId) {
		String sql = "SELECT follow, follower FROM member WHERE id=?";
		
		boolean follow = false;
		boolean follower = false;
		String result = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, myId);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				String followStr = rs.getString("follow");
				String followerStr = rs.getString("follower");
				
				// follow와 follower에 해당 유저의 아이디가 있는지 확인한다.
				if (followStr != null)
					follow = Arrays.stream(followStr.split(":"))
											.anyMatch(targetId::equals);
				else
					follow = false;
				
				if (followerStr != null)
					follower = Arrays.stream(followerStr.split(":"))
											.anyMatch(targetId::equals);
				else
					follower = false;
			}
			
			// 특정 분류에 따라 타겟과의 관계를 정의
			if (follow && follower) 		result = "follow4follow";
			else if (!follow && follower)	result = "follower";
			else if (follow && !follower) 	result = "follow";
			else							result = "unfollow";
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		close(rs);
		close(pstmt);
		return result;
	}
	
	/**
	 * follow 리스트 수정 (UPDATE)
	 * @author gagip(수정)
	 * @param myId
	 * @param targetId
	 * @param preRelation 타겟과의 이전 관계 (follow4follow, follower, follow, unfollow)
	 */
	public boolean updateFollow(String myId, String targetId, 
							String myFollow, String targetFollower, String preRelation) {
		String sql1 = "UPDATE member SET follow=? WHERE id=?";
		String sql2 = "UPDATE member SET follower=? WHERE id=?";

		boolean result = false;
		
		
		
		// myFollow와 targetFollower를 preRelation에 따라 수정할 필요성 있음
		// "follow4follow"와 "follow" = my가 target을 follow 했다
		if (preRelation == "follow4follow" || preRelation == "follow") {
			myFollow = Stream.of(myFollow.split(":"))					// myFollow 배열을 스트림으로 변환 후
							.filter(x -> !x.equals(targetId))			// myId를 제외한 모든 요소를 추출 후
							.collect(Collectors.joining(":"));			// ":"를 구분자로 문자열 생성
			
			targetFollower = Stream.of(targetFollower.split(":"))
							.filter(x -> !x.equals(myId))
							.collect(Collectors.joining(":"));
		} else {
			// myFollow에 정보가 없으면 해당 아이디만 넣으면 된다
			if (myFollow == null)  myFollow = targetId;
			// myFollow에 targetId를 넣은 후 문자열로 변환
			else
				myFollow = Stream.concat(Stream.of(myFollow.split(":")), Stream.of(targetId))
												.collect(Collectors.joining(":"));
			
			
			if (targetFollower == null) targetFollower = myId;
			else
				targetFollower = Stream.concat(Stream.of(targetFollower.split(":")), Stream.of(myId))
												.collect(Collectors.joining(":"));
		}
		
		try {
			// 자동 커밋 off
			conn.setAutoCommit(false);
			
			// 1차 sql 실행
			// 쿼리 값 매핑
			pstmt = conn.prepareStatement(sql1);
			pstmt.setString(1, myFollow);
			pstmt.setString(2, myId);
			
			if (pstmt.executeUpdate() > 0)
				commit(conn);
			close(pstmt);
			
			// 2차 sql 실행
			pstmt = conn.prepareStatement(sql2);
			pstmt.setString(1, targetFollower);
			pstmt.setString(2, targetId);
			
			if (pstmt.executeUpdate() > 0)
				commit(conn);
			close(pstmt);

			
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		close(pstmt);
		return result;
	}
	
	

}