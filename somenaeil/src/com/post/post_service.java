package com.post;

import javax.servlet.http.HttpServletRequest;

/**
 * 요청한 post 데이터를 클라이언트에게 반환
 * @author gagip
 *
 */
public class post_service {
	private HttpServletRequest request;
	
	public post_service(HttpServletRequest request) {
		this.request=request;
	}
	
	// 
}
