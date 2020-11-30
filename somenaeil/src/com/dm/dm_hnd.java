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
		System.out.println(part);
		if (part.equals("view")) {
			chat = ds.dm_list();
			request.setAttribute("chatlist", chat);
		}else if(part.equals("chatlist")) {
			// chat  = ds.dm_list();
			view = ds.dm();
			chat = ds.dm_list();
		}
		else if(part.equals("list")){
			chat = ds.dm_list();
			System.out.println("a"+chat.get(0).getChatcontent());
			request.setAttribute("chatlist", chat);
		}
		else {
			view="dm.jsp";
		}
		
		if(chat!=null)
			System.out.println("b"+chat.get(0).getChatcontent());
		return "dm.jsp";
	}
}
