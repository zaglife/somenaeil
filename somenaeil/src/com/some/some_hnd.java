package com.some;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.some.some_able;
import com.some.some_service;

public class some_hnd implements some_able {
	
	public String active(HttpServletRequest request, HttpServletResponse response) {

		String part= request.getParameter("part");
		Map<String, some_able> some= null;
		some= get_Map();
		
		String view= null;
		
		
		
		return view;
	}
	
	private Map<String, some_able> get_Map() {
		Map<String, some_able> temp= new HashMap<String, some_able>();
		temp.put("sug", new some_service());
		
		
		
		return temp;
	}

}
