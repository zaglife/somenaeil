package com.some;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.member.member;

public class some_dao {
	private Connection conn;
	
	public some_dao() {
		try {
			conn= DriverManager.getConnection("jdbc:apache:commons:dbcp:somenaeil");
		} catch(SQLException e) {
			System.out.println("some_dao - DB 커넥션 실패");
		}
	}

	// DB에서 유저 세션을 불러와서
	// follow, follower, scrap, like, dm, noti 정보 받아서 사용
	public static member member_other(String id, String pw) {
		Connection conn = null;
		String sql= "select * from member where id='"+id+"' and pw='"+pw+"'";
		Statement stmt= null;
		ResultSet rs= null;
		
		String[] follow_list;
		
		try {
			stmt= conn.createStatement();
			rs= stmt.executeQuery(sql);
			
			if(rs.next()) {
				member user= new member(
					rs.getString("follow"),
					rs.getString("follower"));
				
				follow_list= user.getFollow().split(":");
				
//				some_service.follow_info(follow_list);
//				some_service.follower_info(follower_list);
				some_service.other(follow_list);
				
				rs.close();
				stmt.close();
				conn.close();
				
				return null;
			}
		} catch(SQLException e) {
			e.printStackTrace();
			System.out.println("some_dao - 팔로우, 팔로워 리스트 불러오기 실패");
		}
		
		return null;
	}

	
}
