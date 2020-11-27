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

	public void add() {
		
		
		String nick = ((member)request.getSession().getAttribute("user")).getName();
		
		
		String path = "\\user_img";
		int size = 10*1024*1024;
		String title = null;
		String[] temp = null;
		String items = "";
		int muit = 0;
		int hidden = 0;
		int stat = 0;
		int date = 0;
		String day = null;
		String[] temp2 = null;
		
		
		
		try {
			MultipartRequest multi = new MultipartRequest(request, path, size, "UTF-8", new DefaultFileRenamePolicy());
			
			title = multi.getParameter("title");
			temp = request.getParameterValues("items");
			if(temp != null) {
				for(int i = 0; i < temp.length; i++) {
					items += temp[i] +",";
				}
				items += temp[temp.length-1];
			}
					
			
			temp2 = multi.getParameterValues("choice");
			if(temp2 != null) {
				for(int i = 0; i < temp2.length; i++) {
					if(temp2[i].equals("muit")) 
						muit = 1;
					else if(temp2[i].equals("hidden")) {
						hidden = 1;				
					}else if(temp2[i].equals("stat"))
						stat = 1;
					else if(temp2[i].equals("date")) {
						date = 1;
						day = multi.getParameter("day");
					}
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("이미지 저장 실패");
		}		
		
		vote_dao vd = new vote_dao();
		vd.add(nick, title, items, muit, stat, hidden, date, day);
		
		}
		
		
	}
	
	
	
	

