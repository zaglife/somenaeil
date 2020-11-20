package com.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.dm.dm;
import com.noti.noti;

public class member_dao {
	private Connection conn;
	private PreparedStatement ptmt;
	private ResultSet rs;
	
	
	public member_dao(){
		try {
			conn=DriverManager.getConnection("jdbc:apache:commons:dbcp:somenaeil");
		} catch(SQLException e){
			e.printStackTrace();
			System.out.println("member_dao - member DB 커넥션 실패");
		}
	}
	
	public member member_select(String id, String pw) {
		String sql= "select * from member where id='"+id+"' and pw='"+pw+"'";
		Statement stmt= null;
		ResultSet rs= null;
		
		try {
			stmt= conn.createStatement();
			rs= stmt.executeQuery(sql);
				
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
				rs.close();
				stmt.close();
				conn.close();
				
				return user;
			}
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("member_dao - DB 로그인 실패");
		}
		return null;
	}
	
	public void member_insert(	String id,
								String pw,
								String name,
								String nick,
								String email,
								int cert,
								String pimg,
								String comt	) {
		System.out.println("멤버dao_인서트 1");
		String sql= "insert into member(num, id, pw, name, nick, email, cert, pimg, comt)";
		sql+= " values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement ptmt= null;
		System.out.println("멤버dao_인서트 2");
		try {
			ptmt= conn.prepareStatement(sql);
			ptmt.setInt(1, com.main.main_dao.get_num("member", conn));
			ptmt.setString(2, id);
			ptmt.setString(3, pw);
			ptmt.setString(4, name);
			ptmt.setString(5, nick);
			ptmt.setString(6, email);
			ptmt.setInt(7, cert);
			ptmt.setString(8, pimg);
			ptmt.setString(9, comt);
			
			ptmt.executeUpdate();
			System.out.println("멤버dao_인서트 3");
			// 회원가입 후 noti, dm 테이블 입력
			member_user_table(nick);
			
			ptmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("member_dao - 회원가입 sql 입력 실패");
		}
		
		
	}

	public void member_user_table(String nick) {
		String sql= "create table ";
		sql+= "noti_"+nick+"(";
		sql+= "num number(4) not null primary key, ";
		sql+= "other varchar2(20) not null, ";
		sql+= "type number(1) not null, ";
		sql+= "time date default sysdate, ";
		sql+= "scrap number(6))";
		
		Statement stmt= null;
		ResultSet rs= null;
		
		try {
			stmt= conn.createStatement();
			rs= stmt.executeQuery(sql);
			
			if(rs.next()) {
				noti nt= new noti(
					rs.getInt("num"),
					rs.getString("other"),
					rs.getInt("type"),
					rs.getDate("time"),
					rs.getInt("scrap"));
				rs.close();
				stmt.close();
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("member_dao - 유저별 noti테이블 생성 실패");
		}
		
		sql= "create table ";
		sql+= "dm_"+nick+"(";
		sql+= "num number(4) not null primary key, ";
		sql+= "other varchar2(20) not null, ";
		sql+= "context varchar2(4000) not null, ";
		sql+= "time date default sysdate, ";
		sql+= "cert number(1))";
		
		stmt= null;
		rs= null;
		
		try {
			stmt= conn.createStatement();
			rs= stmt.executeQuery(sql);
			
			if(rs.next()) {
				dm dm= new dm(
					rs.getInt("num"),
					rs.getString("other"),
					rs.getString("context"),
					rs.getDate("time"),
					rs.getInt("cert"));
				rs.close();
				stmt.close();
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("member_dao - 유저별 dm테이블 생성 실패");
		}
		
	}
	
	

	// DB에서 유저 세션을 불러와서
	// follow, follower, scrap, like, dm, noti 정보 받아서 사용
	/**
	 * 해당 유저 데이터 추출
	 * @param id
	 * @return 
	 */
	public member member_read(String id) {
		String sql= "select * from member where id=?";
		
		member user = null;
		try {
			ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, id);
			rs = ptmt.executeQuery();
			
			if(rs.next()) {
				user= new member(
					rs.getString("id"),
					rs.getString("nick"),
					rs.getString("pimg"),
					rs.getString("comt"),
					rs.getString("follow"),
					rs.getString("follower"),
					rs.getString("scrap_list"));
			}
		} catch(SQLException e) {
			e.printStackTrace();
			System.out.println("member_dao - 팔로우, 팔로워 리스트 불러오기 실패");
		}
		close();
		
		return user;
	}

	
	/**
	 * 팔로우 리스트 추출
	 * @param fl 팔로우 리스트 id
	 * @return 팔로우 리스트
	 */
	public ArrayList<member> follow_other(String[] fl) {		
		String sql= "select * from member where id=?";
		
		ArrayList<member> other_data = new ArrayList<member>();
		try {
			for (int i=0; i<fl.length; i++) {
				ptmt = conn.prepareStatement(sql);
				ptmt.setString(1, fl[i]);
				rs = ptmt.executeQuery();
				
				if (rs.next()) {
					member temp = new member(
							rs.getString("id"),
							rs.getString("nick"),
							rs.getString("pimg"),
							rs.getString("comt"),
							rs.getString("follow"),
							rs.getString("follower"),
							rs.getString("scrap_list"));
					other_data.add(temp);
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("member_dao - 다른 유저 정보 불러오기 실패");
		}
		close();
		return other_data;
	}
	
	private void close() {
		try {
			if (rs != null) { rs.close(); rs = null; }
			if (ptmt != null) { ptmt.close(); ptmt = null; }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}