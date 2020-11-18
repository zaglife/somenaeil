package com.some;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.member.member;
import com.member.member_dao;

public class some_service {
	private HttpServletRequest request;
	
	public some_service() {}
	public some_service(HttpServletRequest request) {
		this.request= request;
	}

	// follow 리스트 분리

	
	// follower 리스트 분리

	
//	ss.follower_list();
	// follower 리스트 분리
	// scrap 리스트 분리
	// like 리스트 분리
	
	
	public ArrayList<member> follow_list_split() {
		member_dao md = new member_dao();
		// 내 데이터
		member my = md.select_member("some");
		// 내 데이터의 팔로우 리스트 추출 및 가공
		String[] my_follow_list = my.getFollow().split(":");
		// 해당 팔로우들의 데이터리스트 리턴
		ArrayList<member> result = md.follow_other(my_follow_list);
		
		return result;
	}
	
}


