package com.dm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

public class dm_dao {
	private Connection conn;
	
	public dm_dao(){
		try {
			conn=DriverManager.getConnection("jdbc:apache:commons:dbcp:somenaeil");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("post DB 커넥션 실패");
		}
	}
	
	
	
	/**
	 * 채팅 메시지를 최근에 저장된 것이 맨 밑에 보여지도록 가져오는 메소드
	 * @param fromid
	 * @param toid
	 * @return
	 */
	public ArrayList<chat> getChatListById(String fromid, String toid){
		ArrayList<chat> chatlist = null;
		 // chatID 순대로 가져오겠다.
		String sql = "select * from chat where ((fromid = ? and toid = ?) or (fromid = ? and toid = ?)) order by chatID";
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		try{
			ptmt = conn.prepareStatement(sql);
			// 자신이 받던간에 보내던간에 항상 메세지를 가져올수있도록 한다.
			ptmt.setString(1, fromid);
			ptmt.setString(2, toid);
			ptmt.setString(3, toid);
			ptmt.setString(4, fromid);
			rs = ptmt.executeQuery();
			// rs에 담긴 내용을 모두 chat.java에 넣어주는 작업
			while(rs.next()) {
				if(chatlist==null)
					chatlist = new ArrayList<chat>(); // chatlist가 null이라면 ArrayList선언 
				chat chat = new chat(); // chat을 선언해 담아주기위한 작업 dm완성될시 생성자 생성 예정 
				chat.setChatID(rs.getInt("chatID"));
				chat.setFromid(rs.getString("fromid"));
				chat.setToid(rs.getString("toid"));
				chat.setChatcontent(rs.getString("chatcontent").replace(" ", "&nbsp;").replace("<", "&lt;").replace(">", "&gt;").replace("\n", "<br>"));
				int chatTime = Integer.parseInt(rs.getTimestamp("chatTime").toString().substring(11, 13));
				String timeType ="오전";
				if(chatTime > 12) {
					timeType = "오후";
					chatTime -= 12;
				}
				chat.setChatTime(rs.getTimestamp("chatTime").toString().substring(0, 11) + " " + timeType + " " + chatTime + ":" + rs.getTimestamp("chatTime").toString().substring(14, 16) +"");
				chatlist.add(chat);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("메세지 불러오기 오류");
		}finally {
			try {
				if(rs != null) rs.close();
				if(ptmt != null) ptmt.close();
				if(conn != null) conn.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		}
		return chatlist;
	}
	
	/**
	 * 대화 내용 출력
	 * @param fromid
	 * @param toid
	 * @return
	 */
	public ArrayList<chat> getChatListByRecent(String fromid, String toid){
		ArrayList<chat> chatlist = null;
		
		String sql = "select * from chat where ((fromid = ? and toid = ?) or (fromid = ? and toid = ?)) and chatID > (select MAX(chatID) - ? from chat) order by chatTime";
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		try{
			ptmt = conn.prepareStatement(sql);
			// 자신이 받던간에 보내던간에 항상 메세지를 가져올수있도록 한다.
			ptmt.setString(1, fromid);
			ptmt.setString(2, toid);
			ptmt.setString(3, toid);
			ptmt.setString(4, fromid);
			rs = ptmt.executeQuery();
			
			chatlist = new ArrayList<chat>();
			while(rs.next()) {	
				// 생성자를 이용하여 객체를 할당하는 방법 
				int chatTime = Integer.parseInt(rs.getTimestamp("chatTime").toString().substring(11, 13));
				String timeType ="오전";
				if(chatTime > 12) {
					timeType = "오후";
					chatTime -= 12;
				}
				chat temp = new chat(rs.getInt("chatID"),
						rs.getString("fromid"),
						rs.getString("toid"), 
						(rs.getTimestamp("chatTime").toString().substring(0, 11) + " " + timeType + " " + chatTime + ":" + rs.getTimestamp("chatTime").toString().substring(14, 16) +""), 
						rs.getString("chatcontent"));
				chatlist.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("메세지 불러오기 오류");
		}finally {
			try {
				if(rs != null) rs.close();
				if(ptmt != null) ptmt.close();
				if(conn != null) conn.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		}
		return chatlist;
	}
	
	/**
	 * 보낸 메시지 DB에 저장
	 * @param fromid
	 * @param toid
	 * @param chatcontent
	 * @return
	 */
	public void submit(String fromid, String toid, String chatcontent){
		String sql = "insert into chat values(?, ?, ?, sysdate, ?)";
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		try{
			int num = mytag.db_lib.get_chatID("chat", conn);
			
			ptmt = conn.prepareStatement(sql);
			// 자신이 받던간에 보내던간에 항상 메세지를 가져올수있도록 한다.
			ptmt.setInt(1, num);
			ptmt.setString(2, fromid);
			ptmt.setString(3, toid);
			ptmt.setString(4, chatcontent);
			ptmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("메세지 불러오기 오류");
		}finally {
			try {
				if(rs != null) rs.close();
				if(ptmt != null) ptmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		}
	}
	
	
	
	/**
	 * 해당 id 채팅 내역
	 */
	public ArrayList<chat> insertChatList(String id) {
		String sql = "SELECT * FROM chat "
					+ "WHERE (fromid=? OR toid=?)";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<chat> chatList = new ArrayList<chat>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, id);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				chat chat = new chat();
				chat.setChatID(rs.getInt("chatID"));
				chat.setFromid(rs.getString("fromid"));
				chat.setToid(rs.getString("toid"));
				chat.setChat_time(rs.getDate("chatTime"));
				chat.setChatcontent(rs.getString("chatcontent"));
				int chatTime = Integer.parseInt(rs.getTimestamp("chatTime").toString().substring(11, 13));
				String timeType ="오전";
				if(chatTime > 12) {
					timeType = "오후";
					chatTime -= 12;
				}
				chat.setChatTime(rs.getTimestamp("chatTime").toString().substring(0, 11) + " " + timeType + " " + chatTime + ":" + rs.getTimestamp("chatTime").toString().substring(14, 16) +"");

				chatList.add(chat);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return chatList;
	}
	
	
	/**
	 * 마지막 채팅 내용 불러오는 메소드
	 * @param fromId
	 * @param user
	 */
	public String insertLastChat(String fromId, String user) {
		String sql = "SELECT chatcontent FROM " + 
				"(SELECT * FROM chat WHERE " + 
				"(fromid=? OR toid=?) AND " + 
				"(fromid=? OR toid=?)) " + 
				"ORDER BY chatID DESC";
		
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String result = null;
	try {
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, fromId);
		pstmt.setString(2, fromId);
		pstmt.setString(3, user);
		pstmt.setString(4, user);
		rs = pstmt.executeQuery();
		if(rs.next()) {
			result = rs.getString("chatcontent");
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	}finally {
		try {
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}	
	return result;
	}
	
}
