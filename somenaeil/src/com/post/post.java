package com.post;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;

public class post {
	private int num;
	private String nick;
	private String cate;
	private int view_cnt;
	private int scrap_cnt;
	private Calendar time;
	private String title;
	private String hash;
	
	// post_detail DB data
	private ArrayList<Integer> position;
	private ArrayList<Integer> type;
	private ArrayList<String> context;
	
	
	public post(int num, String cate, String nick, Date time, String title, String hash) {
		this.num = num;
		this.cate = cate;
		this.nick = nick;
		this.time = Calendar.getInstance();
		this.time.setTime(time);
		this.title = title;
		this.hash = hash;
	}
	
	public void setPostContent(ArrayList<Integer> position, ArrayList<Integer> type, ArrayList<String> context) {
		this.position = position;
		this.type = type;
		this.context = context;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getCate() {
		return cate;
	}

	public void setCate(String cate) {
		this.cate = cate;
	}

	public int getView_cnt() {
		return view_cnt;
	}

	public void setView_cnt(int view_cnt) {
		this.view_cnt = view_cnt;
	}

	public int getScrap_cnt() {
		return scrap_cnt;
	}

	public void setScrap_cnt(int scrap_cnt) {
		this.scrap_cnt = scrap_cnt;
	}

	public Calendar getTime() {
		return time;
	}

	public void setTime(Calendar time) {
		this.time = time;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public ArrayList<Integer> getPosition() {
		return position;
	}

	public void setPosition(ArrayList<Integer> position) {
		this.position = position;
	}

	public ArrayList<Integer> getType() {
		return type;
	}

	public void setType(ArrayList<Integer> type) {
		this.type = type;
	}

	public ArrayList<String> getContext() {
		return context;
	}

	public void setContext(ArrayList<String> context) {
		this.context = context;
	}
	
	
	public String toString() {
		return String.format("%d %s(%s)", num, title, nick);
	}


}
