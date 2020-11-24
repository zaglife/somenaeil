package com.some;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
}
