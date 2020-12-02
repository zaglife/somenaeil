package mytag;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.job.job;
import com.job.job_dao;

public class db_lib {
	public static int get_num(String table, Connection conn) throws SQLException {
		int num = 1;
		
		String sql ="select Max(num) as m  from "+table; //해당테이블의 Max(num)값을 불러온다.
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.createStatement(); //oarcle에 Statement로 연결한다
			rs = stmt.executeQuery(sql); //rs에 저장
			if(rs.next()) {
				num = rs.getInt("m")+1;
			}
			return num;
		}catch (SQLException e) {
			System.out.println("num값 DB 오류");
		}
		rs.close();
		stmt.close();

		return num;
		
	}
	
	public ArrayList<job> slide_list() {
		job_dao jd= new job_dao();
		
		ArrayList<job> data= jd.info_job();
		
		return data;
	}
	

	public static int get_chatID(String table, Connection conn) throws SQLException {
		int num = 1;
		
		String sql ="select Max(chatID) as m  from "+table; //해당테이블의 Max(num)값을 불러온다.
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.createStatement(); //oarcle에 Statement로 연결한다
			rs = stmt.executeQuery(sql); //rs에 저장
			if(rs.next()) {
				num = rs.getInt("m")+1;
			}
			return num;
		}catch (SQLException e) {
			System.out.println("num값 DB 오류");
		}
		rs.close();
		stmt.close();

		return num;
		
	}
}
