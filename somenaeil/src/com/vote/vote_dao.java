package com.vote;

import java.sql.Connection;
import java.sql.DriverManager;
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
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("vote DB 커넥션 실패");
		}
	}
}
