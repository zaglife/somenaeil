package com.noti;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.some.some_able;

public class noti_hnd implements some_able{

	@Override
	public String active(HttpServletRequest request, HttpServletResponse response) {
		String part=request.getParameter("part");
		String view = "noti.jsp";
		
		noti_service ns = new noti_service(request);
		
		if (part == null) {
			view = ns.getNotiList();
		}
		else {
			switch (part) {

			}
		}
		return view;
	}

}
