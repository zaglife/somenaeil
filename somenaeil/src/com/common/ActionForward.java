package com.common;

/**
 * 포워딩 정보를 저장할 수 있는 ActionForward 클래스
 * @author gagip
 */
public class ActionForward {
	private String path;
	private boolean redirect;
	
	public String getPath() {
		return path;
	}
	
	public void setPath(String path) {
		this.path = path;
	}
	
	public boolean isRedirect() {
		return redirect;
	}
	
	public void setRedirect(boolean redirect) {
		this.redirect = redirect;
	}
}
