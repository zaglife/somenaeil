package com.some;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;

import com.member.member_dao;

public class some_service {
	private HttpServletRequest request;
	
	public some_service() {}
	public some_service(HttpServletRequest request) {
		this.request= request;
	}

	// follow 리스트 분리
	public int follow_num() {
		member_dao md= new member_dao();
		
		String[] followList= request.getParameter("follow").split(":");
		int followNum= followList.length;
		
		request.setAttribute("followNum", followNum);
		System.out.println(followNum);

		return followNum;
	}
	
	// follower 리스트 분리
	public int follower_num() {
		member_dao md= new member_dao();
		
		String[] followerList= request.getParameter("follow").split(":");
		int followerNum= followerList.length;
		
		request.setAttribute("followerNum", followerNum);

		return followerNum;
	}
	
	
//	ss.follower_list();
	// follower 리스트 분리
	// scrap 리스트 분리
	// like 리스트 분리
	
}


