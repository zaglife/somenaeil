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
	
	public void all_data(HttpServletRequest request) {
		int page_num= 1;
		int size= 10;
		String num= request.getParameter("pnum");
		
		if(num != null) page_num= Integer.parseInt(num);
		
		cs_dao cd= new cs_dao();
		int total= cd.select_count();
		
		ArrayList<cs> list= cd.all_select(
			page_num == 1 ? 1 : (page_num-1)*10+1,
			size
		);
		
		cs_page board_page= new cs_page(total, page_num, size, list);
		request.setAttribute("list", board_page);
		System.out.println("cs_service 데이터 확인");
		System.out.println("board_page의 total= "+board_page.getTotal());
		System.out.println("board_page의 currentPage= "+board_page.getCurrentPage());
		System.out.println("board_page의 totalPage= "+board_page.getTotalPage());
		System.out.println("board_page의 startPage= "+board_page.getStartPage());
		System.out.println("board_page의 endPage= "+board_page.getEndPage());
		System.out.println("cs_service 데이터 확인 끝\n");
	}
}
















