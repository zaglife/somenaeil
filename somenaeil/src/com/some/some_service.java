package com.some;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.member.member;
import com.member.member_dao;

public class some_service {
	private HttpServletRequest request;
	
	public some_service() {}
	public some_service(HttpServletRequest request) {
		this.request= request;
	}

	// follow 리스트 분리
	public static ArrayList<member> other(String[] fl) {
		
		ArrayList<member> other_data= new ArrayList<member>();
		
		try {
			Connection conn= DriverManager.getConnection("jdbc:apache:commons:dbcp:somenaeil");
			
			for(int i=0; i<fl.length; i++) {
				String sql= "select * from member where nick='"+fl[i]+"' order by desc";
				Statement stmt= conn.createStatement();
				ResultSet rs= stmt.executeQuery(sql);
				
				if(rs.next()) {
					while(true) {
						member temp= new member(
							rs.getString("nick"),
							rs.getString("pimg"),
							rs.getString("comt"),
							rs.getString("follow"),
							rs.getString("follower"),
							rs.getString("scrap_list")
						);
						other_data.add(temp);
					}
				}
			}
			return other_data;
		} catch(SQLException e) {
			e.printStackTrace();
			System.out.println("some_service - 다른 유저 정보 불러오기 실패");
		}
		return null;
	}
	
	// follower 리스트 분리

	
//	ss.follower_list();
	// follower 리스트 분리
	// scrap 리스트 분리
	// like 리스트 분리
	
}


