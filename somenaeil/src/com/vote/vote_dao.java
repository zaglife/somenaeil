package com.vote;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * SQL DB에 연결하여 저장 및 추출
 * @author gagip
 *
 */
public class vote_dao {
	private Connection conn;
	public vote_dao(){
		try {
			conn=DriverManager.getConnection("jdbc:apache:commons:dbcp:somenaeil");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("vote DB 커넥션 실패");
		}
	}
	public void add(String nick, String title, String itmes, int muit, int stat, int hidden, int date, String day) {
		if(day != null) {
			String sql2 = "insert into vote(num,nick,title,start_date,end_date,muitl_choice,hidden_vote,voting_stat, itme) values(?,?,?,sysdate,sysdate'"+day+"',?,?,?,?)";
		}
		String sql = "insert into vote(num,nick,title,start_date,end_date,muitl_choice,hidden_vote,voting_stat, itme) values(?,?,?,sysdate,sysdate+1,?,?,?,?)";
		
		try(PreparedStatement pt = conn.prepareStatement(sql)){
			pt.setInt(1, mytag.db_lib.get_num("vote", conn));
			pt.setString(2, nick);
			pt.setString(3, title);
			pt.setInt(4, muit);
			pt.setInt(5, hidden);
			pt.setInt(6, stat);
			pt.setString(7, itmes);
			pt.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("vote 저장 실패");
		}
		
		
		
		
		
		
	}
}
