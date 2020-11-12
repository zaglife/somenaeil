package com.post;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface post_able {
	public abstract String active(HttpServletRequest request,
			HttpServletResponse response);
}
