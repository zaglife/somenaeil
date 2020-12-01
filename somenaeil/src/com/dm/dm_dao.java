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
	/////////////////////
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
	
	
	// 선언 안해요
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
				chat chat = new chat();
				chat.setChatID(rs.getInt("chatID"));
				chat.setFromid(rs.getString("fromid").replace(" ", "&nbsp;").replace("<", "&lt;").replace(">", "&gt;").replace("\n", "<br>"));
				chat.setToid(rs.getString("toid").replace(" ", "&nbsp;").replace("<", "&lt;").replace(">", "&gt;").replace("\n", "<br>"));
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
				

				chatList.add(chat);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return chatList;
	}
	
	
	public void insertLastChat() {
		
	}
	
	
	public ArrayList<chat> other_list(String userid){
		ArrayList<chat> list = null;
		String sql = "select * from chat where chatID in(select MAX(chatID) from chat where toid = ? or fromid = ? group by fromid, toid)";
		PreparedStatement pt = null;
		ResultSet rs = null;
		try{
			pt = conn.prepareStatement(sql);
			pt.setString(1, userid);
			pt.setString(2, userid);
			pt.executeUpdate();
			rs = pt.executeQuery();
			while(rs.next()) {
				if(list==null)
					list = new ArrayList<chat>(); // null이 되는 경우를 방지 
				int chatTime = Integer.parseInt(rs.getTimestamp("chatTime").toString().substring(11, 13));
				String timeType ="오전";
				if(chatTime > 12) {
					timeType = "오후";
					chatTime -= 12;
				}
				chat temp = new chat(rs.getInt("chatID"),rs.getString("fromid"), rs.getString("toid"), (rs.getTimestamp("chatTime").toString().substring(0, 11) + " " + timeType + " " + chatTime + ":" + rs.getTimestamp("chatTime").toString().substring(14, 16) +""), rs.getString("chatcontent"));
				list.add(temp);
			}
			
			System.out.println("asdasd");
			
			
			String id1 = "some";
			String id2 = "jsp유저";
			
			
			ArrayList<chat> chatList = new ArrayList<chat>();  
			chatList = (ArrayList<chat>) list.stream().filter(x -> ( x.getFromid().equals(id1) || x.getToid().equals(id1) ) &&
																	( x.getFromid().equals(id2) || x.getToid().equals(id2) ))
														.collect(Collectors.toList());
			int idx = 0;
			for (chat temp : chatList) {
				System.out.println(idx+"번째 chat");
				System.out.println("num: "+temp.getChatID());
				System.out.println("fromId" + temp.getFromid());
				System.out.println("toId" + temp.getToid());
				System.out.println("-------------------------");
				idx++;
			}
		
//			for(int i = 0; i < list.size(); i++) {
//				chat x = list.get(i);
//				for (int j = 0; j < list.size(); j++) {
//					chat y = list.get(j);
//					if(x.getFromid().equals(y.getToid()) && x.getToid().equals(x.getFromid())) {
//						if(x.getChatID() < y.getChatID()) {
//							list.remove(x);
//							i--;
//							break;
//						} else {
//							list.remove(y);
//							j--;
//						}
//					}
//				}
//			}
			
			
			
			
			
			
//			for(int i = 0; i < list.size(); i++) {
//				System.out.println(list.get(i).getFromid());
//				System.out.println("/////////////////////");
//				System.out.println(list.get(i).getToid());
//			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("other_list 불러오기 실패");
		}
		return null;
	}
	
	
	
	
	
}
