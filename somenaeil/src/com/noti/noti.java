package com.noti;

import java.util.Date;

public class noti {
	private int num;
	private String other;
	private int type;
	private Date time;
	private int scrap;
	
	public noti() {}
	public noti(	int num,
					String other,
					int type,
					Date time,
					int scrap) {
		this.num= num;
		this.other= other;
		this.type= type;
		this.time= time;
		this.scrap= scrap;
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
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
	public int getScrap() {
		return scrap;
	}
	public void setScrap(int scrap) {
		this.scrap = scrap;
	}
}
