package com.cs;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.main.main_able;

public class cs_hnd implements main_able{

	public String active(HttpServletRequest request, HttpServletResponse response) {

		cs_service cs= new cs_service();
		
		String cs_part= request.getParameter("cs_part");
		request.setAttribute("m", "cs");
		
		String view= null;
		
		if(cs_part == null) {
			cs.all_data(request);
			view= "cs.jsp";
		} else {
			switch(cs_part) {
			case "cs_view" :
				cs.all_data(request);
				view= "cs.jsp";
				break;
			case "cs_write" :
				view= "cs_write.jsp";
				break;
			case "cs_update" :
				cs.cs_update(request);
				view= "cs.jsp";
				break;
			}
		}
		
		return view;
	}
}
