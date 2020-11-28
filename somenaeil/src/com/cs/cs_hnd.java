package com.cs;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.main.main_able;
import com.member.member_service;

public class cs_hnd implements main_able{

	public String active(HttpServletRequest request, HttpServletResponse response) {

		cs_service cs= new cs_service();
		
		String cs_part= request.getParameter("cs_part");
		String view= null;
		
		System.out.println("cs_hnd 테스트 시작");
		
		
		if(cs_part == null) {
			ArrayList<cs> cs_list= cs.cs_all();
			request.setAttribute("cs_list", cs_list);
			view= "cs.jsp";
		} else {
			switch(cs_part) {
			case "cs_view" :
				cs.cs_all();
				view= "cs.jsp";
				break;
			case "cs_write" :
				System.out.println("cs_hnd - cs_part = cs_write");
				view= "cs_write.jsp";
				break;
			case "cs_update" :
				System.out.println("cs_hnd - cs_part = cs_update");
				
				cs.cs_update(request);
				view= "cs.jsp";
				break;
			}
		}
		
		return view;
	}
}
