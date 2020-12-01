package com.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.main.main_able;

public class memberForm_hnd implements main_able {
	private String path = null;
	
	public void setPath(String path) {
		this.path = path;
	}
	
	public String getPath() {
		return path;
	}
	
	@Override
	public String active(HttpServletRequest request, HttpServletResponse response) {
		
		String path = null;
		
		return path;
	}
	
}
