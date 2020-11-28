package com.cs;

import java.util.Date;

public class cs {
	private int num;
	private String title;
	private String cont;
	private Date time;
	
	public cs() {}
	public cs(	int num,
				String title,
				String cont,
				Date time) {
		this.num= num;
		this.title= title;
		this.cont= cont;
		this.time= time;
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCont() {
		return cont;
	}
	public void setCont(String cont) {
		this.cont = cont;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
}
