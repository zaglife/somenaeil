package com.reply;

import java.sql.Date;

/**
 * 댓글 Bean
 * @author gagip
 */
public class reply {
	private int num;			// 댓글 글번호
	private int post_num;		// 게시글 글번호
	private String author;		// 댓글 작성자
	private Date time;			// 댓글 작성 날짜
	private int parent;			// 부모 댓글 번호
	private String context;		// 댓글 내용
	private int level;			// 댓글 깊이
	
	public reply() {}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getPost_num() {
		return post_num;
	}
	public void setPost_num(int post_num) {
		this.post_num = post_num;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}

	public int getParent() {
		return parent;
	}
	public void setParent(int parent) {
		this.parent = parent;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
}
