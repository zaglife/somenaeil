package com.member;

import java.util.Calendar;

public class member {
	private int num;
	private String id;
	private String pw;
	private String name;
	private String nick;
	private String email;
	private int cert;
	private Calendar time;
	private String pimg;
	private String comt;
	private String follow;
	private String follower;
	private String scrap_list;
	private String like_list;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getCert() {
		return cert;
	}
	public void setCert(int cert) {
		this.cert = cert;
	}
	public Calendar getTime() {
		return time;
	}
	public void setTime(Calendar time) {
		this.time = time;
	}
	public String getPimg() {
		return pimg;
	}
	public void setPimg(String pimg) {
		this.pimg = pimg;
	}
	public String getComt() {
		return comt;
	}
	public void setComt(String comt) {
		this.comt = comt;
	}
	public String getFollow() {
		return follow;
	}
	public void setFollow(String follow) {
		this.follow = follow;
	}
	public String getFollower() {
		return follower;
	}
	public void setFollower(String follower) {
		this.follower = follower;
	}
	public String getScrap_list() {
		return scrap_list;
	}
	public void setScrap_list(String scrap_list) {
		this.scrap_list = scrap_list;
	}
	public String getLike_list() {
		return like_list;
	}
	public void setLike_list(String like_list) {
		this.like_list = like_list;
	}
}
