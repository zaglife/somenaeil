package com.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class member_dao {
	private Connection conn;
	
	public member_dao(){
		try {
			conn=DriverManager.getConnection("jdbc:apache:commons:dbcp:somenaeil");
		} catch(SQLException e){
			e.printStackTrace();
			System.out.println("member_dao - 실패");
		}
	}
	
	public member member_select(String id, String pw) {
		String sql="select * from member where id='"+id+"' and pw='"+pw+"'";
		Statement stmt=null;
		ResultSet rs=null;
		
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
								String comt) {
		String sql= "insert into member(num, id, pw, name, nick, email, cert, pimg, comt)";
		sql+= " values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement ptmt= null;
		
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
			
			ptmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("member_dao - 회원가입 sql 입력 실패");
		}
	}
}