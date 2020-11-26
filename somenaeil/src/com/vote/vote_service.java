package com.vote;

import javax.servlet.http.HttpServletRequest;

import com.member.member;

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
		String title = request.getParameter("title");
		String[] temp = request.getParameterValues("items");
		
		
		String items = "";
		if(temp != null) {
			for (int i = 0; i < temp.length; i++) {
				items+= temp[i];
			}
			items += temp[temp.length-1];			
		}
		vote_dao vd = new vote_dao();
		
		int muit = 0;
		int hidden = 0;
		int stat = 0;
		int date = 0;
		String day = null;
		String[] temp2 = request.getParameterValues("choice");
		String choice = "";
		if(temp2 != null) {
			for(int i = 0; i < temp2.length; i++) {
				if(temp2[i].equals("muit")) 
					muit = 1;
				else if(temp2[i].equals("hidden")) {
					hidden = 1;
					
					// 생각을 해보니 투표를 만들때는 detail table을 건들 필요가 없다 하지만 투표가 생성될때마다 회원이름_vote_detail이런식으로 생성되게하는건 
					// 효율적인지 비효율적인지 궁금해졌다.
				}else if(temp2[i].equals("stat"))
					stat = 1;
				else if(temp2[i].equals("date")) {
					date = 1;
					day = request.getParameter("day");
				}
			}
		}
		
		
		
		vd.add(nick, title, items, muit, stat, hidden, date, day);
		
	}
	
	
	
	
}
