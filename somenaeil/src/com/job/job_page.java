package com.job;

import java.util.ArrayList;

public class job_page {
	private int total;
	private int currentPage;
	private ArrayList<job> cont;
	private int totalPage;
	private int startPage;
	private int endPage;
	
	public job_page(	int total,
						int currentPage,
						int size,
						ArrayList<job> cont) {
		this.total= total;
		this.currentPage= currentPage;
		this.cont= cont;
		
		if(total == 0) {
			totalPage= 0;
			startPage= 0;
			endPage= 0;
		} else {
			// 전체 페이지수 / size 에서 나머지 값이 있다면 전체 페이지 수를 1더해준다
			totalPage= total/size;
			if(total%size > 0 ) totalPage++;
			
			int mod= currentPage%10;
			startPage= currentPage/10*10+1;
			
			if(mod == 0) startPage-= 10;
			
			endPage= startPage+9;
			if(endPage > totalPage) endPage= totalPage;
		}
	}
	
	// boolean 타입으로 만든 메소드의 이름앞에 (일반적으로) has를 붙여준다
	// 전체 게시글의 수가 0이 아니라면 true를 retrun, 게시물의 개수가 0이라면 false를 return
	public boolean hasPage() {
		return total!=0;
	}
	
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public ArrayList<job> getCont() {
		return cont;
	}
	public void setCont(ArrayList<job> cont) {
		this.cont = cont;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
}
