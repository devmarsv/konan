package com.kn.clv.member.model.vo;

public class FindBoardAndReply {
	
	private int currentPage;
	private String userid;
	
	public FindBoardAndReply() {
		super();
	}

	public FindBoardAndReply(int currentPage, String userid) {
		super();
		if(currentPage == 1) {
			this.currentPage = currentPage;
		}else {
			this.currentPage = currentPage*10-9;
		}
		this.userid = userid;
	}
	
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	@Override
	public String toString() {
		return "FindBoardAndReply [currentPage=" + currentPage + ", userid=" + userid + "]";
	}
	
}
