package com.job;

import java.util.Date;

public class job {
	private int num;
	private String com;
	private String end;
	private String title;
	private String cont;
	private String link;
	private Date time;
	
	public job() {}
	public job(	int num,
				String com,
				String end,
				String title,
				String cont,
				String link,
				Date time) {
		this.num= num;
		this.com= com;
		this.end= end;
		this.title= title;
		this.cont= cont;
		this.link= link;
		this.time= time;
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getCom() {
		return com;
	}
	public void setCom(String com) {
		this.com = com;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
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
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
}
