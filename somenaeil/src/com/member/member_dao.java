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
			System.out.println("member_dao - 실패");
		}
	}
	
	public member member_select(String id, String pw) {
		String sql="select * from member where id='"+id+"' and pw='"+pw+"'";
		try {
			Statement stmt= conn.createStatement();
			ResultSet rs= stmt.executeQuery(sql);
				
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
					rs.getString("like_list")
						);
				rs.close();
				stmt.close();
				conn.close();
				return user;
			}
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("member_dao - 로그인 실패");
		}
		return null;
	}

	
//	public void join(member data) throws SQLException { 
//		String sql= "insert into member(num, id, pw, name, nick, email, cert, pimg, comt) values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
//		PreparedStatement pt= null;
//		
//		try {
//			pt= conn.prepareStatement(sql);
//			pt.setInt(1, get_num("member", conn));
//			pt.setString(2, data.getId());
//			pt.setString(3, data.getPw());
//			pt.setString(4, data.getName());
//			pt.setString(5, data.getNick());
//			pt.setString(6, data.getEmail());
//			pt.setInt(7, data.getCert());
//			pt.setString(8, data.getPimg());
//			pt.setString(9, data.getComt());
//			
//			pt.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//			System.out.println("member_dao - 회원가입 sql 입력 실패");
//		} finally {
//			pt.close();
//			conn.close();
//		}
//	}
	
	public void member_insert(member data) {
		String sql= "insert into member(num, id, pw, name, nick, email, cert, pimg, comt) values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement pt= null;
		
		try {
			pt= conn.prepareStatement(sql);
			pt.setInt(1, get_num("member", conn));
			pt.setString(2, data.getId());
			pt.setString(3, data.getPw());
			pt.setString(4, data.getName());
			pt.setString(5, data.getNick());
			pt.setString(6, data.getEmail());
			pt.setInt(7, data.getCert());
			pt.setString(8, data.getPimg());
			pt.setString(9, data.getComt());
			
			pt.executeUpdate();
			
			pt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("member_dao - 회원가입 sql 입력 실패");
		}
		
	}
		
	public static int get_num(String table, Connection conn) throws SQLException {
		int num= 1;
		
		String sql= "select Max(num) as m from "+table;
		Statement stmt= null;
		ResultSet rs= null;
		
		try {
			stmt= conn.createStatement();
			rs= stmt.executeQuery(sql);
			if(rs.next()) {
				num= rs.getInt("m")+1;
			}
			return num;
		} catch(SQLException e) {
			System.out.println("member_dao - num값 증가 실패");
		}
		
		rs.close();
		stmt.close();
		
		return num;
	}
	
}