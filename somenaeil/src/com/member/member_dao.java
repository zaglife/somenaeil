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
			}
		}
		
		public member_login(String id, String pw) {
			String sql="select * from member where id='"+id+"' and pw='"+pw+"'";
			Statement stmt= null;
			ResultSet rs= null;
			
			try {
				stmt=conn.createStatement();
				rs=stmt.executeQuery(sql);
				if(rs.next()) {
					member user= new member(	rs.getString("id"),
												rs.getString("pw"),
												rs.getString("name"),
												rs.getString("nick"),
												rs.getString("email"),
												rs.getInt("cert"),
												rs.getString("pimg"),
												rs.getString("comt"));
					return user;
				}
			}catch(SQLException e) {
				e.printStackTrace();
				System.out.println("member_dao - 로그인 실패");
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
			// TODO Auto-generated method stub
		}
}