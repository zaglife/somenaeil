package com.vote;

import java.util.Calendar;

public class vote {
	private int num;
	private String nick;
	private String title;
	private Calendar start_date;
	private Calendar end_date;
	private int multi_choice;
	private int hidden_vote;
	private int voting_stat;
	
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Calendar getStart_date() {
		return start_date;
	}
	public void setStart_date(Calendar start_date) {
		this.start_date = start_date;
	}
	public Calendar getEnd_date() {
		return end_date;
	}
	public void setEnd_date(Calendar end_date) {
		this.end_date = end_date;
	}
	public int getMulti_choice() {
		return multi_choice;
	}
	public void setMulti_choice(int multi_choice) {
		this.multi_choice = multi_choice;
	}
	public int getHidden_vote() {
		return hidden_vote;
	}
	public void setHidden_vote(int hidden_vote) {
		this.hidden_vote = hidden_vote;
	}
	public int getVoting_stat() {
		return voting_stat;
	}
	public void setVoting_stat(int voting_stat) {
		this.voting_stat = voting_stat;
	}
}
