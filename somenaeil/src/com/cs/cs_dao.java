package com.cs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.member.member;

public class cs_dao {
	private Connection conn;
	
	public cs_dao() {
		try {
			conn=DriverManager.getConnection("jdbc:apache:commons:dbcp:somenaeil");
		} catch(SQLException e){
			e.printStackTrace();
			System.out.println("cs_dao - cs DB 커넥션 실패");
		}
	}
	
	public void cs_insert(String title, String cont) {
		String sql= "insert into cs(num, title, content) ";
		sql+= "values(?, ?, ?)";
		
		try(PreparedStatement ptmt= conn.prepareStatement(sql)) {
			ptmt.setInt(1, com.main.main_dao.get_num("cs", conn));
			ptmt.setString(2, title);
			ptmt.setString(3, cont);
			
			ptmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("cs_dao - cs 글작성 실패");
		}
	}
	
	// 사용안함
	public ArrayList<cs> cs_output() {
		ArrayList<cs> data= new ArrayList<cs>();
		String sql= "select * from cs order by num desc";
		
		try(	Statement stmt= conn.createStatement();
				ResultSet rs= stmt.executeQuery(sql)) {
			while(rs.next()) {
				cs temp= new cs(
						rs.getInt("num"),
						rs.getString("title"),
						rs.getString("content"),
						rs.getDate("time"));
				data.add(temp);
			}
			return data;
		} catch(SQLException e) {
			e.printStackTrace();
			System.out.println("cs_dao - <고객센터> 모든 정보 불러오기 실패");
		}
		return null;
	}
	
	public ArrayList<cs> all_select(int startRow, int size) {
		String sql= "select * from (select row_number()";
		sql+= " over(order by num desc) n, A.* from cs A order by num desc)";
		sql+= " where n between "+startRow+" and "+(startRow+(size-1));
		
		System.out.println("cs_dao - sql= "+sql);
		
		ArrayList<cs> data= new ArrayList<cs>();
		try(	Statement stmt= conn.createStatement();
				ResultSet rs= stmt.executeQuery(sql)) {
			while(rs.next()) {
				cs temp= new cs(
						rs.getInt("num"),
						rs.getString("title"),
						rs.getString("content"),
						rs.getDate("time"));
				data.add(temp);
			}
			return data;
		} catch(SQLException e) {
			e.printStackTrace();
			System.out.println("cs_dao - all_select메소드 고객센터 DB작업 실패");
		}
		return null;
	}
	
	public int select_count() {
		String sql= "select count(*) from cs";
		
		try(	Statement stmt= conn.createStatement();
				ResultSet rs= stmt.executeQuery(sql)) {
			if(rs.next()) {
				return rs.getInt(1);
			}
		} catch(SQLException e) {
			e.printStackTrace();
			System.out.println("cs_dao - 고객센터의 전체 게시글 수 불러오기 실패");
		}
		return 0;
	}
}
