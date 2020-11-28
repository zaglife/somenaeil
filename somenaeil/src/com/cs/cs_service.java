package com.cs;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

//import com.member.member_dao;

public class cs_service {
	private  HttpServletRequest request;
	
	public cs_service() {}
	public cs_service(HttpServletRequest request) {
		this.request= request;
	}
	
	public void cs_update(HttpServletRequest request) {
		String title= request.getParameter("cw_title");
		String cont= request.getParameter("cw_cont");
		
		cs_dao cd= new cs_dao();
		cd.cs_insert(title, cont);
	}
	
	public ArrayList<cs> cs_all() {
		cs_dao cd= new cs_dao();
		ArrayList<cs> cs_list= cd.cs_output();
		
		return cs_list;
	}
}
