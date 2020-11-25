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
		
		try(	Statement st= conn.createStatement();
				ResultSet rs= st.executeQuery(sql)) {

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
		String sql= "insert into member(num, id, pw, name, nick, email, cert, pimg, comt)";
		sql+= " values(?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try(PreparedStatement ptmt= conn.prepareStatement(sql)) {
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
			// 회원가입 후 noti, dm 테이블 입력
			member_user_table(nick);

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("member_dao - 회원가입 sql 입력 실패");
		}
	}
	
	public member member_update(	String id,
									String pw,
									String nick,
									String email,
									int cert,
									String pimg,
									String comt	) {
		if(pw == "") {
			String sql= "select pw from member where id='"+id+"'";

			try(	Statement stmt= conn.createStatement();
					ResultSet rs= stmt.executeQuery(sql)) {
				if(rs.next()) {
					pw= rs.getString("pw");
				}
			} catch(SQLException e) {
				e.printStackTrace();
				System.out.println("member_dao - 회원정보수정 중 비밀번호 조회 실패");
			}
		}
		String sql= "update member set pw='"+pw+"', nick='"+nick+"',";
		sql+= " email='"+email+"', cert='"+cert+"', pimg='"+pimg+"',";
		sql+= " comt='"+comt+"' where id='"+id+"'";
		
		try(Statement stmt= conn.createStatement()) {
			stmt.executeUpdate(sql);			
		} catch(SQLException e) {
			e.printStackTrace();
			System.out.println("member_dao - 회원정보수정 실패");
		}
		return member_select(id, pw);
	}

	public void member_user_table(String nick) {
		String sql= "create table ";
		sql+= "noti_"+nick+"(";
		sql+= "num number(4) not null primary key, ";
		sql+= "other varchar2(20) not null, ";
		sql+= "type number(1) not null, ";
		sql+= "time date default sysdate, ";
		sql+= "scrap number(6))";
		
		try(	Statement stmt= conn.createStatement();
				ResultSet rs= stmt.executeQuery(sql)) {
			if(rs.next()) {
				noti nt= new noti(
					rs.getInt("num"),
					rs.getString("other"),
					rs.getInt("type"),
					rs.getDate("time"),
					rs.getInt("scrap"));
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
		
		try(	Statement stmt= conn.createStatement();
				ResultSet rs= stmt.executeQuery(sql)) {
			if(rs.next()) {
				dm dm= new dm(
					rs.getInt("num"),
					rs.getString("other"),
					rs.getString("context"),
					rs.getDate("time"),
					rs.getInt("cert"));
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
		try(PreparedStatement ptmt= conn.prepareStatement(sql)) {
			ptmt.setString(1, id);
			ResultSet rs= ptmt.executeQuery();
			if(rs.next()) {
				user= new member(
					rs.getString("id"),
					rs.getString("nick"),
					rs.getString("email"),
					rs.getString("pimg"),
					rs.getString("comt"),
					rs.getString("follow"),
					rs.getString("follower"),
					rs.getString("scrap_list"));
			}
			return user;
		} catch(SQLException e) {
			e.printStackTrace();
			System.out.println("member_dao - 멤버정보 불러오기 실패");
		}
		return null;
	}

	
	/**
	 * 팔로우 리스트 추출
	 * @param fl 팔로우 리스트 id
	 * @return 팔로우 리스트
	 */
	public ArrayList<member> follow_other(String[] fl) {
		ArrayList<member> data = new ArrayList<member>();
		
		for(int i=0; i<fl.length; i++) {
			String sql= "select * from member where id='"+fl[i]+"'";
			try(	Statement stmt= conn.createStatement();
					ResultSet rs= stmt.executeQuery(sql)) {
				if(rs.next()) {
					member follow_temp= new member(
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
					data.add(follow_temp);
					
				}
			} catch(SQLException e) {
				e.printStackTrace();
				System.out.println("member_dao - <팔로우 리스트> 다른 유저 정보 불러오기 실패");
			}
		}
		return data;
	}
	
	/**
	 * 팔로워 리스트 추출
	 * @param flw 팔로워 리스트 id
	 * @return 팔로워 리스트
	 */
	public ArrayList<member> follower_other(String[] flw) {	
		ArrayList<member> data = new ArrayList<member>();
		
		for(int i=0; i<flw.length; i++) {
			String sql= "select * from member where id='"+flw[i]+"'";
			try(	Statement stmt= conn.createStatement();
					ResultSet rs= stmt.executeQuery(sql)) {
				if(rs.next()) {
					member follower_temp= new member(
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
					data.add(follower_temp);
					
				}
			} catch(SQLException e) {
				e.printStackTrace();
				System.out.println("member_dao - <팔로우 리스트> 다른 유저 정보 불러오기 실패");
			}
		}
		return data;
	}
	
	public void fl_update(	String my_id,
							String other_id,
							String other_follow,
							String type) {
		String temp= "";
		String sql= "";
		if(type.equals("fl")) {
			System.out.println("member_dao - fl="+type);
			
			other_follow+= ":"+my_id;
			sql= "update member set follower='"+other_follow+"' where id='"+other_id+"'";
			
			System.out.println("member_dao - sql="+sql);
		} else if(type.equals("un")) {
			System.out.println("member_dao - fl="+type);
			
			String[] f_list= other_follow.split(":");
			for(int i=0; i<f_list.length; i++) {
				if(f_list[i] != my_id) {
					temp+= f_list[i]+":";
				}else if(f_list[i] == my_id) break;
			}
			temp= temp.substring(0, temp.length()-1);
			sql= "update member set follower='"+temp+"' where id='"+other_id+"'";
			
			System.out.println("member_dao - fl="+sql);
		} else {
			System.out.println("member_dao - fl= if문 문제");
		}
		
		try(Statement st= conn.createStatement()) {
			st.executeUpdate(sql);
		} catch(SQLException e) {
			e.printStackTrace();
			System.out.println("member_dao - 팔로우 업데이트 실패");
		}
		
		
		
		// 대상 팔로워 리스트에 업데이트 성공
		// 내 팔로우 리스트에 대상 아이디 추가
		
	}
}