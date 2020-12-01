package com.dm;


import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.member.member;

public class dm_service {
	private HttpServletRequest request;
	
	public dm_service(HttpServletRequest request) {
		this.request=request;
	}

	public void dm() {
		String fromid = ((member)request.getSession().getAttribute("user")).getId();
		String toid = request.getParameter("toid");
		String chatcontent = request.getParameter("chatcontent");
		try {
			fromid = URLDecoder.decode(fromid, "UTF-8"); // 보낸사람(유저)아이디
			toid = URLDecoder.decode(toid, "UTF-8");  //받은사람(상대)아이디
			chatcontent = URLDecoder.decode(chatcontent, "UTF-8"); // 보낸 내용
			
			dm_dao dd = new dm_dao(); // dm_dao선언
			dd.submit(fromid, toid, chatcontent); //dm_dao에 있는 submit(db에 저장하는 메소드) 실행
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			System.out.println("decode오류");
		}
	}
	
	public ArrayList<chat> dm_list() {
		String fromid = ((member)request.getSession().getAttribute("user")).getId(); // 보낸 아이디 (유저 아이디) 
		String toid = request.getParameter("toid"); //받은 아이디 (상대 아이디)
		ArrayList<chat> result = null; // return시킬 ArrayList 선언 
		
		result = getID(fromid,toid);/// 채팅 내용들을 모두 가져오는 메소드 실행
		return result;////  가져온 채팅내용들을 return 시킨다.
	}
	//안써요
	public ArrayList<chat> getTen(String fromid, String toid) {
		dm_dao dd = new dm_dao();
		ArrayList<chat> chatlist = dd.getChatListByRecent(fromid, toid); 
		if(chatlist.size() == 0) return null;
		return chatlist;
	}
	
	// 이걸써요
	public ArrayList<chat> getID(String fromid, String toid) { // db에 있는 내용들을  모두 가져오게하는 메소드
		dm_dao dd = new dm_dao(); 
		ArrayList<chat> chatlist = dd.getChatListById(fromid, toid); // return 시킬 ArratList선언과 동시에 getChatListById메소드 실행 
	
		return chatlist;
	}
	
	// 안써요
	public ArrayList<chat> getID(String fromid, String toid, String chatID) {
		dm_dao dd = new dm_dao();
		ArrayList<chat> chatlist = dd.getChatListById(fromid, toid, chatID);
		if(chatlist.size() == 0) return null;
		return chatlist;
	}
	
	
	public ArrayList<chat> dm_other() {
		String fromid = ((member)request.getSession().getAttribute("user")).getId();
		ArrayList<chat> other = null;
		
		dm_dao dd = new dm_dao();
		other = dd.other_list(fromid);
		
		return other;
	}
	
	
	
	
	
}
