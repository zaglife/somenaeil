package com.job;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.main.main_dao;

public class job_dao {
	private Connection conn;
	
	public job_dao() {
		try {
			conn=DriverManager.getConnection("jdbc:apache:commons:dbcp:somenaeil");
		} catch(SQLException e){
			e.printStackTrace();
			System.out.println("job_dao - job DB 커넥션 실패");
		}
	}
	
	public void job_insert(	String title,
							String cont,
							String com,
							String end,
							String link) {
		String sql= "insert into job(num, com, end, title, content, link) ";
		sql+= "values(?, ?, ?, ?, ?, ?)";
		
		try(PreparedStatement ptmt= conn.prepareStatement(sql)) {
			ptmt.setInt(1, main_dao.get_num("job", conn));
			ptmt.setString(2, com);
			ptmt.setString(3, end);
			ptmt.setString(4, title);
			ptmt.setString(5, cont);
			ptmt.setString(6, link);
			
			ptmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("job_dao - job 글작성 실패");
		}
	}
	
	public ArrayList<job> all_select(int startRow, int size) {
		String sql= "select * from (select row_number()";
		sql+= " over(order by num desc) n, A.* from job A order by num desc)";
		sql+= " where n between "+startRow+" and "+(startRow+(size-1));
		
		ArrayList<job> data= new ArrayList<job>();
		try(	Statement stmt= conn.createStatement();
				ResultSet rs= stmt.executeQuery(sql)) {
			while(rs.next()) {
				job temp= new job(	rs.getInt("num"),
									rs.getString("com"),
									rs.getString("end"),
									rs.getString("title"),
									rs.getString("content"),
									rs.getString("link"),
									rs.getDate("time"));
				data.add(temp);
			}
			return data;
		} catch(SQLException e) {
			e.printStackTrace();
			System.out.println("job_dao - all_select메소드 채용정보 DB작업 실패");
		}
		return null;
	}
	
	public int select_count() {
		String sql= "select count(*) from job";
		
		try(	Statement stmt= conn.createStatement();
				ResultSet rs= stmt.executeQuery(sql)) {
			if(rs.next()) {
				return rs.getInt(1);
			}
		} catch(SQLException e) {
			e.printStackTrace();
			System.out.println("job_dao - 채용정보의 전체 게시글 수 불러오기 실패");
		}
		return 0;
	}
	
	public ArrayList<job> info_job() {
		ArrayList<job> data= new ArrayList<job>();
		String sql= "select * from job order by num desc";
		
		try(	Statement stmt= conn.createStatement();
				ResultSet rs= stmt.executeQuery(sql)) {
			
			while(rs.next()) {
				job temp= new job(	rs.getInt("num"),
									rs.getString("com"),
									rs.getString("end"),
									rs.getString("title"),
									rs.getString("content"),
									rs.getString("link"),
									rs.getDate("time"));
				data.add(temp);
			}
			return data;
		} catch(SQLException e) {
			e.printStackTrace();
			System.out.println("job_dao - 채용정보 공지글 불러오기 실패");
		}
		return null;
	}
}