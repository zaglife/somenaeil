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
	
	public member() { }
	
	// 회원가입, 회원정보 수정
	public member(	String id,
					String pw,
					String name,
					String nick,
					String email,
					int cert,
					String pimg,
					String comt) {
		this.id= id;
		this.pw= pw;
		this.name= name;
		this.nick= nick;
		this.email= email;
		this.cert= cert;
		this.pimg= pimg;
		this.comt= comt;
	}
	
	
	// 유저 페이지
	public member(	String id,
					String nick,
					String email,
					int cert,
					String pimg,
					String comt,
					String follow,
					String follower,
					String scrap_list,
					String like_list) {
		this.id= id;
		this.nick= nick;
		this.email= email;
		this.cert= cert;
		this.pimg= pimg;
		this.comt= comt;
		this.follow= follow;
		this.follower= follower;
		this.scrap_list= scrap_list;
		this.like_list= like_list;
	}
	
	// 로그인
	public member(	String id,
					String name,
					String nick,
					String email,
					int cert,
					String pimg,
					String comt,
					String follow,
					String follower,
					String scrap_list,
					String like_list) {
		this.id= id;
		this.name= name;
		this.nick= nick;
		this.email= email;
		this.cert= cert;
		this.pimg= pimg;
		this.comt= comt;
		this.follow= follow;
		this.follower= follower;
		this.scrap_list= scrap_list;
		this.like_list= like_list;
	}
	
	// 팔로우, 팔로워 리스트
	public member(	String follow,
					String follower) {
		this.follow= follow;
		this.follower= follower;
	}
	
	// 다른 유저 정보 출력
	public member(	String id,
					String nick,
					String email,
					String pimg,
					String comt,
					String follow,
					String follower,
					String scrap_list	) {
		this.id = id; 
		this.nick= nick;
		this.email= email;
		this.pimg= pimg;
		this.comt= comt;
		this.follow= follow;
		this.follower= follower;
		this.scrap_list= scrap_list;
	}
	
	public int follow_num() {
		int followNum= 0;
		String[] followList= follow.split(":");
		followNum= followList.length;

		return followNum;
	}
	
	public int follower_num() {
		int followerNum= 0;
		String[] followerList= follow.split(":");
		followerNum= followerList.length;

		return followerNum;
	}
	
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
