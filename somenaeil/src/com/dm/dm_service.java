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

	public String dm() {
		String fromid = ((member)request.getSession().getAttribute("user")).getId();
		String toid = request.getParameter("toid");
		String chatcontent = request.getParameter("chatcontent");
		if(fromid == null || fromid.equals("") || toid == null || toid.equals("") || chatcontent == null || chatcontent.equals("")) {
			return "0";
		}else {
			try {
				fromid = URLDecoder.decode(fromid, "UTF-8");
				toid = URLDecoder.decode(toid, "UTF-8");
				chatcontent = URLDecoder.decode(chatcontent, "UTF-8");
				
				dm_dao dd = new dm_dao();
				
				return (dd.submit(fromid, toid, chatcontent)+ "");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
				System.out.println("decode오류");
			}
		}
		
		return null;
	}
	
	public String dm_list() {
		String fromid = ((member)request.getSession().getAttribute("user")).getId();
		String toid = request.getParameter("toid");
		String listType = request.getParameter("listType");
		System.out.println(listType);
		System.out.println(toid);
		System.out.println(fromid);
		if(fromid == null || fromid.equals("") || toid == null || toid.equals("") || listType == null || listType.equals("")) {
			return "";
		}else if(listType.equals("ten"))
			try {
				return getTen(URLDecoder.decode(fromid, "UTF-8"), URLDecoder.decode(toid, "UTF-8"));
			} catch (UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				System.out.println("인코딩 실패");
			}
		else {
			try {
				return getID(URLDecoder.decode(fromid, "UTF-8"), URLDecoder.decode(toid, "UTF-8"), listType);
			}catch(Exception e) {
				e.printStackTrace();
				
			}
		}
		return null;
	}
	
	public String getTen(String fromid, String toid) {
		StringBuffer result = new StringBuffer();
		result.append("{\"result\"\":[");
		dm_dao dd = new dm_dao();
		ArrayList<chat> chatlist = dd.getChatListByRecent(fromid, toid, 10); // 몇개씩 불러오겠냐
		if(chatlist.size() == 0) return "";
		for(int i = 0; i < chatlist.size(); i++) {
			result.append("[{\"value\": \""+ chatlist.get(i).getFromid() + "\"},");
			result.append("{\"value\": \""+ chatlist.get(i).getToid() + "\"},");
			result.append("{\"value\": \""+ chatlist.get(i).getChatcontent() + "\"},");
			result.append("{\"value\": \""	+ chatlist.get(i).getChatTime() + "\"}]");
			if(i != chatlist.size() -1) result.append(",");
		}
		result.append("], \"last\":\"" + chatlist.get(chatlist.size()-1).getChatID() + "\"}");
		return result.toString();
	}
	
	public String getID(String fromid, String toid, String chatID) {
		StringBuffer result = new StringBuffer();
		result.append("{\"result\":[");
		dm_dao dd = new dm_dao();
		ArrayList<chat> chatlist = dd.getChatListById(fromid, toid, chatID); // 몇개씩 불러오겠냐
		if(chatlist.size() == 0) return "";
		for(int i = 0; i < chatlist.size(); i++) {
			result.append("[{\"value\": \""+ chatlist.get(i).getFromid() + "\"},");
			result.append("{\"value\": \""+ chatlist.get(i).getToid() + "\"},");
			result.append("{\"value\": \""+ chatlist.get(i).getChatcontent() + "\"},");
			result.append("{\"value\": \""+ chatlist.get(i).getChatTime() + "\"}]");
			if(i != chatlist.size() -1) result.append(",");
		}
		result.append("], \"last\":\"" + chatlist.get(chatlist.size()-1).getChatID() + "\"}");
		
		return result.toString();
	}
	
}
