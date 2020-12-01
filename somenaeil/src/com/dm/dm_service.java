package com.dm;


import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import com.member.member;
import com.member.member_dao;

public class dm_service {
	private HttpServletRequest request;
	
	public dm_service(HttpServletRequest request) {
		this.request=request;
	}

	public void dm(ArrayList<chat> list) {
		String fromid = ((member)request.getSession().getAttribute("sessionUser")).getId();
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
		String fromid = ((member)request.getSession().getAttribute("sessionUser")).getId(); // 보낸 아이디 (유저 아이디) 
		String toid = request.getParameter("toid"); //받은 아이디 (상대 아이디)
		ArrayList<chat> result = null; // return시킬 ArrayList 선언 
		
		result = getID(fromid,toid);/// 채팅 내용들을 모두 가져오는 메소드 실행
		return result;////  가져온 채팅내용들을 return 시킨다.
	}
		
	// 이걸써요
	public ArrayList<chat> getID(String fromid, String toid) { // db에 있는 내용들을  모두 가져오게하는 메소드
		dm_dao dd = new dm_dao(); 
		ArrayList<chat> chatlist = dd.getChatListById(fromid, toid); // return 시킬 ArratList선언과 동시에 getChatListById메소드 실행 
		return chatlist;
	}
	

	
	//리스트 가져오는거였습니다.
	public ArrayList<chat> dm_other() {
		String fromid = ((member)request.getSession().getAttribute("sessionUser")).getId();
		ArrayList<chat> other = null;
		
		dm_dao dd = new dm_dao();
		other = dd.other_list(fromid);
		
		return other;
	}
	
	
	public void view() {
		String fromId = ((member) request.getSession().getAttribute("sessionUser")).getId();
		//String toId = request.getParameter("toid");
		
		dm_dao dmDAO = new dm_dao();
		member_dao memberDAO = new member_dao();
		
		ArrayList<chat> userChatList = new ArrayList<chat>(); 			// 로그인 유저의 대화내역
		ArrayList<member> memberList = new ArrayList<member>();
		
		// 로그인 유저 대화 내역 가져오기
		userChatList = dmDAO.insertChatList(fromId);
		
		// 대화한 사람들 리스트 추출
		ArrayList<String> otherList = new ArrayList<String>();
		for (chat temp : userChatList) {
			String tempFromId = temp.getFromid();
			String tempToId = temp.getToid();
			
			// 다른 사람
			if (!tempFromId.equals(fromId)) {
				otherList.add(tempFromId);
			}
			if (!tempToId.equals(fromId)) {
				otherList.add(tempToId);
			}
		}
		
		// 중복 제거
		String otherListStr =  otherList.stream().distinct()
												.filter(x -> !x.equals(fromId))
												.collect(Collectors.joining(":"));
		
		
		// memberDAO에서 memberList 추출
		if (otherListStr != null) {
			memberList = memberDAO.selectMemberList(otherListStr.split(":"));
		}
		ArrayList<String> last = new ArrayList<String>();
		// 해당 아이디를 가진 채팅 가져오기
		for (member user : memberList) {
			// user id를 가지고 chatDAO 메소드 호출
			String userId = user.getId();
			// 어떤 메소드 
			dm_dao dd = new dm_dao();
			String lastChat = dd.insertLastChat(fromId, userId);
			last.add(lastChat);
		}
		
		// 온전하게 가지고 온 경우
		if (memberList.size() == last.size()) {
			request.setAttribute("memberList", memberList);
			request.setAttribute("lastText", last);
		}
		request.setAttribute("otherlist", otherListStr);
	
		
		
		
		
		// toUser가 null일시 
		
	}
	
	
	
}
