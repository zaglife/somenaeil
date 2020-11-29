package com.job;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

public class job_service {
	private  HttpServletRequest request;
	
	public job_service() {}
	public job_service(HttpServletRequest request) {
		this.request= request;
	}
	
	public void job_update(HttpServletRequest request) {
		String title= request.getParameter("job_title");
		String cont= request.getParameter("job_cont");
		String com= request.getParameter("job_com");
		String end= request.getParameter("job_end");
		String linkA= request.getParameter("job_linkA");
		String linkB= request.getParameter("job_linkB");
		String linkC= request.getParameter("job_linkC");
		
		cont = cont.replace("\r\n","<br>");
		cont = cont.replace("지원자격","<b>지원자격</b>");
		cont = cont.replace("근무조건","<b>근무조건</b>");
		
		String link= linkA+"@@"+linkB+"@@"+linkC;
		
		job_dao jd= new job_dao();
		jd.job_insert(title, cont, com, end, link);
	}
	
	public void all_data(HttpServletRequest request) {
		int page_num= 1;
		int size= 10;
		String num= request.getParameter("pnum");
		
		if(num != null) page_num= Integer.parseInt(num);
		
		job_dao jd= new job_dao();
		int total= jd.select_count();
		
		ArrayList<job> list= jd.all_select(
			page_num == 1 ? 1 : (page_num-1)*10+1,
			size
		);

		job_page board_page= new job_page(total, page_num, size, list);
		request.setAttribute("list", board_page);
	}
}
