package com.dm;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.some.some_able;

public class dm_hnd implements some_able{
	public String active(HttpServletRequest request, HttpServletResponse response){
		String part = request.getParameter("part");
		
		dm_service ds = new dm_service(request);
		String view = null;
		System.out.println(part);
		if(part.equals("chatlist")) {
			ds.dm_list();
			view = ds.dm();
		}
		else if(part.equals("list")){
			String chat = ds.dm_list();
			
			request.setAttribute("chatlist", chat);
		}
		else {
			view="dm.jsp";
		}
		return "dm.jsp";
	}
}
