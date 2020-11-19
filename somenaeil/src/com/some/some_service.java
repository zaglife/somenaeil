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

}


