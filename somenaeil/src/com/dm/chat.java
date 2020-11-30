package com.dm;

import java.util.Date;

public class chat {
	private int chatID;
	private String fromid;
	private String toid;
	private String chatTime;
	private String chatcontent;
	private String lastID;
//	
//	public chat(int chatID, String fromid, String toid, String chatTime, String chatcotent) {
//		this.chatID = chatID;
//		this.fromid = fromid;
//		this.toid = toid;
//		this.chatTime = chatTime;
//		this.chatcontent = chatcotent;
//	}
//	
	
	
	public String getLastID() {
		return lastID;
	}
	public void setLastID(String lastID) {
		this.lastID = lastID;
	}
	public String getChatcontent() {
		return chatcontent;
	}
	public void setChatcontent(String chatcontent) {
		this.chatcontent = chatcontent;
	}
	public int getChatID() {
		return chatID;
	}
	public void setChatID(int chatID) {
		this.chatID = chatID;
	}
	public String getFromid() {
		return fromid;
	}
	public void setFromid(String fromid) {
		this.fromid = fromid;
	}
	public String getToid() {
		return toid;
	}
	public void setToid(String toid) {
		this.toid = toid;
	}
	public String getChatTime() {
		return chatTime;
	}
	public void setChatTime(String chatTime) {
		this.chatTime = chatTime;
	}
	
}
