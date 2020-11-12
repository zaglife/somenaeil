package com.post;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * SQL DB에 연결하여 저장 및 추출
 * @author gagip
 *
 */
public class post_dao {
	private Connection conn;
	public post_dao(){
		try {
			conn=DriverManager.getConnection("jdbc:apache:commons:dbcp:somenaeil");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("post DB 커넥션 실패");
		}
	}
	
	// 승재: 저장하기
	
	// 찬우: 추출
}
