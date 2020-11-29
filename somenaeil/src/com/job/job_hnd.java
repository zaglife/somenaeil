package com.job;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.main.main_able;

public class job_hnd implements main_able{

	public String active(HttpServletRequest request, HttpServletResponse response) {
		
		job_service js= new job_service();
		
		String job_part= request.getParameter("job_part");
		request.setAttribute("m", "job");
		
		String view= null;
		
		if(job_part == null) {
			js.all_data(request);
			view= "job.jsp";
		} else {
			switch(job_part) {
			case "job_view" :
				js.all_data(request);
				view= "job.jsp";
				break;
			case "job_write" :
				view= "job_write.jsp";
				break;
			case "job_update" :
				js.job_update(request);
				js.all_data(request);
				view= "job.jsp";
				break;
			}
		}
		
		return view;
	}
}
