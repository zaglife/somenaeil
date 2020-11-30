package com.dm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
	
	
	public ArrayList<chat> getChatListById(String fromid, String toid, String chatID){
		ArrayList<chat> chatlist = null;
		
		String sql = "select * from chat where ((fromid = ? and toid = ?) or (fromid = ? and toid = ?)) and chatID > ? order by chatTime";
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		try{
			ptmt = conn.prepareStatement(sql);
			// 자신이 받던간에 보내던간에 항상 메세지를 가져올수있도록 한다.
			ptmt.setString(1, fromid);
			ptmt.setString(2, toid);
			ptmt.setString(3, toid);
			ptmt.setString(4, fromid);
			ptmt.setInt(5,Integer.parseInt(chatID));
			rs = ptmt.executeQuery();
			chatlist = new ArrayList<chat>();
			while(rs.next()) {
				chat chat = new chat();
				chat.setChatID(rs.getInt("chatID"));
				chat.setFromid(rs.getString("fromid").replace(" ", "&nbsp;").replace("<", "&lt;").replace(">", "&gt;").replace("\n", "<br>"));
				chat.setToid(rs.getString("toid").replace(" ", "&nbsp;").replace("<", "&lt;").replace(">", "&gt;").replace("\n", "<br>"));
				chat.setChatcontent(rs.getString("chatcontent").replace(" ", "&nbsp;").replace("<", "&lt;").replace(">", "&gt;").replace("\n", "<br>"));
				int chatTime = Integer.parseInt(rs.getTimestamp("chatTime").toString().substring(11, 13));
				System.out.println(chatTime);
				String timeType ="오전";
				if(chatTime > 12) {
					timeType = "오후";
					chatTime -= 12;
				}
				chat.setChatTime(rs.getTimestamp("chatTime").toString().substring(0, 11) + " " + timeType + " " + chatTime + ":" + rs.getTimestamp("chatTime").toString().substring(14, 16) +"");
				chatlist.add(chat);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("메세지 불러오기 오류");
			
		}finally {
			try {
				if(rs != null) rs.close();
				if(ptmt != null) ptmt.close();
				if(conn != null) conn.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		return chatlist;
	}
	
	
	public ArrayList<chat> getChatListByRecent(String fromid, String toid, int number){
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
			ptmt.setInt(5, number);
			rs = ptmt.executeQuery();
			chatlist = new ArrayList<chat>();
			while(rs.next()) {
				chat chat = new chat();
				chat.setChatID(rs.getInt("chatID"));
				chat.setFromid(rs.getString("fromid").replace(" ", "&nbsp;").replace("<", "&lt;").replace(">", "&gt;").replace("\n", "<br>"));
				chat.setToid(rs.getString("toid").replace(" ", "&nbsp;").replace("<", "&lt;").replace(">", "&gt;").replace("\n", "<br>"));
				chat.setChatcontent(rs.getString("chatcontent").replace(" ", "&nbsp;").replace("<", "&lt;").replace(">", "&gt;").replace("\n", "<br>"));
				int chatTime = Integer.parseInt(rs.getTimestamp("chatTime").toString().substring(11, 13));
				
				System.out.println(chatTime);
				String timeType ="오전";
				if(chatTime > 12) {
					timeType = "오후";
					chatTime -= 12;
				}
				chat.setChatTime(rs.getTimestamp("chatTime").toString().substring(0, 11) + " " + timeType + " " + chatTime + ":" + rs.getTimestamp("chatTime").toString().substring(14, 16) +"");
				chatlist.add(chat);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("메세지 불러오기 오류");
		}finally {
			try {
				if(rs != null) rs.close();
				if(ptmt != null) ptmt.close();
				if(conn != null) conn.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		return chatlist;
	}
	
	
	public int submit(String fromid, String toid, String chatcontent){
		
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
			return ptmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("메세지 불러오기 오류");
			
		}finally {
			try {
				if(rs != null) rs.close();
				if(ptmt != null) ptmt.close();
				if(conn != null) conn.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		return -1;
	}
	
	
	
}
