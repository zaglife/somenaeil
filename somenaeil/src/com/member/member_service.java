package com.member;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;

import com.main.main_able;

public class member_service implements main_able {
			private  HttpServletRequest request;
			
			public member_service() { }
			public member_service(HttpServletRequest request) { 
				this.request=request;
			}
			public void join{
				String id=request.getParameter("id");
				String pw=request.getParameter("pw");
				String name=request.getParameter("name");
				String nick=request.getParameter("nick");
				String email=request.getParameter("email");
				int cert=Integer.parseInt(request.getParameter("cert"));
				String pimg=request.getParameter("pimg");
				String comt=request.getParameter("comt");
				
				
				member_dao md=new member_dao();
				md.member_insert(id,pw,name,nick,email,cert,pimg,comt);
				
			}
}
