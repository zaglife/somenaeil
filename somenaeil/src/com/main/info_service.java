package com.main;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.cs.cs;
import com.cs.cs_dao;
import com.job.job;
import com.job.job_dao;

public class info_service {
	private HttpServletRequest request;
	
	public info_service(HttpServletRequest request) {
		this.request= request;
	}
	
	public void cs_list() {
		cs_dao cd= new cs_dao();
		
		ArrayList<cs> data= cd.info_cs();
		request.setAttribute("cs_list", data);
	}
	
	public void job_list() {
		job_dao jd= new job_dao();
		
		ArrayList<job> data= jd.info_job();
		request.setAttribute("job_list", data);
	}
}
