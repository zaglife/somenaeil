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
		if (part.equals("view")) {
			chat = ds.dm_list();
			request.setAttribute("chatlist", chat);			
			ds.other_view();
			ds.dm_follow();
		}else if(part.equals("chatlist")) {
			chat = ds.dm_list();
			request.setAttribute("chatlist", chat);
			ds.dm_insert();
			return "dm_send.jsp";
		}else if(part.equals("views")) {
			chat = ds.dm_list();
			request.setAttribute("chatlist", chat);
			ds.other_view();
			ds.dm_follow();
		}else if(part.equals("list")){
			chat = ds.dm_list();
			request.setAttribute("chatlist", chat);
		}
		else {
			view="dm.jsp";
		}
		return "dm.jsp";
	}
}
