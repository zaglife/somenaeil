package com.post;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.member.member;
import com.member.member_dao;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

/**
 * post Bean
 * @author gagip
 */
public class post {
	private int num;			// 게시글 번호
	private String id;			// 게시글 작성자 id
	private String nick;		// 게시글 작성자 닉네임
	private String cate;		// 게시글 카테고리
	private Calendar time;		// 작성 날짜
	private String title;		// 게시글 제목
	private String content;		// 게시글 내용
	private String hash;		// 해시태그
	private int view_cnt;		// 조회수
	private int scrap_cnt;		// 스크랩 수
	private int like_cnt;		// 좋아요 수
	
	
	public post() {}
	
	public post(int num, String id, String cate, String nick, Date time, String title, String content, String hash) {
		this.num = num;
		this.id = id;
		this.cate = cate;
		this.nick = nick;
		this.time = Calendar.getInstance();
		this.time.setTime(time);
		this.title = title;
		this.content = content;
		this.hash = hash;
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

	public String getTime() {
		String day = "";
		if (time != null) {
			day = String.format("%d년 %d월 %d일", 
							time.get(Calendar.YEAR),
							time.get(Calendar.MONTH)+1,
							time.get(Calendar.DATE));
		}
		return day;
	}

	public void setTime(Date time) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(time);
		this.time = cal;
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
	
	public String toString() {
		return String.format("%d %s(%s)", num, title, nick);
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	public int getLike_cnt() {
		return like_cnt;
	}

	public void setLike_cnt(int like_cnt) {
		this.like_cnt = like_cnt;
	}
	
	/**
	 * 검색 결과 화면에 간단하게 보여줄 게시글 요약
	 * @author gagip
	 * @return
	 */
	public String getSummaryContent() {
		String ctxt = content;
		boolean hasThumb = ctxt.contains("<img");	// 썸네일 여부
		
		// 태그 제거 정규표현식
		// TODO 태그 처리 못한 부분 처리
		ctxt = ctxt.replaceAll("<(\\/)?[\\w\\d]+"
				+ "((\\s[\\w\\d-./]+)=(\"[\\w가-힣ㄱ-ㅎㅏ-ㅣ\\d\\s()-_.,\\/:;]*\")*)*"
				+ "(\\/)?>", "")
					.trim();
		
		// 긴 글씨 처리
		if (hasThumb && ctxt.length() > 50) {
			ctxt = ctxt.substring(0,47);
			ctxt += "...";
		}
		else if (!hasThumb && ctxt.length() > 100) {
			ctxt = ctxt.substring(0,97);
			ctxt += "...";
		}
		
		
		return ctxt;
	}
	
	/**
	 * 게시글의 썸네일 태그 추출
	 * @author gagip
	 * @return
	 */
	public String getThumbnail() {
		String ctxt = content;
		String thumbnailTag = null;
		Pattern patten = Pattern.compile("<img((\\s)*[\\w\\d-]*(=\"[\\w\\d/.-]+\")*)*>");
		Matcher matcher = patten.matcher(ctxt);
		
		while (matcher.find()) {
			if (matcher.group() == null) break;
			
			thumbnailTag = matcher.group();
		}
		
		return thumbnailTag;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * 해당 유저의 pimg를 가지고 온다
	 * @return
	 */
	public String getPimg() {
		member_dao memberDAO = new member_dao();
		member writer = memberDAO.selectMember(id);
		String pimg = null;
		pimg = writer.getPimg();
		return pimg;
	}
}
