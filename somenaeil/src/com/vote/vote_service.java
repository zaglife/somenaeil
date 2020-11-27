package com.vote;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import com.member.member;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * 요청한 vote 데이터를 클라이언트에게 반환
 * @author gagip
 *
 */
public class vote_service {
	private HttpServletRequest request;
	
	public vote_service(HttpServletRequest request) {
		this.request=request;
	}

	
}
	
	
	
	

