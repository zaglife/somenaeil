package com.dm;



import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.some.some_able;

public class dm_hnd implements some_able{
	public String active(HttpServletRequest request, HttpServletResponse response){
		String part = request.getParameter("part");
		
		dm_service ds = new dm_service(request);
		String view = null;
		ArrayList<chat> chat=null;
		ArrayList<chat> other=null;
		if (part.equals("view")) {
			chat = ds.dm_list();
			request.setAttribute("chatlist", chat);
			//other =  ds.dm_other();
			ds.view();
			//request.setAttribute("other", other);
		}else if(part.equals("chatlist")) {
			// chat  = ds.dm_list();
			chat = ds.dm_list();
			ds.dm(chat);
		}
		else if(part.equals("list")){
			chat = ds.dm_list();
			request.setAttribute("chatlist", chat);
		}
		else {
			view="dm.jsp";
		}
		return "dm.jsp";
	}
}
