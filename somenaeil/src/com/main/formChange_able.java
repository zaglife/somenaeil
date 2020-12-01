package com.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface formChange_able {
	public String active(HttpServletRequest request, HttpServletResponse response);
	
	public void setPath(String path);
	public String getPath();
}
