package com.noti;


import java.util.Date;

import com.member.member_dao;

public class noti {
	private int num;			// 번호
	private String otherId;		// 대상 아이디
	private int type;			// 타입 1:follow; 2:like; 3:comment 4:scrap
	private Date time;			// 알림 날짜
	private int postNum;
	
	public noti() {}

	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public int getPostNum() {
		return postNum;
	}
	public void setPostNum(int postNum) {
		this.postNum = postNum;
	}
	public String getOtherId() {
		return otherId;
	}
	public void setOtherId(String otherId) {
		this.otherId = otherId;
	}
	
	// 임시
	public String getOtherNick() {
		member_dao memberDAO = new member_dao();
		String otherNick = null;
		otherNick = memberDAO.selectMember(otherId).getNick();
		return otherNick;
	}
}
