package com.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cs.cs_service;
import com.job.job_service;

public class info_hnd implements main_able {
	
	public String active(HttpServletRequest request, HttpServletResponse response) {
		
		String part= request.getParameter("part");
		String view= null;
		
		cs_service cs= new cs_service();
		job_service js= new job_service();
		info_service is= new info_service(request);
		
		if(part == null) {
			is.cs_list();
			is.job_list();
			view= "info.jsp";
		} else {
			switch(part) {
			case "cs_view" :
				request.setAttribute("m", "cs");
				cs.all_data(request);
				view= "cs.jsp";
				break;
			case "cs_write" :
				view= "cs_write.jsp";
				break;
			case "cs_update" :
				request.setAttribute("m", "cs");
				cs.cs_update(request);
				cs.all_data(request);
				view= "cs.jsp";
				break;
				
			case "job_view" :
				request.setAttribute("m", "job");
				js.all_data(request);
				view= "job.jsp";
				break;
			case "job_write" :
				view= "job_write.jsp";
				break;
			case "job_update" :
				request.setAttribute("m", "job");
				js.job_update(request);
				js.all_data(request);
				view= "job.jsp";
				break;
			}
		}
		return view;
	}
}
